package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.FamilyTraditions;

import java.util.List;

public interface FamilyTraditionsService {

    FamilyTraditions saveFamilyTradition(FamilyTraditions familyTraditions);
    List<FamilyTraditions> getFamilyTraditions();
    FamilyTraditions getFamilyTradition(Long id);
    void deleteFamilyTradition(Long id);
    FamilyTraditions getCurrentTradition();

}
