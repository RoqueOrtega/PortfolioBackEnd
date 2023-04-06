package com.portfoliobackend.controller;

import com.portfoliobackend.model.Persona;
import com.portfoliobackend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/datos-personales")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    public PersonaService personaService;
    
    @GetMapping()
    public ResponseEntity<Persona> obtenerPersona(){
        //return personaService.obtenerPersona();
        return new ResponseEntity(personaService.obtenerPersona(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaById(@PathVariable Long id){
        //return personaService.buscarPersona(id);
        return ResponseEntity.ok(personaService.buscarPersona(id));
    }    
    
    
    /*@PostMapping
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente)) ;
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente){
        //return pacienteService.actualizar(paciente);
        ResponseEntity<Paciente> response;
        //Verificar si el ID es distinto de NULL y si el paciente existe
        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()) != null){
            response= ResponseEntity.ok(pacienteService.actualizar(paciente));
        }else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id)throws ResourceNotFoundException {
        ResponseEntity<String> response;
        pacienteService.eliminar(id);

        response= ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(pacienteService.buscar(id));
    } */   
    
    
}
