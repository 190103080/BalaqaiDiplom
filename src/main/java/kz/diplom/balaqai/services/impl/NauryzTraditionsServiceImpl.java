package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.NauryzTraditions;
import kz.diplom.balaqai.repository.NauryzTraditionsRepository;
import kz.diplom.balaqai.services.NauryzTraditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NauryzTraditionsServiceImpl implements NauryzTraditionsService {

    @Autowired
    private NauryzTraditionsRepository nauryzTraditionsRepository;

    @Override
    public void deleteNauryzTraditions(Long id) {
        nauryzTraditionsRepository.deleteById(id);
    }

    @Override
    public List<NauryzTraditions> getAllNauryzTraditions() {
        return nauryzTraditionsRepository.findAll();
    }

    @Override
    public NauryzTraditions getOneNauryzTradition(Long id) {
        return nauryzTraditionsRepository.findById(id).orElseThrow();
    }

    @Override
    public NauryzTraditions saveNauryzTradition(NauryzTraditions nauryzTraditions) {
        return nauryzTraditionsRepository.save(nauryzTraditions);
    }
}
