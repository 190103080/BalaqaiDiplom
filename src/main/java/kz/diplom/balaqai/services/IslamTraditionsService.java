package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.IslamTraditions;

import java.util.List;

public interface IslamTraditionsService {

    void deleteIslamTradition(Long id);
    IslamTraditions saveIslamTradition(IslamTraditions islamTraditions);
    List<IslamTraditions> getAllIslamTraditions();
    IslamTraditions getOneIslamTraditions(Long id);

}
