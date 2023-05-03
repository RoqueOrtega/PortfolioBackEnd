package com.portfoliobackend.repository;

import com.portfoliobackend.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public List<Usuario> findByEmail(String email);
    public List<Usuario> findByEmailAndPassword(String email, String password);
    
}
