package cl.portafolio.turismoreal.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddepto")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ESTADODEPTO")
    private EstadoDepartamento estadodepto;

    @Column(name = "valorarriendo")
    private int valor;

    @Column(name = "camas")
    private int camas;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "comuna")
    private String comuna;
}
