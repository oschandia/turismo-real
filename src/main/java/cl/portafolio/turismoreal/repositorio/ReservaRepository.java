package cl.portafolio.turismoreal.repositorio;

import cl.portafolio.turismoreal.dao.Reserva;
import cl.portafolio.turismoreal.dao.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findReservasByServiciosExtrasSet(Long serviciosExtraId);
    List<Reserva> findReservasByAcompañanteSet(Long acompañanteId);
    List<Reserva> findByUsuario(Usuario usuario);
}
