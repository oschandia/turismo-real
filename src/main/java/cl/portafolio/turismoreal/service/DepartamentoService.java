package cl.portafolio.turismoreal.service;

import cl.portafolio.turismoreal.dao.Departamento;

import java.util.List;

public interface DepartamentoService {
    List<Departamento> getAllDepartamentos();
    Departamento findById(Long id);
}
