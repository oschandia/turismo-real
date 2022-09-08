package cl.portafolio.turismoreal.rest.controller;

import cl.portafolio.turismoreal.service.impl.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private DepartamentoServiceImpl departamentoService;

    @GetMapping
    public String showReservationPage(Model model, @RequestParam Long id) {
        model.addAttribute("depto", departamentoService.findById(id));
        return "reservation";
    }
}
