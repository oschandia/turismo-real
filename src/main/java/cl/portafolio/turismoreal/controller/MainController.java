package cl.portafolio.turismoreal.controller;

import cl.portafolio.turismoreal.service.impl.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private DepartamentoServiceImpl departamentoService;

    @GetMapping("/login")
    public String showRegistrationForm() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("departamentos", departamentoService.getAllDepartamentos());
        return "index";
    }

}
