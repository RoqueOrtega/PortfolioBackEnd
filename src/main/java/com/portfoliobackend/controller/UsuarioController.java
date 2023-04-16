
package com.portfoliobackend.controller;

import com.portfoliobackend.dto.Credenciales;
import com.portfoliobackend.model.Usuario;
import com.portfoliobackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    @Autowired
    public UsuarioService usuarioService;
    
    
    @PostMapping("/login")
    public ResponseEntity<Usuario> obtenerUsuario(@RequestBody Credenciales credencial){
        Usuario usuario = usuarioService.obtenerPorEmailyPassword(credencial.getEmail(), credencial.getPassword());
        return ResponseEntity.ok(usuario);
    }    
    
}
