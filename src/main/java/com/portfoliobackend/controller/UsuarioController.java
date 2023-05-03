
package com.portfoliobackend.controller;

import com.portfoliobackend.dto.JwtRequest;
import com.portfoliobackend.dto.JwtResponse;
import com.portfoliobackend.model.Usuario;
import com.portfoliobackend.security.JwtTokenUtil;
import com.portfoliobackend.service.JwtUserDetailsService;
import com.portfoliobackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "https://portfolio-frontend-roque.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    @Autowired
    private AuthenticationManager authenticationManager;    
    
    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    

    @Autowired
    public UsuarioService usuarioService;
    
    /*@PostMapping("/login")
    public ResponseEntity<Usuario> obtenerUsuario(@RequestBody JwtRequest credencial){
        Usuario usuario = usuarioService.obtenerPorEmailyPassword(credencial.getEmail(), credencial.getPassword());
        return ResponseEntity.ok(usuario);
    }*/
    
    
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        //System.out.println("%%%%%%%%En UsuarioController.createAuthenticationToken() - userDetails: "+userDetails);
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String email, String password) throws Exception { 
        try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
                throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
        }
    }      
    
}
