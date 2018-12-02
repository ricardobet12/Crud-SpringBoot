/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ricardo
 */
@Data
@NoArgsConstructor
public class CategoriaDTO {
    
    private Integer id;
    private String nombre;
    private String apodo;

    public CategoriaDTO(Integer id, String nombre, String apodo) {
        this.id = id;
        this.nombre = nombre;
        this.apodo = apodo;
    }
    
}
