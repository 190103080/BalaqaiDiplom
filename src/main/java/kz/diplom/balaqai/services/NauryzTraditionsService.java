package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.NauryzTraditions;

import java.util.List;

public interface NauryzTraditionsService {

    void deleteNauryzTraditions(Long id);
    List<NauryzTraditions> getAllNauryzTraditions();
    NauryzTraditions getOneNauryzTradition(Long id);
    NauryzTraditions saveNauryzTradition(NauryzTraditions nauryzTraditions);

}
