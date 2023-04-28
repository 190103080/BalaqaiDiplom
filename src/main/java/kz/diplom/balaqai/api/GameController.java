package kz.diplom.balaqai.api;

import kz.diplom.balaqai.models.SuretteNeKorsetilgen;
import kz.diplom.balaqai.services.SuretteNeKorsetilgenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private SuretteNeKorsetilgenService suretteNeKorsetilgenService;

    @GetMapping(value = "/getAllSuretteNeKorsetilgen")
    public List<SuretteNeKorsetilgen> getAllData() {
        return suretteNeKorsetilgenService.getAllData();
    }

    @GetMapping(value = "/getOneSuretteNeKorsetilgen/{id}")
    public SuretteNeKorsetilgen getOneData(@PathVariable(name = "id") Long id) {
        return suretteNeKorsetilgenService.getOneData(id);
    }

    @PostMapping(value = "/saveData")
    public SuretteNeKorsetilgen saveData(@RequestBody SuretteNeKorsetilgen suretteNeKorsetilgen) {
        return suretteNeKorsetilgenService.saveSuretteNeKorsetilgen(suretteNeKorsetilgen);
    }

    @DeleteMapping(value = "/deleteOneSuretteNeKorsetilgen/{id}")
    public void deleteSuretteNeKorsetilgen(@PathVariable(name = "id") Long id) {
        suretteNeKorsetilgenService.deleteOneData(id);
    }

}
