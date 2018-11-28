/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ricardo
 */
@Entity
public class Person implements Serializable{
    
    @Id
    @Getter
    @Setter    
    private Long identificacion;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String apellido;
    @Getter
    @Setter
    private String telefono;
    @Getter
    @Setter
    private String direccion;

    public Person() {
    }

    public Person(Long identificacion, String nombre, String apellido, String telefono, String direccion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    
    
}
