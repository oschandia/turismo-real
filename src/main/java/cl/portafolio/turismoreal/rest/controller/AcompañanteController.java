package cl.portafolio.turismoreal.rest.controller;

import cl.portafolio.turismoreal.service.impl.AcompañanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
