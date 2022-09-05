package cl.portafolio.turismoreal.service;

import cl.portafolio.turismoreal.dao.Acompañante;
import cl.portafolio.turismoreal.dao.Departamento;
import cl.portafolio.turismoreal.repositorio.AcompañanteRepository;
import cl.portafolio.turismoreal.repositorio.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcompañanteServiceImpl implements AcompañanteService{

    @Autowired
    private AcompañanteRepository acompañanteRepository;

    @Override
    public List<Acompañante> getAllCompanions() {
        return acompañanteRepository.findAll();
    }
}
