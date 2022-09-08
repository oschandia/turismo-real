package cl.portafolio.turismoreal.rest.controller;

import cl.portafolio.turismoreal.domain.ReservaDto;
import cl.portafolio.turismoreal.service.ReservationService;
import cl.portafolio.turismoreal.service.impl.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private DepartamentoServiceImpl departamentoService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public String showReservationPage(Model model, @RequestParam Long id) {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setDepartamentoId(id);
        model.addAttribute("reservation", reservaDto);
        model.addAttribute("depto", departamentoService.findById(id));
        return "reservation";
    }

    @PostMapping
    public String createReservation(@AuthenticationPrincipal User user, @ModelAttribute("reservation") ReservaDto reservaDto) throws ParseException {
        reservaDto.setUsuario(user.getUsername());
        reservationService.save(reservaDto);
        return "redirect:/reservation?id="+reservaDto.getDepartamentoId().toString()+"&success";
    }

}
