package cl.portafolio.turismoreal.service.impl;

import cl.portafolio.turismoreal.dao.Perfil;
import cl.portafolio.turismoreal.repositorio.PerfilRepository;
import cl.portafolio.turismoreal.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public Perfil findById(Long id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.orElse(null);
    }
}
