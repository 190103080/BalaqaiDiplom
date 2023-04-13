package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.TraditionsOfRaisingADowry;

import java.util.List;

public interface TraditionsOfRaisingADowryService {

    void deleteTraditionOfRaisingADowry(Long id);
    List<TraditionsOfRaisingADowry> getAllTraditionsOfRaisingADowry();
    TraditionsOfRaisingADowry getOneTraditionOfRaisingADowry(Long id);
    TraditionsOfRaisingADowry saveTraditionOfRaisingADowry(TraditionsOfRaisingADowry traditionsOfRaisingADowry);

    TraditionsOfRaisingADowry getCurrentTraditionsOfRaising();

}
