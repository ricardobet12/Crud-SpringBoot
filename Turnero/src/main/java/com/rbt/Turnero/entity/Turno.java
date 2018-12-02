/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.entity;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ricardo
 */
@Entity
@Data
@NoArgsConstructor
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private Integer consecutivo;
    private Timestamp hora;
    private boolean estado;

    @JoinColumn(name = "id_categoria",referencedColumnName = "id")
    @ManyToOne
    private Categoria categoria;

    public Turno(Integer Id, Integer consecutivo, Timestamp hora, boolean estado, Categoria categoria) {
        this.Id = Id;
        this.consecutivo = consecutivo;
        this.hora = hora;
        this.estado = estado;
        this.categoria = categoria;
    }
}
