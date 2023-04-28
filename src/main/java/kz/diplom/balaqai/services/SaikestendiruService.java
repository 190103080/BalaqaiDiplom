package kz.diplom.balaqai.services;

import kz.diplom.balaqai.models.Saikestendiru;

import java.util.List;

public interface SaikestendiruService {

    List<Saikestendiru> getAllSaikestendiru();
    Saikestendiru getOneSaikestendiru(Long id);

}
