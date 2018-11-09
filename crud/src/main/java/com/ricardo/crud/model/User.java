/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.crud.model;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ricardo
 */

@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "first_name", nullable = true, length = 255)
    private String first_name;
    
    @Column(name = "second_name", nullable = true, length = 255)
    private String second_name;
    
    @Column(name = "first_username", nullable = true, length = 255)
    private String first_username;
    
    @Column(name = "second_usename", nullable = true, length = 255)
    private String second_usename;
    
    @Column(name = "phone", nullable = false, length = 30)
    private String phone;
    
    @Column(name = "address", nullable = false, length = 150)
    private String address;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the second_name
     */
    public String getSecond_name() {
        return second_name;
    }

    /**
     * @param second_name the second_name to set
     */
    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    /**
     * @return the first_username
     */
    public String getFirst_username() {
        return first_username;
    }

    /**
     * @param first_username the first_username to set
     */
    public void setFirst_username(String first_username) {
        this.first_username = first_username;
    }

    /**
     * @return the second_usename
     */
    public String getSecond_usename() {
        return second_usename;
    }

    /**
     * @param second_usename the second_usename to set
     */
    public void setSecond_usename(String second_usename) {
        this.second_usename = second_usename;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
