package cl.portafolio.turismoreal.controller.rest;

import cl.portafolio.turismoreal.dao.Reserva;
import cl.portafolio.turismoreal.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ReservationRestController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/rest-api/reservas")
    public ResponseEntity<List<Reserva>> getReservations(){
        return ResponseEntity.ok(reservationService.getAllReservations());
    }
}
