package cl.portafolio.turismoreal.service;

import cl.portafolio.turismoreal.dao.Perfil;
import cl.portafolio.turismoreal.dao.Usuario;
import cl.portafolio.turismoreal.domain.UsuarioDto;
import cl.portafolio.turismoreal.mapper.UserDtoToUserMapper;
import cl.portafolio.turismoreal.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilServiceImpl perfilService;

    @Autowired
    private UserDtoToUserMapper mapper;

    @Override
    public Usuario save(UsuarioDto usuarioDto) {
        Usuario user = mapper.map(usuarioDto);
        Perfil perfil = perfilService.findById(1L);
        user.setPerfil(perfil);
        return usuarioRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new User(usuario.getEmail(), usuario.getContraseña(), mapRolesToAuthorities(usuario.getPerfil()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Perfil perfil) {
        return List.of(new SimpleGrantedAuthority(perfil.getNombre()));
    }
}
