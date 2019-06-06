/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uci.petsrusservice.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author joeyvargas
 */
public class DBConnect {
        /* class data members */
    private Connection conn = null;
    private ResultSet rs = null;
    private ResultSetMetaData rsmd = null;
    private int cols = 0;
    
    /* database credentials and prepared statement queries */
    private String jdbcDriver = "com.mysql.jdbc.Driver";  
    private String query = "select * from product";
    private String DB_URL="jdbc:mysql://localhost:3306/petsrus??serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private String USER = "root";
    private String PASS = "root";
    
    public Connection getConnection()
    {
    
        try 
        {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            return conn;
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (SQLException e) 
        {
           e.printStackTrace();
        }
            
        return conn;
    }
    
}
