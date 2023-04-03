package com.portfoliobackend.service;

import com.portfoliobackend.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> obtenerPersonas();
    public Persona buscarPersona (Long id);   
    //public void borrarPersona (Long id);
    //public void crearPersona (Persona per);
}
