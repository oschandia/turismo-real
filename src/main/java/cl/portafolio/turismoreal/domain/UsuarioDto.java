package cl.portafolio.turismoreal.domain;

import lombok.Data;

@Data
public class UsuarioDto {

    private String nombre;

    private String password;

    private String email;
}
