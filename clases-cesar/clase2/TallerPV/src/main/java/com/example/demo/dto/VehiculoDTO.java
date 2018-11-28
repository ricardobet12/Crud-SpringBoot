/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ricardo
 */
public class VehiculoDTO {
    
    @Getter
    @Setter
    private String placa;
    
    @Getter
    @Setter
    private String descripcion;
    @Getter
    @Setter
    private String fabricante;
    @Getter
    @Setter
    private String color;
    @Getter
    @Setter
    private Integer modelo;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String tipo;

    public VehiculoDTO() {
    }

    public VehiculoDTO(String placa, String descripcion, String fabricante, String color, Integer modelo, String estado, String tipo) {
        this.placa = placa;
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.color = color;
        this.modelo = modelo;
        this.estado = estado;
        this.tipo = tipo;
    }
}
