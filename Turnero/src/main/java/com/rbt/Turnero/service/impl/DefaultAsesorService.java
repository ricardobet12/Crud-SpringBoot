/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.service.impl;

import com.rbt.Turnero.dto.AsesorDTO;
import com.rbt.Turnero.entity.Asesor;
import com.rbt.Turnero.repository.AsesorRepository;
import com.rbt.Turnero.service.AsesorService;
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
public class DefaultAsesorService implements AsesorService{
    
    @Autowired
    private AsesorRepository asesorRepository;

    @Override
    public List<AsesorDTO> listarAsesores() {
        List<AsesorDTO> respuesta = null;
        List<Asesor> asesores = asesorRepository.findAll();
        if (asesores != null && !asesores.isEmpty()) {
            respuesta = new ArrayList<>();
            for (Asesor a : asesores) {
                respuesta.add(asesorToDto(a));
            }
        }
        return respuesta;
    }

    @Override
    public AsesorDTO consultarAsesor(Integer id) {
         Optional<Asesor> asesorOptional = asesorRepository.findById(id);
        if (asesorOptional.isPresent()) {
            return asesorToDto(asesorOptional.get());
        }
        return null;
    }

    @Override
    public AsesorDTO guardarAsesor(AsesorDTO a) {
         Asesor asesor = asesorRepository.save(dtoToAsesor(a));
        return asesorToDto(asesor);
    }

    @Override
    public AsesorDTO eliminarAsesor(Integer id) {
        AsesorDTO asesor = consultarAsesor(id);
        if (asesor != null) {
            asesorRepository.deleteById(id);
            return asesor;
        }

        return null;
    }
    
     private AsesorDTO asesorToDto(Asesor asesor) {
        return new AsesorDTO(asesor.getId(), asesor.getCedula(), asesor.getNombre());
    }
     
     private Asesor dtoToAsesor(AsesorDTO a) {
        Asesor resp = new Asesor();
        resp.setId(a.getId());
        resp.setCedula(a.getCedula());
        resp.setNombre(a.getNombre());
        return resp;
    }
    
}
