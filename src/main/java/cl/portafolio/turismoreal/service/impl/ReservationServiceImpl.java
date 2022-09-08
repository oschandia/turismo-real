package cl.portafolio.turismoreal.service.impl;

import cl.portafolio.turismoreal.dao.*;
import cl.portafolio.turismoreal.domain.ReservaDto;
import cl.portafolio.turismoreal.mapper.ReservaDtoToClientMapper;
import cl.portafolio.turismoreal.mapper.ReservaDtoToReservaMapper;
import cl.portafolio.turismoreal.repositorio.ClienteRepository;
import cl.portafolio.turismoreal.repositorio.ReservaRepository;
import cl.portafolio.turismoreal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

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
}
