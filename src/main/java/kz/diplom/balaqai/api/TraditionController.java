package kz.diplom.balaqai.api;

import kz.diplom.balaqai.models.*;
import kz.diplom.balaqai.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/tradition")
public class TraditionController {
    @Autowired
    private TraditionsOfRaisingADowryService traditionsOfRaisingADowryService;

    @Autowired
    private FamilyTraditionsService familyTraditionsService;

    @Autowired
    private TraditionsAndCustomersOfEducationService ofEducationService;

    @Autowired
    private NauryzTraditionsService nauryzTraditionsService;

    @Autowired
    private IslamTraditionsService islamTraditionsService;



    @GetMapping(value = "/allTraditionsOfRaisingADowry")
    public List<TraditionsOfRaisingADowry> getAllTraditionsOfRaisingADowry() {
        return traditionsOfRaisingADowryService.getAllTraditionsOfRaisingADowry();
    }

    @GetMapping(value = "/getOneTraditionsOfRaisingADowry/{id}")
    public TraditionsOfRaisingADowry getOneTraditionsOfRaisingADowry(@PathVariable(name = "id") Long id) {
        return traditionsOfRaisingADowryService.getOneTraditionOfRaisingADowry(id);
    }

    @PostMapping(value = "/addTraditionsOfRaisingADowry")
    public TraditionsOfRaisingADowry addTraditionsOfRaisingADowry(@RequestBody TraditionsOfRaisingADowry traditionsOfRaisingADowry) {
        return traditionsOfRaisingADowryService.saveTraditionOfRaisingADowry(traditionsOfRaisingADowry);
    }

    @DeleteMapping(value = "/deleteTraditions/{id}")
    public void deleteTraditionsOfRaisingADowry(@PathVariable(name = "id") Long id) {
        traditionsOfRaisingADowryService.deleteTraditionOfRaisingADowry(id);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping(value = "/allFamilyTraditions")
    public List<FamilyTraditions> getAllFamilyTraditions() {
        return familyTraditionsService.getFamilyTraditions();
    }

    @GetMapping(value = "/getFamilyTradition/{id}")
    public FamilyTraditions getOneFamilyTradition(@PathVariable(name = "id") Long id) {
        return familyTraditionsService.getFamilyTradition(id);
    }

    @PostMapping(value = "/addFamilyTradition")
    public FamilyTraditions addFamilyTradition(@RequestBody FamilyTraditions familyTraditions) {
        return familyTraditionsService.saveFamilyTradition(familyTraditions);
    }

    @DeleteMapping(value = "/deleteFamilyTradition/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void deleteFamilyTradition(@PathVariable(name = "id") Long id, @RequestPart("imageFile") MultipartFile[] file) {
        familyTraditionsService.deleteFamilyTradition(id);
    }

//    @GetMapping(value = "/getFamilyTradition/{id}/{image}")
//    public FamilyTraditions getOneFamilyTraditionImage(@PathVariable(name = "image") String image) {
//        return familyTraditionsService.getFamilyTraditionImage(image);
//    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping(value = "")
    public List<TraditionsAndCustomsOfEducation> getAllCustomsOfEducation() {
        return ofEducationService.getAllTraditionAndCustomersOfEducation();
    }

    @GetMapping(value = "/getOneCustomsOfEducation/{id}")
    public TraditionsAndCustomsOfEducation getOneCustomsOfEducation(@PathVariable(name = "id") Long id) {
        return ofEducationService.getOneTraditionAndCustomersOfEducation(id);
    }

    @PostMapping(value = "/addCustomsOfEducation")
    public TraditionsAndCustomsOfEducation addCustomsOfEducation(@RequestBody TraditionsAndCustomsOfEducation traditionsAndCustomsOfEducation) {
        return ofEducationService.saveTraditionAndCustomersOfEducation(traditionsAndCustomsOfEducation);
    }

    @DeleteMapping(value = "/deleteCustomsOfEducation/{id}")
    public void deleteCustomsOfEducation(@PathVariable(name = "id") Long id) {
        ofEducationService.deleteTraditionsAndCustomersOfEducation(id);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping(value = "/getAllNauryzTraditions")
    public List<NauryzTraditions> getAllNauryz() {
        return nauryzTraditionsService.getAllNauryzTraditions();
    }

    @GetMapping(value = "/getOneNauryzTradition/{id}")
    public NauryzTraditions getOneNauryz(@PathVariable(name = "id") Long id) {
        return nauryzTraditionsService.getOneNauryzTradition(id);
    }

    @PostMapping(value = "/addNauryzTradition")
    public NauryzTraditions addNauryz(@RequestBody NauryzTraditions nauryzTraditions){
        return nauryzTraditionsService.saveNauryzTradition(nauryzTraditions);
    }

    @DeleteMapping(value = "/deleteNauryzTradition/{id}")
    public void deleteNauryz(@PathVariable(name = "id") Long id) {
        nauryzTraditionsService.deleteNauryzTraditions(id);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping(value = "/getAllIslamTraditions")
    public List<IslamTraditions> allIslamTraditions() {
        return islamTraditionsService.getAllIslamTraditions();
    }

    @GetMapping(value = "/getOneIslamTradition/{id}")
    public IslamTraditions getOneIslamTradition(@PathVariable(name = "id") Long id) {
        return islamTraditionsService.getOneIslamTraditions(id);
    }

    @PostMapping(value = "/addIslamTradition")
    public IslamTraditions addIslamTradition(@RequestBody IslamTraditions islamTraditions) {
        return islamTraditionsService.saveIslamTradition(islamTraditions);
    }

    @DeleteMapping(value = "/deleteIslamTradition/{id}")
    public void deleteIslamTradtion(@PathVariable(name = "id") Long id) {
        islamTraditionsService.deleteIslamTradition(id);
    }

}
