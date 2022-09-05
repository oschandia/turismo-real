package cl.portafolio.turismoreal.rest.controller;

import cl.portafolio.turismoreal.service.AcompañanteServiceImpl;
import cl.portafolio.turismoreal.service.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcompañanteController {

    @Autowired
    private AcompañanteServiceImpl acompañanteService;
/**
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("companionList", acompañanteService.getAllCompanions());
        return "index";
    }
 */
}
