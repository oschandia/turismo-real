package cl.portafolio.turismoreal.controller;

import cl.portafolio.turismoreal.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client/reservations")
public class ClientReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public String showReservationsPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("reservations", reservationService.getAllReservationsByUsername(user.getUsername()));
        return "reservations";
    }

    @PostMapping
    public String cancelReservation(@ModelAttribute("id") Long idReserva) {
        reservationService.cancelReservation(idReserva);
        return "redirect:/client/reservations?cancel";
    }

    @PostMapping("/companions")
    public String showCompanions(@ModelAttribute("id") Long idReserva) {
        return "redirect:/client/companions?id="+idReserva;
    }

}
