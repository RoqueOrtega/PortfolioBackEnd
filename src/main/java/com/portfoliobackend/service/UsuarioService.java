package com.portfoliobackend.service;


import com.portfoliobackend.model.Usuario;
import com.portfoliobackend.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    public UsuarioRepository usuarioRepository;
    
    
    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }    
    
    
    public Usuario obtenerPorEmailyPassword(String email, String password){
        List<Usuario> list = usuarioRepository.findByEmailAndPassword(email, password);
        if (!list.isEmpty()){
            return list.get(0);
        }else{
            return null;
        }
    }


    
}
