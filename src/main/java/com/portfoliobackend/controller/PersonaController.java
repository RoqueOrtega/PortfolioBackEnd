package com.portfoliobackend.controller;

import com.portfoliobackend.model.Persona;
import com.portfoliobackend.service.PersonaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonaController {
    
    @Autowired
    public PersonaService personaService;
    
    @GetMapping("/persona/todas")
    @ResponseBody
    public List<Persona> obtenerListado(){
        return personaService.obtenerPersonas();
    }
    
    @GetMapping("/persona/{id}")
    @ResponseBody
    public Persona obtenerListado(@PathVariable Long id){
        return personaService.buscarPersona(id);
    }    
    
}
