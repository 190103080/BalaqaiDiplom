package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.Saikestendiru;
import kz.diplom.balaqai.repository.SaikestendiruRepository;
import kz.diplom.balaqai.services.SaikestendiruService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SikestendiruServiceImpl implements SaikestendiruService {

    private final SaikestendiruRepository saikestendiruRepository;


    @Override
    public List<Saikestendiru> getAllSaikestendiru() {
        return saikestendiruRepository.findAll();
    }

    @Override
    public Saikestendiru getOneSaikestendiru(Long id) {
        return saikestendiruRepository.findById(id).orElseThrow();
    }
}
