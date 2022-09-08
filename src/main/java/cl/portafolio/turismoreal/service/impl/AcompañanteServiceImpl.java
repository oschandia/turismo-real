package cl.portafolio.turismoreal.service.impl;

import cl.portafolio.turismoreal.dao.Acompañante;
import cl.portafolio.turismoreal.repositorio.AcompañanteRepository;
import cl.portafolio.turismoreal.service.AcompañanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcompañanteServiceImpl implements AcompañanteService {

    @Autowired
    private AcompañanteRepository acompañanteRepository;

    @Override
    public List<Acompañante> getAllCompanions() {
        return acompañanteRepository.findAll();
    }

    @Override
    public Acompañante save(Acompañante acompañante) {
        return acompañanteRepository.save(acompañante);
    }
}
