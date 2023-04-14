package kz.diplom.balaqai.controller;

import kz.diplom.balaqai.dto.UserDto;
import kz.diplom.balaqai.models.FamilyTraditions;
import kz.diplom.balaqai.services.FamilyTraditionFileUploadService;
import kz.diplom.balaqai.services.FamilyTraditionsService;
import kz.diplom.balaqai.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private FamilyTraditionsService familyTraditionsService;

    @Autowired
    private FamilyTraditionFileUploadService familyTraditionFileUploadService;

    @GetMapping(value = "/")
    public String homePage() {
        return "home";
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

    @GetMapping(value = "/allFamilyTradition")
    public String allFamilyTradition(Model model) {
        model.addAttribute("familyTradition", familyTraditionsService.getFamilyTraditions());
        return "allFamilyTradition";
    }

    @GetMapping(value = "/detailsFamilyTradition/{id}")
    public String detailsFamilyTradition(@PathVariable(name = "id") Long id, Model model) {
        FamilyTraditions familyTradition = familyTraditionsService.getFamilyTradition(id);
        model.addAttribute("familyTradition", familyTradition);
        return "detailsFamilyTradition";
    }

    @PostMapping(value = "/saveTradition")
    public String saveeCinema(@RequestParam(name = "image_pic") MultipartFile multipartFile, FamilyTraditions familyTraditions) {
        FamilyTraditions updateCinema = familyTraditionsService.saveFamilyTradition(familyTraditions);
        familyTraditionFileUploadService.uploadFamilyTraditionsImage(multipartFile, updateCinema);
        if(updateCinema != null) {
            return "redirect:/allFamilyTradition";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/viewpic/{picToken}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody byte[] viewPic(@PathVariable(name = "picToken") String token) throws IOException {
        return familyTraditionFileUploadService.getFamilyTraditionsImage(token);
    }

}
