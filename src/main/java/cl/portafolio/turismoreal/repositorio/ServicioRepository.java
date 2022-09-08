package cl.portafolio.turismoreal.repositorio;

import cl.portafolio.turismoreal.dao.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}
