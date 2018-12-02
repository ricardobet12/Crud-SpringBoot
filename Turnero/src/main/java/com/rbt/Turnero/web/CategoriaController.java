/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.web;

import com.rbt.Turnero.dto.AsesorDTO;
import com.rbt.Turnero.dto.CategoriaDTO;
import com.rbt.Turnero.service.CategoriaService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ricardo
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
     @GetMapping
    public ResponseEntity<?> getAll() {
        List<CategoriaDTO> listaCategorias = categoriaService.listarCategoria();
        if(listaCategorias == null || listaCategorias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaCategorias);
    }
    
      @GetMapping("/{id}")
    public ResponseEntity<?> getCategoria(@PathVariable("id") Integer id) {
        CategoriaDTO persona = categoriaService.consultarCategoria(id);
        
        if(persona == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }
    
     @PostMapping
    public ResponseEntity<?> insertCategoria(@RequestBody CategoriaDTO categoria) {
        CategoriaDTO cat = categoriaService.consultarCategoria(categoria.getId());
        
        if(cat != null){
            return ResponseEntity.badRequest().build();
        }

        categoria = categoriaService.guardarCategoria(categoria);
        
        if(categoria == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(categoria);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategoria(
            @PathVariable("id") Integer id,
            @RequestBody CategoriaDTO cat) {
        CategoriaDTO categoria = categoriaService.consultarCategoria(id);
        
        if(categoria == null){
            return ResponseEntity.notFound().build();
        }
        
        categoria = categoriaService.guardarCategoria(cat);
        
        if(categoria == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable("id") Integer id) {
        CategoriaDTO categoria = categoriaService.eliminarCategoria(id);
        if(categoria == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria);
    }
    
}
