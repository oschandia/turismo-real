package cl.portafolio.turismoreal.rest.controller;

import cl.portafolio.turismoreal.domain.UsuarioDto;
import cl.portafolio.turismoreal.service.DepartamentoServiceImpl;
import cl.portafolio.turismoreal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UsuarioRegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UsuarioDto());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UsuarioDto usuarioDto){
        usuarioService.save(usuarioDto);
        return "redirect:/registration?success";
    }
}
