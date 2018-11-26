/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.demo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ricardo
 */

@RestController
@RequestMapping("api/v1/hello")
public class HelloController {
    
    
    @GetMapping
    public String salute(@RequestParam(value = "nombre", defaultValue = "world")String nombre){
        return String.format("{mensaje: 'Hello %s!'}",nombre);
    }
    
    @GetMapping("/{nombre}")
    public String salute2(@PathVariable(value = "nombre") String nombre){
        return String.format("{mensaje: 'Hello %s!'}",nombre);
    }
    
     @GetMapping("/{nombre}/{apellido}")
    public String salute3(@PathVariable(value = "nombre") String nombre,@PathVariable(value = "apellido") String apellido){
        return String.format("{mensaje: 'Hello %s %s!'}",nombre,apellido);
    }
    
    @PostMapping("/guardar")
    public String save(@RequestBody String usuario){
        return String.format("Usuario guardado: %s", usuario);
    }
}
