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
public class AsesorDTO {
    
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer cedula;
    @Getter
    @Setter
    private String nombre;

    public AsesorDTO() {
    }

    public AsesorDTO(Integer id, Integer cedula, String nombre) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
    
    
}
