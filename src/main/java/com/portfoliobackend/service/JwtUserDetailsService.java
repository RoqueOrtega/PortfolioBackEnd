package com.portfoliobackend.service;

import com.portfoliobackend.model.Usuario;
import com.portfoliobackend.repository.UsuarioRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService{

    @Autowired
    public UsuarioRepository usuarioRepository;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //OJO: Se debe obtener el primer elemento, ya que .findByEmail() devuelve una lista
        Usuario user = (Usuario) this.usuarioRepository.findByEmail(username).get(0);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
            new ArrayList<>());
}
    
}
