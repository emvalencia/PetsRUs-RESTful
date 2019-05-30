package com.uci.petsrusservice;

/* imports */
import com.uci.petsrusservice.db.ProductDBManager;
import com.uci.petsrusservice.model.Product;
import java.io.IOException;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

@Path("/v1/products/")
public class ProductResource {
    
    /* private data members */
    private ProductDBManager productDBManager;
    boolean debug = true;

    /* default constructor */
    public ProductResource() {
        productDBManager = new ProductDBManager();
    }
      
    /**
     * Retrieves the database in JSON format
     * @return Returns entire product database as JSON
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDataAsJson() {   
        if (debug) System.out.println("Attempting to get JSON data...");
        return getJsonDatabase();    
    }
    
    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductModelInfo(@PathParam("productId") int productId) {   
        if (debug) {
            System.out.println("Attempting to get product data...");
            System.out.println(productId);
        }
        
        return getJsonDatabase(productDBManager.getProduct(productId));    
    }
    
     /**
     * Uses ObjectMapper to convert the object collection into JSON
     * @return Returns entire objects into JSON
     */
    private String getJsonDatabase() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";

        try {
            jsonString = mapper.writeValueAsString(productDBManager.getProductCollection());
            if (debug) System.out.println("Fetched JSON database...");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
    
    /**
     * Adds a new product resource to database Note that params must be in
     *  x-www-form-urlencoded format to use @FormParam
     * @param name the name of the new Ship
     * @param id the id of the new Ship; cannot be changed once initialized
     * @param location the location of the new Ship
     * @return - returns database after insertion of new data object
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addShipResource(@FormParam("id") int id, 
            @FormParam("name") String name, @FormParam("price") float price,
            @FormParam("type") String type, @FormParam("category") String category,
            @FormParam("page_url") String page_url, @FormParam("image_url") String image_url,
            @FormParam("summary") String summary, @FormParam("description") String description,
            @FormParam("benefits") String benefits
    ) {
        productDBManager.addProduct(id, name, price, type, category, page_url,
                image_url, summary, description, benefits);
        return getJsonDatabase();
    }

    /**
     * Updates an existing ship resource. Note that params must be in
     *  x-www-form-urlencoded format to use @FormParam.
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
     * @return returns database after object is updated 
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{shipId}")
    public String updateShipResource(@FormParam("name") String name, 
            @PathParam("id") int id, @FormParam("price") float price,
            @FormParam("type") String type, @FormParam("category") String category,
            @FormParam("page_url") String page_url, @FormParam("image_url") String image_url,
            @FormParam("summary") String summary, @FormParam("description") String description,
            @FormParam("benefits") String benefits
    ) {
        productDBManager.updateProduct(id, name, price, type, category, page_url,
                image_url, summary, description, benefits);
        return getJsonDatabase();
    }

    /**
     * Deletes an existing Product via id
     * @param productId the id of the Ship to be deleted
     * @return returns database after object deletion
     */
    @DELETE
    @Path("/{shipId}")
    public String deleteShipResource(@PathParam("shipId") String shipId) {
        productDBManager.deleteProduct(shipId);
        return getJsonDatabase();
    }
    
    /**
     * Uses ObjectMapper to convert the object into JSON
     * @return Returns entire objects into JSON
     */
    private String getJsonDatabase(Product productId) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";

        try {
            jsonString = mapper.writeValueAsString(productId);
            if (debug) System.out.println("Fetched JSON product...\n");

        } catch (IOException e) {
            if (debug) System.out.println("IO Exception occurred");
            e.printStackTrace();
        }

        return jsonString;
    }
        
  
}
