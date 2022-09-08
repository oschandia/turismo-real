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
@Table(name = "serviciosextras")
public class ServiciosExtras {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "servicioextra_id_seq_gen")
    @SequenceGenerator(name = "servicioextra_id_seq_gen", sequenceName = "serviciosextras_idservicioextr", allocationSize = 1)
    @Column(name = "idservicioextra")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "valor")
    private int valor;
}
