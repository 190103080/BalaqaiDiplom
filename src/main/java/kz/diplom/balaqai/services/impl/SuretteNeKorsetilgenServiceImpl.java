package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.SuretteNeKorsetilgen;
import kz.diplom.balaqai.repository.SuretteNeKorsetilgenRepository;
import kz.diplom.balaqai.services.SuretteNeKorsetilgenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuretteNeKorsetilgenServiceImpl implements SuretteNeKorsetilgenService {

    @Autowired
    private SuretteNeKorsetilgenRepository suretteNeKorsetilgenRepository;

    @Override
    public SuretteNeKorsetilgen saveSuretteNeKorsetilgen(SuretteNeKorsetilgen suretteNeKorsetilgen) {
        return suretteNeKorsetilgenRepository.save(suretteNeKorsetilgen);
    }

    @Override
    public SuretteNeKorsetilgen getCurrentType() {
        return null;
    }

    @Override
    public List<SuretteNeKorsetilgen> getAllData() {
        return suretteNeKorsetilgenRepository.findAll();
    }

    @Override
    public SuretteNeKorsetilgen getOneData(Long id) {
        return suretteNeKorsetilgenRepository.findById(id).orElseThrow();
    }

    @Override
    public SuretteNeKorsetilgen addData(SuretteNeKorsetilgen suretteNeKorsetilgen) {
        return suretteNeKorsetilgenRepository.save(suretteNeKorsetilgen);
    }

    @Override
    public void deleteOneData(Long id) {
        suretteNeKorsetilgenRepository.deleteById(id);
    }
}
