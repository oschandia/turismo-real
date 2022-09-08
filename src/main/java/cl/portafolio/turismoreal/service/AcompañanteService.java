package cl.portafolio.turismoreal.service;

import cl.portafolio.turismoreal.dao.Acompañante;
import cl.portafolio.turismoreal.dao.Departamento;

import java.util.List;

public interface AcompañanteService {
    List<Acompañante> getAllCompanions();
    Acompañante save(Acompañante acompañante);
}
