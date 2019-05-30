package com.uci.petsrusservice.db;

/* imports */
import com.uci.petsrusservice.collections.ProductCollection;
import com.uci.petsrusservice.model.Product;
//import com.uci.petsrusservice.collections.ProductCollection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ProductDBManager {
    
    /* class data members */
    private Connection conn = null;
    private ResultSet rs = null;
    private ResultSetMetaData rsmd = null;
    private int cols = 0;
    
    /* database credentials */
    private String dbName = "petsrus";
    private String dbUsername = "root";
    private String dbPassword = "root";
    private String jdbcDriver = "com.mysql.jdbc.Driver";  
    private String query = "select * from products";
    
    /* create collection to hold our products */
    private ProductCollection productCollection;
    
    /* debugging flag */
    boolean debug = true;
    
    /* default constructor */
    public ProductDBManager() {
        /* do nothing */
    }
    
    /* establishes connection with the MySQL database */
    public void initializeDBConnection() {
        
        
        if (debug) System.out.println("Attempting to establish database connection...\n");

        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName
                    + "", dbUsername, dbPassword
            );
            
            if (debug) System.out.println("Connection established\n");

            /* creates a prepared statement and gets all the information */
            PreparedStatement ps = conn.prepareCall(query);
            this.rs = ps.executeQuery();
            this.rsmd = rs.getMetaData();
            this.cols = rsmd.getColumnCount();

            /* establishes a new collection of products */
            ProductCollection productCollection = new ProductCollection();

            resultSetObjectConversion();

            // rs.close();
            //conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ProductCollection getProductCollection() {
        return this.productCollection;
    }
    
    /* converts all products from the database to Product objects and adds them 
    to a ProductCollection */
    public void resultSetObjectConversion() {

        try {
            while (rs.next()) {

                /* create a new product object */
                Product newProduct = new Product();     
                newProduct.setId(rs.getInt("id"));
                newProduct.setName(rs.getString("name"));
                newProduct.setPrice(rs.getInt("price"));
                newProduct.setType(rs.getString("type"));
                newProduct.setCategory(rs.getString("category"));
                newProduct.setPageURL(rs.getString("page_url"));
                newProduct.setImageURL(rs.getString("image_url"));
                newProduct.setSummary(rs.getString("summary"));
                newProduct.setDescription(rs.getString("description"));
                newProduct.setBenefits(rs.getString("benefits"));

                /* add this product to the product collection */
                productCollection.addProduct(newProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
