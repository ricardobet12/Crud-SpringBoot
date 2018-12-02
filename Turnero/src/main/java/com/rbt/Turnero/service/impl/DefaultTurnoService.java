/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.service.impl;

import com.rbt.Turnero.dto.TurnoDTO;
import com.rbt.Turnero.entity.Categoria;
import com.rbt.Turnero.entity.Turno;
import com.rbt.Turnero.repository.TurnoRepository;
import com.rbt.Turnero.service.TurnoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricardo
 */
@Service
public class DefaultTurnoService implements TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TurnoDTO> listarTurnos() {
        List<TurnoDTO> respuesta = null;
        List<Turno> turnos = turnoRepository.findAll();
        if (turnos != null && !turnos.isEmpty()) {
            respuesta = new ArrayList<>();
            for (Turno t : turnos) {
                respuesta.add(modelMapper.map(t, TurnoDTO.class));
            }
        }
        return respuesta;
    }

    @Override
    public TurnoDTO consultarTurno(Integer id) {
        Optional<Turno> turnoOptional = turnoRepository.findById(id);
        if (turnoOptional.isPresent()) {
            return modelMapper.map(turnoOptional.get(), TurnoDTO.class);
        }
        return null;
    }

    @Override
    public TurnoDTO consultarPorConsecutivo(Categoria cat) {
//        Optional<Turno> turnoOptional = turnoRepository.findFirstBycategoriaOrderByIdDesc(cat);
//        if (turnoOptional.isPresent()) {
//            return modelMapper.map(turnoOptional.get(), TurnoDTO.class);
//        }
        return null;
    }

    @Override
    public TurnoDTO guardarTurno(TurnoDTO turno) {
//        Turno tur = turnoRepository.save(modelMapper.map(turno, Turno.class));
//        return modelMapper.map(tur, TurnoDTO.class);
        return null;
    }

    @Override
    public TurnoDTO eliminarTurno(Integer id) {
        TurnoDTO turno = consultarTurno(id);
        if (turno != null) {
            turnoRepository.deleteById(id);
            return turno;
        }

        return null;
    }

}
