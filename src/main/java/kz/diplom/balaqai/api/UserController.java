package kz.diplom.balaqai.api;

import kz.diplom.balaqai.models.User;
import kz.diplom.balaqai.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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

}
