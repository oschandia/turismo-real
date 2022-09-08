package cl.portafolio.turismoreal.service;

import cl.portafolio.turismoreal.dao.Cliente;
import cl.portafolio.turismoreal.domain.ReservaDto;

import java.text.ParseException;

public interface ClienteService {
    Cliente save(ReservaDto reservaDto) throws ParseException;
}
