package cl.portafolio.turismoreal.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "servicio_id_seq_gen")
    @SequenceGenerator(name = "servicio_id_seq_gen", sequenceName = "servicio_idservicio_seq", allocationSize = 1)
    @Column(name = "idservicio")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "valorservicio")
    private int valor;

}
