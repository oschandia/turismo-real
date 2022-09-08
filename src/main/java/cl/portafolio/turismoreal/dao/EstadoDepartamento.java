package cl.portafolio.turismoreal.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "estadodepto")
public class EstadoDepartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestado")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
}
