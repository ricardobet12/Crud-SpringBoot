/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.service.impl;

import com.rbt.Turnero.dto.CategoriaDTO;
import com.rbt.Turnero.entity.Categoria;
import com.rbt.Turnero.repository.CategoriaRepository;
import com.rbt.Turnero.service.CategoriaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricardo
 */

@Service
public class DefaultCategoriaService implements CategoriaService{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> listarCategoria() {
        List<CategoriaDTO> respuesta = null;
        List<Categoria> categorias = categoriaRepository.findAll();
        if (categorias != null && !categorias.isEmpty()) {
            respuesta = new ArrayList<>();
            for (Categoria c : categorias) {
                respuesta.add(categoriaToDto(c));
            }
        }
        return respuesta;
    }

    @Override
    public CategoriaDTO consultarCategoria(Integer id) {
         Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            return categoriaToDto(categoriaOptional.get());
        }
        return null;
    }

    @Override
    public CategoriaDTO guardarCategoria(CategoriaDTO c) {
         Categoria categoria = categoriaRepository.save(dtoToCategoria(c));
        return categoriaToDto(categoria);
    }

    @Override
    public CategoriaDTO eliminarCategoria(Integer id) {
        CategoriaDTO categoria = consultarCategoria(id);
        if (categoria != null) {
            categoriaRepository.deleteById(id);
            return categoria;
        }

        return null;
    }
    
    private CategoriaDTO categoriaToDto(Categoria c) {
        return new CategoriaDTO(c.getId(), c.getNombre(), c.getApodo());
    }
     
     private Categoria dtoToCategoria(CategoriaDTO c) {
        Categoria resp = new Categoria();
        resp.setId(c.getId());
        resp.setNombre(c.getNombre());
        resp.setApodo(c.getApodo());
        return resp;
    }
}
