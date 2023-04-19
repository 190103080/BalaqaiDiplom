package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.FamilyTraditions;
import kz.diplom.balaqai.repository.FamilyTraditionsRepository;
import kz.diplom.balaqai.services.FamilyTraditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyTraditionsServiceImpl implements FamilyTraditionsService {

    @Autowired
    private FamilyTraditionsRepository familyTraditionsRepository;

    @Override
    public FamilyTraditions saveFamilyTradition(FamilyTraditions familyTraditions) {
        return familyTraditionsRepository.save(familyTraditions);
    }

    @Override
    public List<FamilyTraditions> getFamilyTraditions() {
        return familyTraditionsRepository.findAll();
    }

    @Override
    public FamilyTraditions getFamilyTradition(Long id) {
        return familyTraditionsRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteFamilyTradition(Long id) {
        familyTraditionsRepository.deleteById(id);
    }

    @Override
    public FamilyTraditions getCurrentTradition() {
        return null;
    }

//    @Override
//    public FamilyTraditions getFamilyTraditionImage(String image) {
//        return familyTraditionsRepository.;
//    }
}
