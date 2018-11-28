/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.web;

import com.example.demo.dto.VehiculoDTO;
import com.example.demo.dto.PersonDTO;
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
import com.example.demo.service.VehiculoService;

/**
 *
 * @author ricardo
 */
@RestController
@RequestMapping("api/v1/vehiculos")
public class VehiculoController {
    
    private VehiculoService carService;

    public VehiculoController(VehiculoService carService) {
        this.carService = carService;
    }
    
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<VehiculoDTO> listaCarros = carService.listarCarros();
        if(listaCarros == null || listaCarros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaCarros);
    }
    
      @GetMapping("/{placa}")
    public ResponseEntity<?> getCar(@PathVariable("placa") String placa) {
          System.out.println("hola");
        VehiculoDTO carro = carService.consultarCarros(placa);
        
        if(carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    
     @PostMapping
    public ResponseEntity<?> insertCar(@RequestBody VehiculoDTO carro) {
        VehiculoDTO car = carService.consultarCarros(carro.getPlaca());
        if(car != null){
            return ResponseEntity.badRequest().build();
        }
        carro = carService.guardarCarro(carro);
        
        if(carro == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(carro);
    }
    
    @PutMapping("/{placa}")
    public ResponseEntity<?> updateCar(
            @PathVariable("placa") String placa,
            @RequestBody VehiculoDTO car) {
        VehiculoDTO carro = carService.consultarCarros(placa);
        
        if(carro == null){
            return ResponseEntity.notFound().build();
        }
        
        carro = carService.guardarCarro(car);
        
        if(carro == null){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<?> deleteCar(@PathVariable("placa") String placa) {
        VehiculoDTO carro = carService.eliminarCarro(placa);
        if(carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }
    
}
