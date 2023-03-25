package kz.diplom.balaqai.api;

import kz.diplom.balaqai.models.FamilyTraditions;
import kz.diplom.balaqai.models.TraditionsOfRaisingADowry;
import kz.diplom.balaqai.services.FamilyTraditionsService;
import kz.diplom.balaqai.services.TraditionsOfRaisingADowryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tradition")
public class TraditionController {
    @Autowired
    private TraditionsOfRaisingADowryService traditionsOfRaisingADowryService;

    @Autowired
    private FamilyTraditionsService familyTraditionsService;

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

    @DeleteMapping(value = "/deleteFamilyTradition/{id}")
    public void deleteFamilyTradition(@PathVariable(name = "id") Long id) {
        familyTraditionsService.deleteFamilyTradition(id);
    }

}
