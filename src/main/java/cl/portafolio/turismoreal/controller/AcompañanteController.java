package cl.portafolio.turismoreal.controller;

import cl.portafolio.turismoreal.dao.Reserva;
import cl.portafolio.turismoreal.service.ReservationService;
import cl.portafolio.turismoreal.service.impl.AcompañanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/client/companions")
public class AcompañanteController {

    @Autowired
    private AcompañanteServiceImpl acompañanteService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping()
    public String showReservationsPage(@RequestParam Long id, Model model){
        try {
            Reserva reserva = reservationService.findById(id);
            model.addAttribute("companionList", reserva.getAcompañanteSet());
            return "companions";
        }catch (Exception ex) {
            return "redirect:/client/reservations?companionsFail";
        }
    }

}
