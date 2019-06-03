/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

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
        Assert.assertNotEquals(null, db.ConnectionDB.getConnection());
    }
    
    @AfterClass
    public static void closeConnection(){
        db.ConnectionDB.closeConnection();
    }
    
}
