package cl.portafolio.turismoreal.mapper;

import cl.portafolio.turismoreal.dao.Reserva;
import cl.portafolio.turismoreal.domain.ReservaDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Component
public class ReservaDtoToReservaMapper {

    public Reserva map(ReservaDto reservaDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate checkin = LocalDate.parse(reservaDto.getCheckin());
        LocalDate checkout = LocalDate.parse(reservaDto.getCheckout());

        int noches = (int) ChronoUnit.DAYS.between(checkin,checkout);

        return Reserva.builder()
                .abonoReserva(0)
                .cantidadNoches(noches)
                .checkin(checkin)
                .checkout(checkout)
                .estadoReserva(1L)
                .build();
    }
}
