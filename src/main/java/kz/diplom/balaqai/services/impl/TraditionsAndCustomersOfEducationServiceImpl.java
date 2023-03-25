package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.TraditionsAndCustomsOfEducation;
import kz.diplom.balaqai.repository.TraditionsAndCustomersOfEducationRepository;
import kz.diplom.balaqai.services.TraditionsAndCustomersOfEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraditionsAndCustomersOfEducationServiceImpl implements TraditionsAndCustomersOfEducationService {

    @Autowired
    private TraditionsAndCustomersOfEducationRepository traditionsAndCustomersOfEducationRepository;

    @Override
    public void deleteTraditionsAndCustomersOfEducation(Long id) {
        traditionsAndCustomersOfEducationRepository.deleteById(id);
    }

    @Override
    public List<TraditionsAndCustomsOfEducation> getAllTraditionAndCustomersOfEducation() {
        return traditionsAndCustomersOfEducationRepository.findAll();
    }

    @Override
    public TraditionsAndCustomsOfEducation getOneTraditionAndCustomersOfEducation(Long id) {
        return traditionsAndCustomersOfEducationRepository.findById(id).orElseThrow();
    }

    @Override
    public TraditionsAndCustomsOfEducation saveTraditionAndCustomersOfEducation(TraditionsAndCustomsOfEducation traditionsAndCustomsOfEducation) {
        return traditionsAndCustomersOfEducationRepository.save(traditionsAndCustomsOfEducation);
    }
}
