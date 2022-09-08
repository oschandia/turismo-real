package cl.portafolio.turismoreal.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cliente_id_seq_gen")
    @SequenceGenerator(name = "cliente_id_seq_gen", sequenceName = "cliente_idcliente_seq", allocationSize = 1)
    @Column(name = "idcliente")
    private Long id;

    @Column(name = "rut")
    private String rut;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "idestado")
    private int estado;

    @Column(name = "fechanacimento")
    private LocalDate fechaNacimiento;
}
