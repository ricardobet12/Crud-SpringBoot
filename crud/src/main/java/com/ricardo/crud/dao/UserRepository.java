/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.crud.dao;

import com.ricardo.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ricardo
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
    @SuppressWarnings("unchecked")
    User save(User user);
}
