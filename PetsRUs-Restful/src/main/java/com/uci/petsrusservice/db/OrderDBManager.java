package com.uci.petsrusservice.db;

/* imports */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class OrderDBManager {
    
    /* class data members */
    private Connection conn = null;
    
    /* database credentials and prepared statement queries */
    private PreparedStatement addOrderPreparedStatement;
 
    /* debugging flag */
    boolean debug = true;
    
    
    /* establishes connection with the MySQL database */
    public void initializeDBConnection() {
  
        DBConnect db = new DBConnect();
        conn = db.getConnection();
    }

    public int addOrder(int order_num, float price, int product_num, int qty, String fname, 
            String lname, String email, String phone, String address, String state,
            String city, int zip, String shipping, String cc_num, int csc_num, String card_type) {
        
         //checks if a connection is established, starts connection if not 
        checkConnection();       
        
        if (debug) System.out.println("Attempting to add new order order num = " + order_num);
        int result = 0;
        try {
            //estbalishes connection with database to execute insert query
            addOrderPreparedStatement = conn.prepareStatement(
                    "INSERT INTO  OrderDetails("
                            + "order_num, price, product_id, qty, fname, lname,"
                            + "email, phone, address, state, city, zip,"
                            + "shipping_option, cc_num, csc_num, card_type) "
                            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            addOrderPreparedStatement.setInt(1, order_num);
            addOrderPreparedStatement.setFloat(2, price);
            addOrderPreparedStatement.setInt(3, product_num);
            addOrderPreparedStatement.setInt(4, qty);
            addOrderPreparedStatement.setString(5, fname);
            addOrderPreparedStatement.setString(6, lname);
            addOrderPreparedStatement.setString(7, email);
            addOrderPreparedStatement.setString(8, phone);
            addOrderPreparedStatement.setString(9, address);
            addOrderPreparedStatement.setString(10, state);
            addOrderPreparedStatement.setString(11, city);
            addOrderPreparedStatement.setInt(12, zip);
            addOrderPreparedStatement.setString(13, shipping);
            addOrderPreparedStatement.setString(14, cc_num);
            addOrderPreparedStatement.setInt(15, csc_num);
            addOrderPreparedStatement.setString(16, card_type);

            result = addOrderPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;    
    }

    /* establishes a connection with the database, if not already connected */
    private void checkConnection() {
        if (conn == null) {
            initializeDBConnection();
        }
    }
}
