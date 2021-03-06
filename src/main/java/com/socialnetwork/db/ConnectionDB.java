/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialnetwork.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.socialnetwork.utils.PropertiesManager;

/**
 *
 * @author user
 */
public class ConnectionDB {

    private static Connection connection = null;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                Properties properties = PropertiesManager.loadProperties();
                String url = properties.getProperty("dburl");
                connection = DriverManager.getConnection(url, properties);

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
