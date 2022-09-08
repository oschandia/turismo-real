package cl.portafolio.turismoreal.rest.controller;

import cl.portafolio.turismoreal.service.impl.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartamentoController {

    @Autowired
    private DepartamentoServiceImpl departamentoService;

    @GetMapping("/departments")
    public String viewHomePage(Model model){
        model.addAttribute("departamentos", departamentoService.getAllDepartamentos());
        return "departments";
    }
}
