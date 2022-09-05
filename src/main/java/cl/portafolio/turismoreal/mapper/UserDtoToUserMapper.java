package cl.portafolio.turismoreal.mapper;

import cl.portafolio.turismoreal.dao.Usuario;
import cl.portafolio.turismoreal.domain.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserMapper {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario map(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .usuario(usuarioDto.getNombre())
                .contraseña(passwordEncoder.encode(usuarioDto.getPassword()))
                .email(usuarioDto.getEmail())
                .estado(1)
                .build();
    }
}
