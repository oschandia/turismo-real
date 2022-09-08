package cl.portafolio.turismoreal.repositorio;

import cl.portafolio.turismoreal.dao.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String mail);
}
