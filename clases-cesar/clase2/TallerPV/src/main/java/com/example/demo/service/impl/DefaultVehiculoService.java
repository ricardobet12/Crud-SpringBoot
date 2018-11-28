/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.impl;

import com.example.demo.dto.VehiculoDTO;
import com.example.demo.entity.Vehiculo;
import com.example.demo.repository.VehiculoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.VehiculoService;

/**
 *
 * @author ricardo
 */
@Service
public class DefaultVehiculoService implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoDTO> listarCarros() {
        List<VehiculoDTO> respuesta = null;
        List<Vehiculo> carros = vehiculoRepository.findAll();
        if (carros != null && !carros.isEmpty()) {
            respuesta = new ArrayList<>();
            for (Vehiculo c : carros) {
                respuesta.add(carToDto(c));
            }
        }
        return respuesta;
    }

    @Override
    public VehiculoDTO consultarCarros(String placa) {
        Optional<Vehiculo> carOptional = vehiculoRepository.findById(placa);
        if (carOptional.isPresent()) {
            return carToDto(carOptional.get());
        }
        return null;
    }

    @Override
    public VehiculoDTO guardarCarro(VehiculoDTO carro) {
        Vehiculo veh = vehiculoRepository.save(dtoToCar(carro));
        return carToDto(veh);
    }

    @Override
    public VehiculoDTO eliminarCarro(String placa) {
        VehiculoDTO carro = consultarCarros(placa);
        if (carro != null) {
            vehiculoRepository.deleteById(placa);
            return carro;
        }
        return null;
    }

    private VehiculoDTO carToDto(Vehiculo c) {
        return new VehiculoDTO(c.getPlaca(), c.getDescripcion(), c.getFabricante(), c.getColor(), c.getModelo(), c.getEstado(), c.getTipo());
    }

    private Vehiculo dtoToCar(VehiculoDTO carro) {
        Vehiculo resp = new Vehiculo();
        resp.setPlaca(carro.getPlaca());
        resp.setDescripcion(carro.getDescripcion());
        resp.setFabricante(carro.getFabricante());
        resp.setColor(carro.getColor());
        resp.setEstado(carro.getEstado());
        resp.setModelo(carro.getModelo());
        resp.setTipo(carro.getTipo());
        return resp;
    }
}
