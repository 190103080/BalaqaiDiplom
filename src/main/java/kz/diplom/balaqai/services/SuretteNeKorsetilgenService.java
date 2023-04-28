package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.SuretteNeKorsetilgen;

import java.util.List;

public interface SuretteNeKorsetilgenService {

    SuretteNeKorsetilgen saveSuretteNeKorsetilgen(SuretteNeKorsetilgen suretteNe);
    SuretteNeKorsetilgen getCurrentType();
    List<SuretteNeKorsetilgen> getAllData();
    SuretteNeKorsetilgen getOneData(Long id);
    SuretteNeKorsetilgen addData(SuretteNeKorsetilgen suretteNeKorsetilgen);
    void deleteOneData(Long id);

}
