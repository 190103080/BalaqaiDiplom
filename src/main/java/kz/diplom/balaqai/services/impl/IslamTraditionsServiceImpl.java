package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.IslamTraditions;
import kz.diplom.balaqai.repository.IslamTraditionsRepostitory;
import kz.diplom.balaqai.services.IslamTraditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslamTraditionsServiceImpl implements IslamTraditionsService {

    @Autowired
    private IslamTraditionsRepostitory islamTraditionsRepostitory;

    @Override
    public void deleteIslamTradition(Long id) {
        islamTraditionsRepostitory.deleteById(id);
    }

    @Override
    public IslamTraditions saveIslamTradition(IslamTraditions islamTraditions) {
        return islamTraditionsRepostitory.save(islamTraditions);
    }

    @Override
    public List<IslamTraditions> getAllIslamTraditions() {
        return islamTraditionsRepostitory.findAll();
    }

    @Override
    public IslamTraditions getOneIslamTraditions(Long id) {
        return islamTraditionsRepostitory.findById(id).orElseThrow();
    }
}
