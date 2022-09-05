package cl.portafolio.turismoreal.repositorio;

import cl.portafolio.turismoreal.dao.Acompañante;
import cl.portafolio.turismoreal.dao.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcompañanteRepository extends JpaRepository<Acompañante, Long> {

}
