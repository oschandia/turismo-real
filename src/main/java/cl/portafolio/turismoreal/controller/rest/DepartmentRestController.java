package cl.portafolio.turismoreal.controller.rest;

import cl.portafolio.turismoreal.dao.Departamento;
import cl.portafolio.turismoreal.service.impl.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class DepartmentRestController {

    @Autowired
    private DepartamentoServiceImpl departamentoService;

    @GetMapping("/rest-api/departamentos")
    public ResponseEntity<List<Departamento>> getDepartamentos(){
        return ResponseEntity.ok(departamentoService.getAllDepartamentos());
    }
}
