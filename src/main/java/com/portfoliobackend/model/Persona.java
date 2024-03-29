package com.portfoliobackend.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Setter @Getter
public class Persona implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String descripcion;
    private String acercade; 
    private String imagen;
    private String email;
    private String telefono;

    public Persona() {
    }


    
    
    
}
