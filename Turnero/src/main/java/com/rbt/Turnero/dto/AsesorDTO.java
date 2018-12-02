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
public class AsesorDTO {
    
    private Integer id;
    private Integer cedula;
    private String nombre;

    public AsesorDTO(Integer id, Integer cedula, String nombre) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
    }
}
