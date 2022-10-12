package cl.portafolio.turismoreal.service;

import cl.portafolio.turismoreal.dao.Reserva;
import cl.portafolio.turismoreal.domain.ReservaDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.text.ParseException;
import java.util.List;

public interface ReservationService {
    Reserva findById(Long reservaId) throws Exception;
    Reserva save(ReservaDto reservaDto) throws ParseException;
    public List<Reserva> getAllReservationsByUsername(String username);
    List<Reserva> getAllReservations();
    void cancelReservation(Long idReserva);
}
