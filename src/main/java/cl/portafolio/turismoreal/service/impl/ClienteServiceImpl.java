package cl.portafolio.turismoreal.service.impl;

import cl.portafolio.turismoreal.dao.Cliente;
import cl.portafolio.turismoreal.domain.ReservaDto;
import cl.portafolio.turismoreal.mapper.ReservaDtoToClientMapper;
import cl.portafolio.turismoreal.repositorio.ClienteRepository;
import cl.portafolio.turismoreal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ReservaDtoToClientMapper mapper;

    @Override
    public Cliente save(ReservaDto reservaDto) throws ParseException {
        Cliente cliente = mapper.map(reservaDto);
        return clienteRepository.save(cliente);
    }
}
