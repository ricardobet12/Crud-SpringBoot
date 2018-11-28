/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.web;

import com.example.demo.dto.PersonDTO;
import com.example.demo.service.PersonService;
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
@RequestMapping("api/v1/personas")
public class PersonController {
    
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<PersonDTO> listaPersonas = personService.listarPersonas();
        if(listaPersonas == null || listaPersonas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaPersonas);
    }
    
      @GetMapping("/{id}")
    public ResponseEntity<?> getPerson(@PathVariable("id") Long id) {
        PersonDTO persona = personService.consultarPersona(id);
        
        if(persona == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }

    
     @PostMapping
    public ResponseEntity<?> insertPerson(@RequestBody PersonDTO persona) {
        PersonDTO per = personService.consultarPersona(persona.getId());
        
        if(per != null){
            return ResponseEntity.badRequest().build();
        }

        persona = personService.guardarPersona(persona);
        
        if(persona == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(persona);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable("id") Long id,
            @RequestBody PersonDTO per) {
        PersonDTO persona = personService.consultarPersona(id);
        
        if(persona == null){
            return ResponseEntity.notFound().build();
        }
        
        persona = personService.guardarPersona(per);
        
        if(persona == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(persona);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        PersonDTO persona = personService.eliminarPersona(id);
        if(persona == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }
}
