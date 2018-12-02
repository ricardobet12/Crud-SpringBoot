/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.service;

import com.rbt.Turnero.dto.TurnoDTO;
import com.rbt.Turnero.entity.Categoria;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface TurnoService {

    List<TurnoDTO> listarTurnos();

    TurnoDTO consultarTurno(Integer id);
    
    TurnoDTO consultarPorConsecutivo(Categoria cat);

    TurnoDTO guardarTurno(TurnoDTO turno);

    TurnoDTO eliminarTurno(Integer id);

}
