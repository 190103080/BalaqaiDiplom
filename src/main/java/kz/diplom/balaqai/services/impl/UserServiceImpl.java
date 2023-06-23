package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.component.PasswordResetLinkGenerator;
import kz.diplom.balaqai.config.JwtUtils;
import kz.diplom.balaqai.dto.UserDto;
import kz.diplom.balaqai.models.PasswordResetRequest;
import kz.diplom.balaqai.models.Permission;
import kz.diplom.balaqai.models.User;
import kz.diplom.balaqai.repository.PasswordResetRequestRepository;
import kz.diplom.balaqai.repository.PermissionRepository;
import kz.diplom.balaqai.repository.UserRepository;
import kz.diplom.balaqai.services.UserService;
import org.hibernate.transform.PassThroughResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PasswordResetLinkGenerator passwordResetLinkGenerator;
    @Autowired
    private PasswordResetRequestRepository passwordResetRequestRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean registerUser(UserDto userDto) {
        if (userDto.getPassword().equals(userDto.getRetypePassword())) {
            User checkUser = userRepository.findByEmail(userDto.getEmail());
            if (checkUser == null) {
                Permission permission = permissionRepository.findByName("ROLE_USER");
                User user = new User();
                user.setEmail(userDto.getEmail());
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                List<Permission> permissions = new ArrayList<>();
                permissions.add(permission);
                User newUser = userRepository.save(user);
                return newUser.getId() != null;
            }
        }
        return false;
    }

    @Override
    public User updatePassword(String oldPassword, String newPassword, HttpServletRequest request) {
        String token = jwtUtils.getTokenFromRequest(request);
        String username = jwtUtils.getUsernameFromToken(token);
        User user = userRepository.findByEmail(username);
        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }

    @Override
    public User saveUserData(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Permission> getRoles() {
        return permissionRepository.findAll();
    }

    @Override
    public User saveRole(User user) {
        User checkUser = userRepository.findById(user.getId()).orElseThrow();

        if (checkUser != null) {
            Permission permission = permissionRepository.findByName("ROLE_USER");

            List<Permission> permissions = new ArrayList<>();
            permissions.add(permission);
            checkUser.setPermissionList(permissions);

            return userRepository.save(checkUser);
        }
        return null;
    }

    @Override
    public ResponseEntity<String> reset(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());
        if(user != null){
            String resetLink = passwordResetLinkGenerator.generatePasswordResetLink(user.getEmail());

            while (true) {
                PasswordResetRequest old = passwordResetRequestRepository.findByEmail(user.getEmail());
                if (old != null) {
                    passwordResetRequestRepository.delete(old);
                } else {
                    break;
                }
            }

            PasswordResetRequest passwordResetRequest = new PasswordResetRequest(user.getEmail(), resetLink);
            passwordResetRequestRepository.save(passwordResetRequest);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("${spring.mail.username}");
            message.setTo(user.getEmail());
            message.setSubject("Password Reset Request");
            message.setText("Dear " + user.getUsername() + ",\n\n" +
                    "You recently requested a password reset for your account on Sura.kz. " +
                    "If you did not make this request, please ignore this message. " +
                    "Otherwise, click the following link to reset your password:\n\n" +
                    resetLink + "\n\n" +
                    "This link will expire in 24 hours.\n\n" +
                    "Sincerely,\n" +
                    "Sura.kz Support Team");

            mailSender.send(message);

            return ResponseEntity.ok("Password reset email send");
        }
        return null;
    }

    @Override
    public User resetPass(UserDto userDto, String email, String token, String expires) {
        User user = userRepository.findByEmail(passwordResetLinkGenerator.decodeEmail(email));
        if(user == null){
            return null;
        }
        System.out.println(user.getEmail());
        PasswordResetRequest passwordResetRequest = passwordResetRequestRepository.findByEmail(user.getEmail());

        if(passwordResetRequest == null){
            return null;
        }

        if (Instant.now().getEpochSecond() > Long.parseLong(expires)) {
            passwordResetRequestRepository.delete(passwordResetRequest);
            return null;
        }

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        passwordResetRequestRepository.delete(passwordResetRequest);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserDto userDto, HttpServletRequest request) {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            return null;
        }
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setAge(userDto.getAge());
        user.setContact(userDto.getContact());
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return user;
    }
}
