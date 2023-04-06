package com.portfoliobackend.service;

import com.portfoliobackend.model.Persona;
import com.portfoliobackend.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    public PersonaRepository personaRepository;
    

    @Override
    public Persona obtenerPersona() {
        List<Persona> list = personaRepository.findAll();
        if (!list.isEmpty()){
            return list.get(0);
        }else{
            return null;
        }        
    }

    @Override
    public Persona buscarPersona(Long id) {
        return personaRepository.findById(id).orElse(null);
    }
    
}
