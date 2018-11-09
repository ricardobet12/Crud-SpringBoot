/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.crud.util;

import java.util.List;

/**
 *
 * @author ricardo
 */
public class QueryResult {
    private int totalRecords;
    private List<Object> list;

    /**
     * @return the totalRecords
     */
    public int getTotalRecords() {
        return totalRecords;
    }

    /**
     * @param totalRecords the totalRecords to set
     */
    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    /**
     * @return the list
     */
    public List<Object> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Object> list) {
        this.list = list;
    }
    
    
    
    
    
    
}
