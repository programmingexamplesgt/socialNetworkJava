/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.utils;

import com.socialnetwork.db.DbException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author user
 */
public class PropertiesManager {

    public static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("settings.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
    
    public static String getSecretKey(){
        Properties properties = PropertiesManager.loadProperties();
        return properties.getProperty("secretkey");
        
    }

}
