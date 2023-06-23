package kz.diplom.balaqai.controller;

import kz.diplom.balaqai.dto.UserDto;
import kz.diplom.balaqai.models.*;
import kz.diplom.balaqai.services.*;
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

    @Autowired
    private IslamTraditionsService islamTraditionsService;

    @Autowired
    private IslamTraditionFileUploadService islamTraditionFileUploadService;

    @Autowired
    private NauryzTraditionsService nauryzTraditionsService;

    @Autowired
    private NauryzTraditionFileUploadService nauryzTraditionFileUploadService;

    @Autowired
    private TraditionsOfRaisingADowryService traditionsOfRaisingADowryService;

    @Autowired
    private TraditionsOfRaisingADowryFileUploadService traditionsOfRaisingADowryFileUploadService;

    @Autowired
    private TraditionsAndCustomersOfEducationService traditionsAndCustomersOfEducationService;

    @Autowired
    private TraditionsAndCustomersFileUploadService traditionsAndCustomersFileUploadService;

    @Autowired
    private SuretteNeKorsetilgenService suretteNeKorsetilgenService;

    @Autowired
    private SuretteNeKorsetilgenFileUploadService suretteNeKorsetilgenFileUploadService;

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

    /*@PostMapping(value = "/updatepassword")
    public String updatePassword(@RequestParam(name = "old_password") String oldPassword,
                                 @RequestParam(name = "new_password") String newPassword,
                                 @RequestParam(name = "re_new_password") String reNewPassword) {
        userService.updatePassword(oldPassword, newPassword, reNewPassword);
        return "redirect:/profile";
    }*/

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
    public String saveFamilyTradition(@RequestParam(name = "image_pic") MultipartFile multipartFile, FamilyTraditions familyTraditions) {
        FamilyTraditions updateFamilyTradition = familyTraditionsService.saveFamilyTradition(familyTraditions);
        familyTraditionFileUploadService.uploadFamilyTraditionsImage(multipartFile, updateFamilyTradition);
        if(updateFamilyTradition != null) {
            return "redirect:/allFamilyTradition";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/viewpic/{picToken}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody byte[] viewPic(@PathVariable(name = "picToken") String token) throws IOException {
        return familyTraditionFileUploadService.getFamilyTraditionsImage(token);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/allIslamTradition")
    public String allIslamTraition(Model model) {
        model.addAttribute("islamTradition", islamTraditionsService.getAllIslamTraditions());
        return "allIslamTradition";
    }

    @GetMapping(value = "/detailsIslamTradition/{id}")
    public String detailsIslamTradition(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("islamTradition", islamTraditionsService.getOneIslamTraditions(id));
        return "detailsIslamTradition";
    }

    @PostMapping(value = "/saveIslamTradition")
        public String saveIslamTradition(@RequestParam(name = "image_pic") MultipartFile multipartFile, IslamTraditions islamTraditions) {
        IslamTraditions updateIslamTradition = islamTraditionsService.saveIslamTradition(islamTraditions);
        islamTraditionFileUploadService.uploadIslamTraditionsImage(multipartFile, updateIslamTradition);
        if (updateIslamTradition != null) {
            return "redirect:/allIslamTradition";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/viewpic/{picIslamToken}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody byte[] viewIslamTraditionPic(@PathVariable(name = "picIslamToken") String token) throws IOException {
        return islamTraditionFileUploadService.getIslamTraditionsImage(token);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/allNauryzTradition")
    public String allNauryzTradition(Model model) {
        model.addAttribute("nauryzTradition", nauryzTraditionsService.getAllNauryzTraditions());
        return "allnauryzTradition";
    }

    @GetMapping(value = "/detailsNauryzTradition/{id}")
    public String detailsNauryzTradition(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("nauryzTradition", nauryzTraditionsService.getOneNauryzTradition(id));
        return "detailsNauryzTradition";
    }

    @PostMapping(value = "/saveNauryzTradition")
    public String saveNauryzTradition(@RequestParam(name = "image_pic") MultipartFile multipartFile, NauryzTraditions nauryzTraditions) {
        NauryzTraditions updateNauryzTradition = nauryzTraditionsService.saveNauryzTradition(nauryzTraditions);
        nauryzTraditionFileUploadService.uploadNauryzTraditionImage(multipartFile, updateNauryzTradition);
        if (updateNauryzTradition != null) {
            return "redirect:/allNauryzTradition";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/viewpic/{picNauryzToken}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody byte[] viewNauryzTraditionPic(@PathVariable(name = "picNauryzToken") String token) throws IOException {
        return islamTraditionFileUploadService.getIslamTraditionsImage(token);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/allTraditionAndCustomersOfEducation")
    public String allTraditionAndCustomersOfEducation(Model model) {
        model.addAttribute("traditionAndCustomersOfEducation", traditionsAndCustomersOfEducationService.getAllTraditionAndCustomersOfEducation());
        return "allTraditionAndCustomersOfEducation";
    }

    @GetMapping(value = "/detailsTraditionAndCustomersOfEducation/{id}")
    public String detailsTraditionAndCustomersOfEducation(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("traditionAndCustomersOfEducation", traditionsAndCustomersOfEducationService.getOneTraditionAndCustomersOfEducation(id));
        return "detailsTraditionAndCustomersOfEducation";
    }

    @PostMapping(value = "/saveTraditionAndCustomersOfEducation")
    public String saveTraditionAndCustomersOfEducation(@RequestParam(name = "image_pic") MultipartFile multipartFile, TraditionsAndCustomsOfEducation traditionsAndCustomsOfEducation) {
        TraditionsAndCustomsOfEducation updateTraditionAndCustomersOfEducation = traditionsAndCustomersOfEducationService.saveTraditionAndCustomersOfEducation(traditionsAndCustomsOfEducation);
        traditionsAndCustomersFileUploadService.uploadTraditionsAndCustomersImage(multipartFile, updateTraditionAndCustomersOfEducation);
        if (updateTraditionAndCustomersOfEducation != null) {
            return "redirect:/allTraditionAndCustomersOfEducation";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/viewpic/{picTraditionAndCustomersOfEducationToken}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody byte[] viewTraditionAndCustomersOfEducationPic(@PathVariable(name = "picTraditionAndCustomersOfEducationToken") String token) throws IOException {
        return traditionsAndCustomersFileUploadService.getTraditionsAndCustomerImage(token);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/allTraditionsOfRaisingADowry")
    public String allTraditionsOfRaisingADowry(Model model) {
        model.addAttribute("traditionOfRaisingADowry", traditionsOfRaisingADowryService.getAllTraditionsOfRaisingADowry());
        return "allTraditionsOfRaisingADowry";
    }

    @GetMapping(value = "/detailsTraditionsOfRaisingADowry/{id}")
    public String detailsTraditionsOfRaisingADowry(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("traditionOfRaisingADowry", traditionsOfRaisingADowryService.getOneTraditionOfRaisingADowry(id));
        return "detailsTraditionsOfRaisingADowry";
    }

    @PostMapping(value = "/saveTraditionsOfRaisingADowry")
    public String saveTraditionsOfRaisingADowry(@RequestParam(name = "image_pic") MultipartFile multipartFile, TraditionsOfRaisingADowry traditionsOfRaisingADowry) {
        TraditionsOfRaisingADowry updateTraditionsOfRaisingADowry = traditionsOfRaisingADowryService.saveTraditionOfRaisingADowry(traditionsOfRaisingADowry);
        traditionsOfRaisingADowryFileUploadService.uploadTraditionsOfRaisingImage(multipartFile, updateTraditionsOfRaisingADowry);
        if (updateTraditionsOfRaisingADowry != null) {
            return "redirect:/allTraditionsOfRaisingADowry";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/viewpic/{picTraditionsOfRaisingADowryToken}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody byte[] viewTraditionsOfRaisingADowryPic(@PathVariable(name = "picTraditionsOfRaisingADowryToken") String token) throws IOException {
        return traditionsOfRaisingADowryFileUploadService.getTraditionsOfRaisingImage(token);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "/getAllSuretteNeKorsetilgen")
    public String allSuretteNeKorsetilgen(Model model) {
        model.addAttribute("suretteNeKorsetilgen", suretteNeKorsetilgenService.getAllData());
        return "getAllSuretteNeKorsetilgen";
    }

    @GetMapping(value = "/detailsSuretteNeKorsetilgen/{id}")
    public String detailsSuretteNeKorsetilgen(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("suretteNeKorsetilgen", suretteNeKorsetilgenService.getOneData(id));
        return "detailsSuretteNeKorsetilgen";
    }

    @PostMapping(value = "/saveSuretteNeKorsetilgen")
    public String saveSuretteNeKorsetilgen(@RequestParam(name = "image_pic") MultipartFile multipartFile, SuretteNeKorsetilgen suretteNeKorsetilgen) {
        SuretteNeKorsetilgen updateSuretteNeKorsetilgen = suretteNeKorsetilgenService.saveSuretteNeKorsetilgen(suretteNeKorsetilgen);
        suretteNeKorsetilgenFileUploadService.uploadSuretteNeKorsetilgenImage(multipartFile, updateSuretteNeKorsetilgen);
        if (updateSuretteNeKorsetilgen != null) {
            return "redirect:/getAllSuretteNeKorsetilgen";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/viewpic/{picSuretteNeKorsetilgenToken}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody byte[] viewSuretteNeKorsetilgenPic(@PathVariable(name = "picSuretteNeKorsetilgenToken") String token) throws IOException {
        return suretteNeKorsetilgenFileUploadService.getSuretteNeKorsetilgenImage(token);
    }


}
