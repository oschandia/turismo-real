package cl.portafolio.turismoreal.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class ReservaDto {

    private Long estadoReserva;

    private Long departamentoId;

    private String usuario;

    private String checkin;

    private String checkout;

    private int adults;

    private int childs;

    private int cantidadNoches;

    private int valorReserva;

    private int abonoReserva;

    private int montoPendienteReserva;

    private String rut;

    private String nombre;

    private String apellido;

    private String fechaNacimiento;
}
