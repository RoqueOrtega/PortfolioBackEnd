package com.portfoliobackend.service;

import com.portfoliobackend.model.Persona;


public interface IPersonaService {
    
    public Persona obtenerPersona();
    public Persona actualizar (Persona persona);
    public Persona buscar(Integer id);
    
}
