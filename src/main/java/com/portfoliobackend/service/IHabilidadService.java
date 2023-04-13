package com.portfoliobackend.service;

import com.portfoliobackend.model.Habilidad;
import java.util.List;


public interface IHabilidadService {
    
    public List<Habilidad> obtenerTodas();
    public Habilidad buscar (Integer id);   
    public void borrar (Integer id);
    public Habilidad crear (Habilidad habilidad);
    public Habilidad actualizar (Habilidad habilidad);
}
