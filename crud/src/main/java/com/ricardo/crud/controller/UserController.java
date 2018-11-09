/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.crud.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardo.crud.model.User;
import com.ricardo.crud.service.UserService;
import com.ricardo.crud.util.RestResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ricardo
 */
@RestController
public class UserController {
    
    @Autowired
    protected UserService userService;
    protected ObjectMapper mapper;
    
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String userJson)throws JsonParseException,JsonMappingException, IOException{
        this.mapper = new ObjectMapper();
        User user = this.mapper.readValue(userJson, User.class);
        
        if(!this.validate(user)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Los campos obligatorios no estan diligenciados");
        }
        this.userService.save(user);
        return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
    }
    
    private boolean validate(User user){
        Boolean isValid = true;
        if(user.getFirst_name() == null){
            isValid = false;
        }
        if(user.getFirst_username()== null){
            isValid = false;
        }
        if(user.getAddress()== null){
            isValid = false;
        }
        return isValid;
    }
}
