package com.uci.petsrusservice.collections;

import com.uci.petsrusservice.model.Product;
import java.util.ArrayList;

public class ProductCollection {
    
    /* private member variables */
    private ArrayList<Product> productDatabase; 
    private int productCount;
 
    /* default constructor */
    public ProductCollection(){
        productDatabase = new ArrayList<Product>();
        this.productCount = 0;
    }
    
    /* getters and setters */
    public void setProductDatabase(ArrayList<Product> newProductDatabase) {
        this.productDatabase = newProductDatabase;
    }
    
    public ArrayList<Product> getProductDatabase() {
        return this.productDatabase;
    }
    
    /* add a product to this collection */
    public void addProduct(Product newProduct) {
        if (newProduct != null) {
            this.productDatabase.add(newProduct);
        }
        this.productCount = productDatabase.size();
    }
    
    /* deletes a product from this collection */
    public void removeProduct(Product productId) {
        /* TODO */
    }
    
}
