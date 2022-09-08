package cl.portafolio.turismoreal.service.impl;

import cl.portafolio.turismoreal.dao.Departamento;
import cl.portafolio.turismoreal.repositorio.DepartamentoRepository;
import cl.portafolio.turismoreal.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento findById(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }
}
