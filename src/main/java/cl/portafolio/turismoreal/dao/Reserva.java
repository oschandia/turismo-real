package cl.portafolio.turismoreal.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "reserva_id_seq_gen")
    @SequenceGenerator(name = "reserva_id_seq_gen", sequenceName = "cliente_idcliente_seq", allocationSize = 1)
    @Column(name = "idreserva")
    private Long id;

    @Column(name = "idestadoreserva")
    private Long estadoReserva;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "iddepto")
    private Departamento departamento;

    @Column(name = "fechainicio")
    private LocalDate checkin;

    @Column(name = "fechatermino")
    private LocalDate checkout;

    @Column(name = "cantidadnoches")
    private int cantidadNoches;

    @Column(name = "valorreserva")
    private int valorReserva;

    @Column(name = "abonoreserva")
    private int abonoReserva;

    @Column(name = "montopendientereserva")
    private int montoPendienteReserva;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "servicioreserva",
            joinColumns = { @JoinColumn(name = "idreserva") },
            inverseJoinColumns = { @JoinColumn(name = "idservicioextra") })
    private Set<ServiciosExtras> serviciosExtrasSet;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "acompaniantereserva",
            joinColumns = { @JoinColumn(name = "idreserva") },
            inverseJoinColumns = { @JoinColumn(name = "idacompaniante") })
    private Set<Acompañante> acompañanteSet;
}
