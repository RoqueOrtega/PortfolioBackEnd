package com.portfoliobackend.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "habilidades")
@Setter @Getter
public class Habilidad implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Integer porcentaje;
    
    //Relacion con otra clase
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    //@JsonIgnore
    private Persona persona;

    
    public Habilidad() {
    }


    
    
}
