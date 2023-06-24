package kz.diplom.balaqai.api;

import kz.diplom.balaqai.config.JwtUtils;
import kz.diplom.balaqai.dto.UserDto;
import kz.diplom.balaqai.models.User;
import kz.diplom.balaqai.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    @GetMapping(value = "/allUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/getUser/{user_email}")
    public User getUser(@PathVariable(name = "user_email") String email) {
        return userService.getUser(email);
    }

    @PostMapping(value = "/addUser")
    public User addUser(@RequestBody User user) {
        return userService.saveUserData(user);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
    }

    @PostMapping(value = "/reset")
    public ResponseEntity<String> resetUser(@RequestBody UserDto userDto) {
        try {
            return userService.reset(userDto);
            //return new ResponseEntity<Object> (user, HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/reset_pass")
    public ResponseEntity<Object> resetPassByLink(@RequestBody UserDto userDto,
                                                  @RequestParam(required = true) String email,
                                                  @RequestParam(required = true) String token,
                                                  @RequestParam(required = true) String expires) {
        try {
            User user = userService.resetPass(userDto, email, token, expires);
            if (user != null) {
                token = jwtUtils.generateToken(user.getUsername());
                return new ResponseEntity<Object>(new UserResponse(token, user), HttpStatus.OK);
            }
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/update_password")
    public ResponseEntity<Object> updatePassword(@RequestBody UserDto userDto, HttpServletRequest request) {
        try {
            User user = userService.updatePassword(userDto.getOldPassword(), userDto.getNewPassword(), request);
            if (user != null) {
                String token = jwtUtils.generateToken(user.getUsername());
                return new ResponseEntity<>(new UserResponse(token, user), HttpStatus.OK);
            }
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
