/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ricardo
 */
public class CategoriaDTO {
    
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String apodo;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer id, String nombre, String apodo) {
        this.id = id;
        this.nombre = nombre;
        this.apodo = apodo;
    }
    
    
    
}
