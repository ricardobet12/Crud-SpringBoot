/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ricardo
 */
@Entity
@Data
@NoArgsConstructor
public class Asesor implements Serializable{
    
    @Id
    private Integer id;
    private Integer cedula;
    private String nombre;
}
