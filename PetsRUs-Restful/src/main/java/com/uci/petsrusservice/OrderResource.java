package com.uci.petsrusservice;

/* imports */
import com.uci.petsrusservice.db.OrderDBManager;
import com.uci.petsrusservice.db.ProductDBManager;
import com.uci.petsrusservice.model.Product;
import java.io.IOException;
import java.util.Random;
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

@Path("/v1/orders/")
public class OrderResource {
    
    /* private data members */
    private OrderDBManager orderDBManager;
    boolean debug = true;

    /* default constructor */
    public OrderResource() {
        orderDBManager = new OrderDBManager();
    }
     
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addProductResource(
            
            @FormParam("product-id-num") int product_num,
            @FormParam("price") float price,
            @FormParam("quantity") int qty, 
            @FormParam("first-name") String fname,
            @FormParam("last-name") String lname, 
            @FormParam("email-address") String email,
            @FormParam("phone") String phone, 
            @FormParam("inputAddress") String address,
            @FormParam("inputCity") String city, 
            @FormParam("inputState") String state,
            @FormParam("inputZip") int zip,
            @FormParam("inputShipping") String shipping_option,
            @FormParam("credit-card") String cc_num,
            @FormParam("csc") int csc_num,
            @FormParam("inputCreditCardType") String card_type
            
    ) {
        int order_num = 1000000000 + new Random().nextInt(900000000);
        
        orderDBManager.addOrder(order_num, price, product_num, qty, fname, lname,
                email, phone, address, state, city, zip, shipping_option, cc_num,
                csc_num, card_type);
        
    }

}
