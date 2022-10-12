package cl.portafolio.turismoreal.service.impl;

import cl.portafolio.turismoreal.dao.*;
import cl.portafolio.turismoreal.domain.ReservaDto;
import cl.portafolio.turismoreal.mapper.ReservaDtoToReservaMapper;
import cl.portafolio.turismoreal.repositorio.ReservaRepository;
import cl.portafolio.turismoreal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ReservaDtoToReservaMapper reservaMapper;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AcompañanteService acompañanteService;

    @Override
    public Reserva findById(Long reservaId) throws Exception {
        return reservaRepository.findById(reservaId).orElseThrow(Exception::new);
    }

    @Override
    public Reserva save(ReservaDto reservaDto) throws ParseException {
        Reserva reserva = reservaMapper.map(reservaDto);
        Cliente cliente = clienteService.save(reservaDto);
        Departamento departamento = departamentoService.findById(reservaDto.getDepartamentoId());
        Usuario usuario = usuarioService.findByUsername(reservaDto.getUsuario());
        Set<Acompañante> acompañantes = new HashSet<>();
        for (int i = 0; i < reservaDto.getAdults() + reservaDto.getChilds(); i++) {
            acompañantes.add(acompañanteService.save(new Acompañante()));
        }
        reserva.setCliente(cliente);
        reserva.setDepartamento(departamento);
        reserva.setUsuario(usuario);
        reserva.setAcompañanteSet(acompañantes);
        reserva.setValorReserva(reserva.getCantidadNoches()*departamento.getValor());
        reserva.setMontoPendienteReserva(reserva.getValorReserva());
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> getAllReservations() {
        return reservaRepository.findAll();
    }

    @Override
    public List<Reserva> getAllReservationsByUsername(String username) {
        Usuario usuario = usuarioService.findByUsername(username);
        List<Reserva> reservations = reservaRepository.findByUsuario(usuario);
        return reservations.stream().filter(reserva -> reserva.getEstadoReserva() != 5).collect(Collectors.toList());
    }

    @Override
    public void cancelReservation(Long idReserva) {
        Optional<Reserva> optionalReserva = reservaRepository.findById(idReserva);
        if(optionalReserva.isPresent()){
            Reserva reserva = optionalReserva.get();
            reserva.setEstadoReserva(5L);
            reservaRepository.saveAndFlush(reserva);
        }

    }
}
