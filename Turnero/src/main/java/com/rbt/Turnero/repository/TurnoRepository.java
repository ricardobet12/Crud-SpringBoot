/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbt.Turnero.repository;

import com.rbt.Turnero.entity.Categoria;
import com.rbt.Turnero.entity.Turno;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ricardo
 */
@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer>{
    
//    Optional <Turno> findFirstBycategoriaOrderByIdDesc(Categoria cat);
}
