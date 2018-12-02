/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.web;

import com.rbt.Turnero.dto.TurnoDTO;
import com.rbt.Turnero.entity.Categoria;
import com.rbt.Turnero.service.TurnoService;
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
@RequestMapping("/turno")
public class TurnoController {

    private TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<TurnoDTO> listaTurnos = turnoService.listarTurnos();
        if (listaTurnos == null || listaTurnos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaTurnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTurno(@PathVariable("id") Integer id) {
        TurnoDTO turno = turnoService.consultarTurno(id);

        if (turno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turno);
    }

    @GetMapping("/buscarUltimoEnLlegada/{id}")
    public ResponseEntity<?> getConsecutivo(@PathVariable("id") Integer id) {
        Categoria cat = new Categoria(id);
        TurnoDTO turno = turnoService.consultarPorConsecutivo(cat);

        if (turno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turno);
    }

    @PostMapping("/addTurno/{letra}")
    public ResponseEntity<?> insertTurno(@RequestBody TurnoDTO turno) {
        TurnoDTO tur = turnoService.consultarTurno(turno.getId());

        if (tur != null) {
            return ResponseEntity.badRequest().build();
        }

        turno = turnoService.guardarTurno(turno);

        if (turno == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(turno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTurno(
            @PathVariable("id") Integer id,
            @RequestBody TurnoDTO tur) {
        TurnoDTO turno = turnoService.consultarTurno(id);

        if (turno == null) {
            return ResponseEntity.notFound().build();
        }

        turno = turnoService.guardarTurno(tur);

        if (turno == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(turno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAsesor(@PathVariable("id") Integer id) {
        TurnoDTO turno = turnoService.eliminarTurno(id);
        if (turno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turno);
    }
}
