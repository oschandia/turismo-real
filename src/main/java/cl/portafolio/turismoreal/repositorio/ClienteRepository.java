package cl.portafolio.turismoreal.repositorio;

import cl.portafolio.turismoreal.dao.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
