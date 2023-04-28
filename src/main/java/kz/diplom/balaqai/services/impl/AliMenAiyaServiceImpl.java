package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.AliMenAiya;
import kz.diplom.balaqai.repository.AliMenAiyaRepository;
import kz.diplom.balaqai.services.AliMenAiyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AliMenAiyaServiceImpl implements AliMenAiyaService {

    private final AliMenAiyaRepository aliMenAiyaRepository;

    @Override
    public List<AliMenAiya> getAllAliMenAiya() {
        return aliMenAiyaRepository.findAll();
    }

    @Override
    public AliMenAiya getOneAliMenAiya(Long id) {
        return aliMenAiyaRepository.findById(id).orElseThrow();
    }
}
