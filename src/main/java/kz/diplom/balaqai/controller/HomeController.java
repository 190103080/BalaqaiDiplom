package kz.diplom.balaqai.controller;

import kz.diplom.balaqai.dto.UserDto;
import kz.diplom.balaqai.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String homePage() {
        return "index";
    }

    @GetMapping(value = "/enter")
    public String enterPage() {
        return "enter";
    }

    @GetMapping(value = "/signup")
    public String signUpPage() {
        return "signup";
    }

    @PostMapping(value = "/signup")
    public String signUP(UserDto userDto) {
        if (userService.registerUser(userDto)) {
            return "redirect:/signup?success";
        }
            return "redirect:/signup?error";
    }

    @PostMapping(value = "/updatepassword")
    public String updatePassword(@RequestParam(name = "old_password") String oldPassword,
                                 @RequestParam(name = "new_password") String newPassword,
                                 @RequestParam(name = "re_new_password") String reNewPassword) {
        userService.updatePassword(oldPassword, newPassword, reNewPassword);
        return "redirect:/profile";
    }

    @GetMapping(value = "/profile")
    @PreAuthorize("isAuthenticated()")
    public String profilePage() {
        return "profile";
    }

}
