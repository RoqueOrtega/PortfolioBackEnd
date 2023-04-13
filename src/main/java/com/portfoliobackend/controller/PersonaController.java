package com.portfoliobackend.controller;

import com.portfoliobackend.model.Persona;
import com.portfoliobackend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return new ResponseEntity(personaService.obtenerPersona(), HttpStatus.OK);
    }
    
    
    @PutMapping
    public ResponseEntity<Persona> actualizar(@RequestBody Persona persona){
        return ResponseEntity.ok(personaService.actualizar(persona));
    }
    
}
