package cl.portafolio.turismoreal.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_id_seq_gen")
    @SequenceGenerator(name = "usuario_id_seq_gen", sequenceName = "usuario_seq", allocationSize = 1)
    @Column(name = "idusuario")
    private Long id;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "password")
    private String contraseña;

    @Column(name = "estadousuario")
    private int estado;

    @ManyToOne
    @JoinColumn(name = "idperfil")
    private Perfil perfil;

    @Column(name = "mail")
    private String email;
}
