package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.TraditionsAndCustomsOfEducation;

import java.util.List;

public interface TraditionsAndCustomersOfEducationService {

    void deleteTraditionsAndCustomersOfEducation(Long id);
    List<TraditionsAndCustomsOfEducation> getAllTraditionAndCustomersOfEducation();
    TraditionsAndCustomsOfEducation getOneTraditionAndCustomersOfEducation(Long id);
    TraditionsAndCustomsOfEducation saveTraditionAndCustomersOfEducation(TraditionsAndCustomsOfEducation traditionsAndCustomsOfEducation);
    TraditionsAndCustomsOfEducation getCurrentTraditionsAndCustomers();

}
