package cl.portafolio.turismoreal.rest.controller;

import cl.portafolio.turismoreal.domain.UsuarioDto;
import cl.portafolio.turismoreal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String showRegistrationForm() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

}
