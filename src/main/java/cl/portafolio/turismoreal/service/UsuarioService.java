package cl.portafolio.turismoreal.service;

import cl.portafolio.turismoreal.dao.Usuario;
import cl.portafolio.turismoreal.domain.UsuarioDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioService extends UserDetailsService {
    Usuario save(UsuarioDto usuarioDto);
    Usuario findByUsername(String username);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
