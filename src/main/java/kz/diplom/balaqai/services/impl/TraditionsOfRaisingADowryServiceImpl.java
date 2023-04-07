package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.TraditionsOfRaisingADowry;
import kz.diplom.balaqai.services.repository.TraditionsOfRaisingADowryRepository;
import kz.diplom.balaqai.services.TraditionsOfRaisingADowryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraditionsOfRaisingADowryServiceImpl implements TraditionsOfRaisingADowryService {

    @Autowired
    private TraditionsOfRaisingADowryRepository traditionsOfRaisingADowryRepository;

    @Override
    public void deleteTraditionOfRaisingADowry(Long id) {
        traditionsOfRaisingADowryRepository.deleteById(id);
    }

    @Override
    public List<TraditionsOfRaisingADowry> getAllTraditionsOfRaisingADowry() {
        return traditionsOfRaisingADowryRepository.findAll();
    }

    @Override
    public TraditionsOfRaisingADowry getOneTraditionOfRaisingADowry(Long id) {
        return traditionsOfRaisingADowryRepository.findById(id).orElseThrow();
    }

    @Override
    public TraditionsOfRaisingADowry saveTraditionOfRaisingADowry(TraditionsOfRaisingADowry traditionsOfRaisingADowry) {
        return traditionsOfRaisingADowryRepository.save(traditionsOfRaisingADowry);
    }
}
