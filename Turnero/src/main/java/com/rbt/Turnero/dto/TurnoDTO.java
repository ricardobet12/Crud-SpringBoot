/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ricardo
 */

@Data
@NoArgsConstructor
public class TurnoDTO {
    
    private Integer id;
    
    @JsonBackReference
    private CategoriaDTO id_categoria;
    
    private Integer consecutivo;
    private Timestamp hora;
    private boolean estado;
    private String apodoCategoria;

    public TurnoDTO(Integer id, CategoriaDTO id_categoria, Integer consecutivo, Timestamp hora, boolean estado, String apodoCategoria) {
        this.id = id;
        this.id_categoria = id_categoria;
        this.consecutivo = consecutivo;
        this.hora = hora;
        this.estado = estado;
        this.apodoCategoria = apodoCategoria;
    }
}
