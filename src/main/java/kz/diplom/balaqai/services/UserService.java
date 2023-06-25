package kz.diplom.balaqai.services;

import kz.diplom.balaqai.dto.UserDto;
import kz.diplom.balaqai.models.Permission;
import kz.diplom.balaqai.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends UserDetailsService {

    boolean registerUser(UserDto userDto);
    User updatePassword(UserDto userDto, String newPassword, String reNewPassword);
    User getCurrentUser();
    User saveUserData(User user);
    List<User> getUsers();
    User getUser(String email);
    List<Permission> getRoles();
    User saveRole(User user);
    ResponseEntity<String> reset(UserDto userDto);

//    ResponseEntity<String> reset(String email);

    User resetPass(UserDto userDto, String email, String token, String expires);
    User updateUser(UserDto userDto, HttpServletRequest request);
    void deleteUser(Long id);

}
