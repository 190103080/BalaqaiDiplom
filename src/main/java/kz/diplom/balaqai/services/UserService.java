package kz.diplom.balaqai.services;

import kz.diplom.balaqai.dto.UserDto;
import kz.diplom.balaqai.models.Permission;
import kz.diplom.balaqai.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    boolean registerUser(UserDto userDto);
    void updatePassword(String oldPassword, String newPassword, String retypePassword);
    User getCurrentUser();
    User saveUserData(User user);
    List<User> getUsers();
    User getUser(Long id);
    List<Permission> getRoles();
    User saveRole(User user);

    void deleteUser(Long id);

}
