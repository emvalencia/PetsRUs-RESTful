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
