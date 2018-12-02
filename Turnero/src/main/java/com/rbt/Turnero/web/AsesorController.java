/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.web;

import com.rbt.Turnero.dto.AsesorDTO;
import com.rbt.Turnero.service.AsesorService;
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
@RequestMapping("/asesor")
public class AsesorController {
    
     private AsesorService asesorService;

    public AsesorController(AsesorService asesorService) {
        this.asesorService = asesorService;
    }
     
     @GetMapping
    public ResponseEntity<?> getAll() {
        List<AsesorDTO> listaAsesores = asesorService.listarAsesores();
        if(listaAsesores == null || listaAsesores.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaAsesores);
    }
    
      @GetMapping("/{id}")
    public ResponseEntity<?> getAsesor(@PathVariable("id") Integer id) {
        AsesorDTO persona = asesorService.consultarAsesor(id);
        
        if(persona == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }
    
//     @PostMapping
//    public ResponseEntity<?> insertAsesor(@RequestBody AsesorDTO asesor) {
//        AsesorDTO ase = asesorService.consultarAsesor(asesor.getId());
//        
//        if(ase != null){
//            return ResponseEntity.badRequest().build();
//        }
//
//        asesor = asesorService.guardarAsesor(asesor);
//        
//        if(asesor == null){
//            return ResponseEntity.badRequest().build();
//        }
//        
//        return ResponseEntity.ok(asesor);
//    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAsesor(
            @PathVariable("id") Integer id,
            @RequestBody AsesorDTO ase) {
        AsesorDTO asesor = asesorService.consultarAsesor(id);
        
        if(asesor == null){
            return ResponseEntity.notFound().build();
        }
        
        asesor = asesorService.guardarAsesor(ase);
        
        if(asesor == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(asesor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAsesor(@PathVariable("id") Integer id) {
        AsesorDTO asesor = asesorService.eliminarAsesor(id);
        if(asesor == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asesor);
    }
    
    
    
}
