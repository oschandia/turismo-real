package cl.portafolio.turismoreal.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "acompaniante")
public class Acompañante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idacompaniante")
    private Long id;

    @Column(name = "rut")
    private String rut;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;
}
