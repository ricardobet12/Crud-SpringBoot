/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.entity;

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
public class Categoria implements Serializable{
    
    @Id
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String apodo;

    public Categoria() {
    }

    public Categoria(Integer id, String nombre, String apodo) {
        this.id = id;
        this.nombre = nombre;
        this.apodo = apodo;
    }
    
}
