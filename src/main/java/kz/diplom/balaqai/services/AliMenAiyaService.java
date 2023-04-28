package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.AliMenAiya;

import java.util.List;

public interface AliMenAiyaService {

    List<AliMenAiya> getAllAliMenAiya();
    AliMenAiya getOneAliMenAiya(Long id);

}
