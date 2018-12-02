/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ricardo
 */
@Entity
@Data
@NoArgsConstructor
public class Categoria implements Serializable{
    
    @Id
    private Integer id;
    private String nombre;
    private String apodo;
    
    @OneToMany(mappedBy = "categoria")
    @JsonManagedReference
    private List<Turno> turnoList;

    public Categoria(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
