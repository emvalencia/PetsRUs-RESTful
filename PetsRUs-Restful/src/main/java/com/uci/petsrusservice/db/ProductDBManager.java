package com.uci.petsrusservice.db;

/* imports */
import com.uci.petsrusservice.collections.ProductCollection;
import com.uci.petsrusservice.model.Product;
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
    
    /* database credentials and prepared statement queries */
    private String jdbcDriver = "com.mysql.jdbc.Driver";  
    private String query = "select * from product";
    private String DB_URL="jdbc:mysql://localhost:3306/petsrus??serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private String USER = "root";
    private String PASS = "root";
    private PreparedStatement addProductPreparedStatement;
    private PreparedStatement updateProductPreparedStatement;
    private PreparedStatement deleteProductPreparedStatement;
    
    /* create collection to hold our products */
    private ProductCollection productCollection ;
    
    /* debugging flag */
    boolean debug = true;
    
    /* default constructor */
    public ProductDBManager() {
        
        /* establishes a new collection of products */
        productCollection = new ProductCollection();
        
    }
    
    /* establishes connection with the MySQL database */
    public void initializeDBConnection() {
        
        if (debug) System.out.println("Attempting to establish database connection...\n");

        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            if (conn != null && debug) System.out.println("Connection established");

            /* creates a prepared statement and gets all the information */
            PreparedStatement ps = conn.prepareCall(query);
            this.rs = ps.executeQuery();
            this.rsmd = rs.getMetaData();
            this.cols = rsmd.getColumnCount();

            resultSetObjectConversion(); 

            // rs.close();
            //conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /* returns this manager's array of products */
    public ProductCollection getProductCollection() {        
        
        /* establish db connection if not already established */
        checkConnection();
        
        return this.productCollection;
    }
    
    /* returns a product's information */
    public Product getProduct(int id) {
        
        /* establish db connection if not already established */
        checkConnection();
      
        return productCollection.getProduct(id);
    }
    
    /* converts all products from the database to Product objects and adds them 
    to a ProductCollection */
    public void resultSetObjectConversion() {
        
        /* establish db connection if not already established */
        checkConnection();

        try {
            while (rs.next()) {

                /* create a new product object */
                Product newProduct = new Product();     
                newProduct.setId(rs.getInt("id"));
                newProduct.setName(rs.getString("name"));
                newProduct.setPrice(rs.getFloat("price"));
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

    /* database operations */ 
    /**
     * Adds a new product to this productCollection
     * @param name the name of the existing product
     * @param id of the product to add (cannot be altered)
     * @param name of the product to add
     * @param price of the product to add
     * @param type of the product to add
     * @param category of the product to add
     * @param page_url of the product to add
     * @param image_url of the product to add
     * @param summary of the product to add
     * @param description of the product to add
     * @param benefits of the product to add
     * @return int that database is updated
     */
    public int addProduct(int id, String name, float price, String type, 
            String category, String page_url, String image_url, String summary, 
            String description, String benefits) {
        
         //checks if a connection is established, starts connection if not 
        checkConnection();       
        
        if (debug) System.out.println("Attempting to add new product id = " + id);
        int result = 0;
        try {
            //estbalishes connection with database to execute insert query
            addProductPreparedStatement = conn.prepareStatement(
                    "INSERT INTO product ("
                            + "id, name, price, type, category, page_url, "
                            + "image_url, summary, description, benefits) "
                            + "VALUES (?,?,?,?,?,?,?,?,?,?)");
            addProductPreparedStatement.setInt(1, id);
            addProductPreparedStatement.setString(2, name);
            addProductPreparedStatement.setFloat(3, price);
            addProductPreparedStatement.setString(4, type);
            addProductPreparedStatement.setString(5, category);
            addProductPreparedStatement.setString(6, page_url);
            addProductPreparedStatement.setString(7, image_url);
            addProductPreparedStatement.setString(8, summary);
            addProductPreparedStatement.setString(9, description);
            addProductPreparedStatement.setString(10, benefits);
            result = addProductPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;    
    }

    /**
     * Updates a product in this productCollection and database
     * @param name the name of the existing product
     * @param id of the product to change (cannot be altered)
     * @param name of the product to change
     * @param price of the product to change
     * @param type of the product to change
     * @param category of the product to change
     * @param page_url of the product to change
     * @param image_url of the product to change
     * @param summary of the product to change
     * @param description of the product to change
     * @param benefits of the product to change
     * @return int that database is updated
     */
    public int updateProduct(int id, String name, float price, String type, 
            String category, String page_url, String image_url, String summary, 
            String description, String benefits) {
                //checks if a connection is established, starts connection if not 
        checkConnection();       
        
        if (debug) System.out.println("Attempting to update product id = " + id);
        int result = 0;
        try {
            //estbalishes connection with database to execute insert query
            updateProductPreparedStatement = conn.prepareStatement(
                    "UPDATE product SET "
                            + "name=?, price=?, type=?, category=?, page_url=?,"
                            + "image_url=?, summary=?, description=?, benefits=? "
                            + "WHERE id=?;"
            );
            updateProductPreparedStatement.setString(1, name);
            updateProductPreparedStatement.setFloat(2, price);
            updateProductPreparedStatement.setString(3, type);
            updateProductPreparedStatement.setString(4, category);
            updateProductPreparedStatement.setString(5, page_url);
            updateProductPreparedStatement.setString(6, image_url);
            updateProductPreparedStatement.setString(7, summary);
            updateProductPreparedStatement.setString(8, description);
            updateProductPreparedStatement.setString(9, benefits);
            updateProductPreparedStatement.setInt(10, id);
            result = updateProductPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;  
    }
    
    /**
    * deletes a product in this productCollection from the database
    * @param productId of the product to delete
    * @return int that database is updated
    */
    public int deleteProduct(int id) {
        
        /* establishes a connection with the database, if not already connected */
        checkConnection();     
        
        if (debug) System.out.println("Attempting to delete product id = " + id);
        int result = 0;
        
        /* executes delete query */
        try {
            deleteProductPreparedStatement = conn.prepareStatement(
                    "DELETE FROM product WHERE id = ?"
            );
            System.out.println(deleteProductPreparedStatement);
            deleteProductPreparedStatement.setInt(1, id);
            result = deleteProductPreparedStatement.executeUpdate(); 

        } catch (SQLException e) {
            System.out.println("ERROR HERE");
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
