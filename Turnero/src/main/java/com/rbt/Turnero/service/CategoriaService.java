/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.service;

import com.rbt.Turnero.dto.CategoriaDTO;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface CategoriaService {
    
    List<CategoriaDTO> listarCategoria();

    CategoriaDTO consultarCategoria(Integer id);
    
    CategoriaDTO guardarCategoria(CategoriaDTO categoria);
    
    CategoriaDTO eliminarCategoria(Integer id);
    
}
