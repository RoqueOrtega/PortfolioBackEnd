package com.portfoliobackend.controller;

import com.portfoliobackend.model.Habilidad;
import com.portfoliobackend.service.HabilidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/habilidades")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadController {
    
    @Autowired
    public HabilidadService habilidadService;
    
    
    @GetMapping
    public ResponseEntity<List<Habilidad>> obtenerTodas(){
        return new ResponseEntity(habilidadService.obtenerTodas(), HttpStatus.OK);
    }
     
    @PostMapping
    public ResponseEntity<Habilidad> crear(@RequestBody Habilidad habilidad){
        return ResponseEntity.ok(habilidadService.crear(habilidad));
    }
    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        habilidadService.borrar(id);
        return "Se borro correctamente.";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidad> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(habilidadService.buscar(id));
    }
    
    @PutMapping
    public ResponseEntity<Habilidad> actualizar(@RequestBody Habilidad habilidad){
        ResponseEntity<Habilidad> response;
        //Verificar si el ID es distinto de NULL y si la habilidad existe
        if (habilidad.getId() != null && habilidadService.buscar(habilidad.getId()) != null){
            response= ResponseEntity.ok(habilidadService.actualizar(habilidad));
        }else{
            response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }   
    
}
