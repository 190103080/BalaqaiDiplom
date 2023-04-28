package kz.diplom.balaqai.services.impl;

import kz.diplom.balaqai.models.JasyrylganZattar;
import kz.diplom.balaqai.repository.JasyrylganZattarRepository;
import kz.diplom.balaqai.services.JasyrylganZattarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JasyrylganZattarServiceImpl implements JasyrylganZattarService {

    private final JasyrylganZattarRepository jasyrylganZattarRepository;

    @Override
    public List<JasyrylganZattar> getAllJasyrylganZattar() {
        return jasyrylganZattarRepository.findAll();
    }

    @Override
    public JasyrylganZattar getOneJasyrylganZattar(Long id) {
        return jasyrylganZattarRepository.findById(id).orElseThrow();
    }
}
