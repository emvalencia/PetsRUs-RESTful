//package com.uci.petsrusservice.db;
//
//import java.sql.*;
//
//
//public class DatabaseConnector {
//
//
//    private DatabaseConnector() {
//
//    }
//
//    public static Connection getConnection() {
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            return DriverManager.getConnection("jdbc:mysql://localhost/db4lecture",
//                    "root", "inf124");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return null;
//    }
//
//
//}
