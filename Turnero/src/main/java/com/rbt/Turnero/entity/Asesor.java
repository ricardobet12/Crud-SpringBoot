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
public class Asesor implements Serializable{
    
    @Id
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer cedula;
    @Getter
    @Setter
    private String nombre;

    public Asesor() {
    }

    public Asesor(Integer id, Integer cedula, String nombre) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
    }
}
