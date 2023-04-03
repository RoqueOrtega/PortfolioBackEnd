package com.portfoliobackend.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String ocupacion;
    private String acercade;

    public Persona() {
    }

    public Persona(Long id, String nombre, String ocupacion, String acercade) {
        this.id = id;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.acercade = acercade;
    }


    
    
    
}
