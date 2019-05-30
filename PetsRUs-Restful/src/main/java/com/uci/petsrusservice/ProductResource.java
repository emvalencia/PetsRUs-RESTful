package com.uci.petsrusservice;

/* imports */
import com.uci.petsrusservice.db.ProductDBManager;
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
    
    private ProductDBManager productDBManager;

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
        return getJsonDatabase();    
    }
    
    //returns database as json data
    private String getJsonDatabase() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";

        try {
            jsonString = mapper.writeValueAsString(productDBManager.getProductCollection());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
        
  
}
