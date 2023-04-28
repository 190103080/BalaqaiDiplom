package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.JasyrylganZattar;

import java.util.List;

public interface JasyrylganZattarService {

    List<JasyrylganZattar> getAllJasyrylganZattar();
    JasyrylganZattar getOneJasyrylganZattar(Long id);

}
