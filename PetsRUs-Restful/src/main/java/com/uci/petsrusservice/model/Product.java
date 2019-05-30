package com.uci.petsrusservice.model;

public class Product {
    
    /* class variables */
    private int id;
    private String name;
    private float price;
    private String type;
    private String category;
    private String page_url;
    private String image_url;
    private String summary;
    private String description;
    private String benefits;
    
    /* id */
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    
    /* name */
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    
    /* price */
    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice() {
        return this.price;
    }
    
    /* type */
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
    
    /* category */
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return this.category;
    }
    
    /* page_url */
    public void setPageURL(String page_url) {
        this.page_url = page_url;
    }
    public String getPageURL() {
        return this.page_url;
    }
    
    /* image_url */
    public void setImageURL(String image_url) {
        this.image_url = image_url;
    }
    public String getImageURL() {
        return this.image_url;
    }
    
    /* summary */
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getSummary() {
        return this.summary;
    }
    
    /* description */
    public void setDecription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
    
    /* benefits */
    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
    public String getBenefits() {
        return this.benefits;
    }
    
}
