package cl.portafolio.turismoreal.service;

import cl.portafolio.turismoreal.dao.Reserva;
import cl.portafolio.turismoreal.domain.ReservaDto;

import java.text.ParseException;

public interface ReservationService {
    Reserva save(ReservaDto reservaDto) throws ParseException;
}
