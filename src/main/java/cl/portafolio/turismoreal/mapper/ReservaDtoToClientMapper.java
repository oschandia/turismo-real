package cl.portafolio.turismoreal.mapper;

import cl.portafolio.turismoreal.dao.Cliente;
import cl.portafolio.turismoreal.domain.ReservaDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReservaDtoToClientMapper {

    public Cliente map(ReservaDto reservaDto) {
        return Cliente.builder()
                .estado(1)
                .rut(reservaDto.getRut())
                .nombre(reservaDto.getNombre())
                .apellido(reservaDto.getApellido())
                .fechaNacimiento(LocalDate.parse(reservaDto.getFechaNacimiento()))
                .build();
    }
}
