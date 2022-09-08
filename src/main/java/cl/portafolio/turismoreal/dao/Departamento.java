package cl.portafolio.turismoreal.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "depto_id_seq_gen")
    @SequenceGenerator(name = "depto_id_seq_gen", sequenceName = "departamento_iddepto_seq", allocationSize = 1)
    @Column(name = "iddepto")
    private Long id;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "deptoservicio",
            joinColumns = { @JoinColumn(name = "iddepto") },
            inverseJoinColumns = { @JoinColumn(name = "idservicio") })
    private Set<Servicio> servicios;
}
