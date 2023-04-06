package com.portfoliobackend.service;

import com.portfoliobackend.model.Persona;


public interface IPersonaService {
    
    public Persona obtenerPersona();
    public Persona buscarPersona (Long id);   
    //public void borrarPersona (Long id);
    //public void crearPersona (Persona per);
}
