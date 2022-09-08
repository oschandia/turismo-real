package cl.portafolio.turismoreal.repositorio;

import cl.portafolio.turismoreal.dao.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
