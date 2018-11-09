/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.crud.util;

/**
 *
 * @author ricardo
 */
public class RestResponse {
    
    private Integer responseCode;
    private String message;
    
    public RestResponse(Integer responseCode){
        super();
        this.responseCode = responseCode;
    }
    
    public RestResponse(Integer respondeCode,String message){
        super();
        this.responseCode = respondeCode;
        this.message = message;
    }

    /**
     * @return the responseCode
     */
    public Integer getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
