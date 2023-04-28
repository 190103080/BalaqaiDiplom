package kz.diplom.balaqai.api;

import kz.diplom.balaqai.models.AliMenAiya;
import kz.diplom.balaqai.models.JasyrylganZattar;
import kz.diplom.balaqai.models.Saikestendiru;
import kz.diplom.balaqai.models.SuretteNeKorsetilgen;
import kz.diplom.balaqai.services.AliMenAiyaService;
import kz.diplom.balaqai.services.JasyrylganZattarService;
import kz.diplom.balaqai.services.SaikestendiruService;
import kz.diplom.balaqai.services.SuretteNeKorsetilgenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/game")
@RequiredArgsConstructor
public class GameController {

    private final SuretteNeKorsetilgenService suretteNeKorsetilgenService;
    private final AliMenAiyaService aliMenAiyaService;
    private final JasyrylganZattarService jasyrylganZattarService;
    private final SaikestendiruService saikestendiruService;

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

    @GetMapping(value = "/getAllSaikestendiru")
    public List<Saikestendiru> getAllSaikestendiru() {
        return saikestendiruService.getAllSaikestendiru();
    }

    @GetMapping(value = "/getOneSaikestendiru/{id}")
    public Saikestendiru getOneSaikestendiru(@PathVariable(name = "id") Long id) {
        return saikestendiruService.getOneSaikestendiru(id);
    }

    @GetMapping(value = "/getAllJasyrylganZattar")
    public List<JasyrylganZattar> getAllJasyrylganZattar() {
        return jasyrylganZattarService.getAllJasyrylganZattar();
    }

    @GetMapping(value = "/getOneJasyrylganZattar/{id}")
    public JasyrylganZattar getOneJasyrylganZattar(@PathVariable(name = "id") Long id) {
        return jasyrylganZattarService.getOneJasyrylganZattar(id);
    }

    @GetMapping(value = "/getAllAliMenAiya")
    public List<AliMenAiya> getAllAliMenAiya() {
        return aliMenAiyaService.getAllAliMenAiya();
    }

    @GetMapping(value = "/getOneAliMenAiya/{id}")
    public AliMenAiya getOneAliMenAiya(@PathVariable(name = "id") Long id) {
        return aliMenAiyaService.getOneAliMenAiya(id);
    }

}
