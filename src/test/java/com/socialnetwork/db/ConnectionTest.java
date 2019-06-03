/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.db;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author user
 */
public class ConnectionTest {
    
    @Test
    public void connectionTest(){
        Assert.assertNotEquals(null,ConnectionDB.getConnection());
    }
    
    @AfterClass
    public static void closeConnection(){
        ConnectionDB.closeConnection();
    }
    
}
