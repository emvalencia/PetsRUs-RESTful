<%@page import = "com.uci.petsrusservice.model.Product"%>
<%@page import = "java.util.Enumeration"%>
<%@page import = "javax.ws.rs.core.UriInfo"%>
<%@page import = "org.codehaus.jackson.map.ObjectMapper;" %>
<%@page import = "org.codehaus.jackson.type.TypeReference; " %>
<%@page import = "org.glassfish.jersey.client.ClientConfig;" %>
<%@page import = "javax.servlet.http.HttpServlet;" %>
<%@page import = "javax.servlet.http.HttpServletRequest;" %>
<%@page import = "javax.servlet.http.HttpServletResponse;" %>
<%@page import = "javax.ws.rs.client.Client;" %>
<%@page import = "javax.ws.rs.client.ClientBuilder;" %>
<%@page import = "javax.ws.rs.client.WebTarget;" %>
<%@page import = "javax.ws.rs.core.MediaType;" %>
<%@page import = "javax.ws.rs.core.UriBuilder;" %>
<%@page import = "java.io.IOException;" %>
<%@page import = "java.io.PrintWriter;" %>
<%@page import = "java.net.URI;" %>
<%@page import = "java.util.List;" %>
<%@page import = "javax.servlet.annotation.WebServlet;" %>

<%
    ClientConfig configs = new ClientConfig();
    Client client = ClientBuilder.newClient(configs);

    WebTarget target = client.target("http://localhost:8080/PetsRUs-Restful");

    String jsonResponse =
    target.path("api").path("v1").path("products").path("1000000001").
            request().
            accept(MediaType.APPLICATION_JSON).
            get(String.class);

    ObjectMapper objectMapper = new ObjectMapper();

    Product product = objectMapper.readValue(jsonResponse, new TypeReference<Product>(){});

    out.println("<!doctype html>");
    out.println("<html lang=\"en\">");
    out.println("<head>");

    out.println("<meta charset=\"utf-8\">");
    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
    out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
    out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"../products.css\">");
    out.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"../../styles.css\">");
    out.println("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"../../../assets/favicon.ico\" />");
    out.println("<script src=\"../products.js\"></script>");
    out.println("<title>Petmate</title>");
    out.println("</head>");
    out.println("<body>");


    out.println("<div class=\"navbar2\">");
    out.println("<a href=\"/PetsRUs-Restful\">Home</a>");
    out.println("<a href=\"../../about.html\">About</a>");
    out.println("<div class=\"dropdown2\">");
    out.println("<button class=\"dropbtn2\">Products"); 
    out.println("<i class=\"fa fa-caret-down\"></i>");
    out.println("</button>");
    out.println("<div class=\"dropdown-content2\">");
    out.println("<a href=\"../allproducts.jsp\">All Products</a>");
    out.println("<a href=\"../dog.html\">Dogs</a>");
    out.println("<a href=\"../cat.html\">Cats</a>");
    out.println("<a href=\"../reptile.html\">Reptiles</a>");
    out.println("</div>");
    out.println("</div>"); 
    out.println("</div>");

    out.println("<div class=\"container-fluid\">");

    out.println("<div class=\"row pt-2\">");
    out.println("<div class=\"col-2\"></div>");
    out.println("<div class=\"col-8 purple-header\">");
    out.println("<h3 id=\"product-name\">Petmate</h3>");
    out.println("</div>");
    out.println("<div class=\"col-2\"></div>");
    out.println("</div>");


    out.println("<div class=\"row pt-2\">");
    out.println("<div class=\"col-2\"></div>");
    out.println("<div class=\"col-sm\">");
    out.println("<img src=\"../../../assets/"+ product.getImageURL() + "\" class=\"large-image\"/>");
    out.println("</div>");
    out.println("<div class=\"col-sm\">");
    out.println("<h3 id=\"product-description\">" + product.getName() + "</h3>");
    out.println("<h3 id=\"product-price\"> $" + product.getPrice() + "</h3>");
    out.println("</div>");
    out.println("<div class=\"col-2\"></div>");
    out.println("</div>");

    out.println("<div class=\"row pt-2\">");
    out.println("<div class=\"col-2\"></div>");
    out.println("<div class=\"col-8\">");
    out.println("<p>");
    out.println("<strong>Description</strong>");
    out.println(product.getDescription());
    out.println("</p>");
    out.println("<p>");
    out.println("<strong>Key Benefits</strong>");
    out.println(product.getBenefits());
    out.println("</p>");
    out.println("</div>");
    out.println("<div class=\"col-2\"></div>");
    out.println("</div>");


    out.println("<div class=\"row pt-2\">");
    out.println("<div class=\"col-2\"></div>");
    out.println("<div class=\"col-8 purple-header\">");
    out.println("<h3>Purchase Item</h3>");
    out.println("</div>");
    out.println("<div class=\"col-2\"></div>");
    out.println("</div>");


    out.println("<div class=\"row pt-2 pb-5\">");
    out.println("<div class=\"col-2\"></div>");
    out.println("<div class=\"col\">");
    out.println("<form action=\"http://localhost:8080/PetsRUs-Restful/api/v1/orders\" method=\"POST\" name=\"submit-order-form\" class=\"needs-validation\" novalidate id=\"main-order-form\">");
    out.println("<h3>Product Information</h3>");
    out.println("<div class=\"form-row\">");
    out.println("<div class=\"form-group col-md-4\">");
    out.println("<label for=\"product-identifier\">Product ID Number#</label>");
    out.println("<input type=\"text\" class=\"form-control\" id=\"product-id-num\" name=\"product-id-num\" value=\""+product.getId() + "\" readonly>");
    out.println("</div>");
    out.println("<div class=\"form-group col-md-4\">");
    out.println("<label for=\"price\">Price</label>");
    out.println("<input  name=\"price\" type=\"text\" class=\"form-control\" id=\"price\" value=\"29.99\" readonly>");
    out.println("</div>");
    out.println("<div class=\"form-group col-md-4\">");
    out.println("<label for=\"quantity\">Quantity</label> ");
    out.println("<input oninput=\"validate_form('quantity')\" name=\"quantity\" type=\"text\" class=\"form-control\" id=\"quantity\" placeholder=\"3\" required>");
    out.println("<div class=\"invalid-feedback\">Please enter a quantity</div>");
    out.println("</div>");

    out.println("</div>");
    out.println("<h3>Shipping Address</h3>");
    out.println("<div class=\"form-row\">");
    out.println("<div class=\"form-group col-md-6\">");
    out.println("<label for=\"first-name\">First Name</label>");
    out.println("<input oninput=\"validate_form('first-name')\" name=\"first-name\" type=\"text\" class=\"form-control\" id=\"first-name\" placeholder=\"John\" required>");
    out.println("<div class=\"invalid-feedback\">Please enter your first name</div>");
    out.println("</div>");
    out.println("<div class=\"form-group col-md-6\">");
    out.println("<label for=\"last-name\">Last Name</label>");
    out.println("<input oninput=\"validate_form('last-name')\" name=\"last-name\" type=\"text\" class=\"form-control\" id=\"last-name\" placeholder=\"Doe\" required>");
    out.println("<div class=\"invalid-feedback\" >Please enter your last name</div>");

    out.println("</div>");
    out.println("</div>");
    out.println("<div class=\"form-row\">");
    out.println("<div class=\"form-group col-md-8\">");
    out.println("<label for=\"email-address\">Email Address</label>");
    out.println("<input oninput=\"validate_form('email-address')\" name=\"email-address\" type=\"email\" class=\"form-control\" id=\"email-address\" placeholder=\"johndoe@youremail.com\" required>");
    out.println("<div class=\"invalid-feedback\">Please enter a valid email address</div>");

    out.println("</div>");
    out.println("<div class=\"form-group col-md-4\" id=\"phone-form-group\">");
    out.println("<label for=\"phone\">Phone Number</label>");
    out.println("<input oninput=\"validate_form('phone')\" name=\"phone\" type=\"text\" class=\"form-control\" id=\"phone\" placeholder=\"123-123-1234\" required>");
    out.println("<div class=\"invalid-feedback\" id=\"phone-feedback\">Please enter as: 123-123-1234</div>");

    out.println("</div>");
    out.println("</div>");
    out.println("<div class=\"form-row\">");
    out.println("<div class=\"form-group col-md-12\">");
    out.println("<label for=\"inputAddress\">Address</label>");
    out.println("<input oninput=\"validate_form('inputAddress')\" name=\"inputAddress\" type=\"text\" class=\"form-control\" id=\"inputAddress\" placeholder=\"1234 Main St\" required>");
    out.println("<div class=\"invalid-feedback\">Please enter a valid address</div>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=\"form-row\">");
    out.println("<div class=\"form-group col-md-6\">");
    out.println("<label for=\"inputCity\">City</label>");
    out.println("<input oninput=\"validate_form('inputCity')\" name = \"inputCity\" type=\"text\" class=\"form-control\" id=\"inputCity\" placeholder=\"Pasadena\" required>");
    out.println("<div class=\"invalid-feedback\">Please enter your city</div>");

    out.println("</div>");
    out.println("<div class=\"form-group col-md-4\">");
    out.println("<label for=\"inputState\">State</label>");
    out.println("<select oninput=\"validate_form('inputState')\" id=\"inputState\" name=\"inputState\" class=\"form-control\" required>");
    out.println("<option value=\"\">Choose...</option>");
    out.println("<option value=\"California\">California</option>");
    out.println("<option value=\"Oregon\">Oregon</option>");
    out.println("<option value=\"Washington\">Washington</option>");
    out.println("</select>");
    out.println("<div class=\"invalid-feedback\">Please select a state</div>");
    out.println("</div>");
    out.println("<div class=\"form-group col-md-2\">");
    out.println("<label for=\"inputZip\">Zip</label>");
    out.println("<input oninput=\"validate_form('inputZip')\" name=\"inputZip\" type=\"text\" class=\"form-control\" id=\"inputZip\" placeholder=\"90003\" required>");
    out.println("<div class=\"invalid-feedback\">Please enter a valid zip code</div>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=\"form-group\">");
    out.println("<label for=\"inputShipping\">Shipping</label>");
    out.println("<select oninput=\"validate_form('inputShipping')\" id=\"inputShipping\" name=\"inputShipping\" class=\"form-control\" required>");
    out.println("<option value=\"\">Choose...</option>");
    out.println("<option value=\"overnight\">Overnight (1-day)</option>");
    out.println("<option value=\"expedited\">Expedited (2-3 business days)</option>");
    out.println("<option value=\"ground\">Ground (4-6 business days)</option>");
    out.println("</select>");
    out.println("<div class=\"invalid-feedback\">Please select a shipping option</div>");
    out.println("</div>");
    out.println("<h3>Payment Information</h3>");
    out.println("<div class=\"form-row\">");
    out.println("<div class=\"form-group col-md-6\">");
    out.println("<label for=\"credit-card\">Credit Card Information</label>");
    out.println("<input oninput=\"validate_form('credit-card')\" type=\"text\" class=\"form-control\" id=\"credit-card\" name=\"credit-card\" placeholder=\"1234-1234-1234-1234\" required>");
    out.println("<div class=\"invalid-feedback\">Please enter as: 1234-1234-1234-1234</div>");

    out.println("</div>");
    out.println("<div class=\"form-group col-md-3\">");
    out.println("<label for=\"csc\">CSC</label>");
    out.println("<input oninput=\"validate_form('csc')\" name=\"csc\" type=\"text\" class=\"form-control\" id=\"csc\" placeholder=\"123\" required>");
    out.println("<div class=\"invalid-feedback\">Please enter your 3-digit csc</div>");

    out.println("</div>");
    out.println("<div class=\"form-group col-md-3\">");
    out.println("<label for=\"inputCreditCardType\">Type of Card</label>");
    out.println("<select oninput=\"validate_form('inputCreditCardType')\" id=\"inputCreditCardType\" name=\"inputCreditCardType\" class=\"form-control\" required>");
    out.println("<option value=\"\">Choose...</option>");
    out.println("<option value=\"VISA\">VISA</option>");
    out.println("<option value=\"Mastercard\">Mastercard</option>");
    out.println("<option value=\"American Express\">American Express</option>");
    out.println("</select>");
    out.println("<div class=\"invalid-feedback\">Please select a card type</div>");
    out.println("</div>");
    out.println("</div>");
    out.println("<input disabled id=\"checkout-btn\" type=\"submit\" class=\"btn btn-success\" value=\"Checkout\">");
    out.println("</form>");
    out.println("</div>");
    out.println("<div class=\"col-2\"></div>");
    out.println("</div>");

    out.println("<script>");
    out.println("(function() {");
    out.println("'use strict';");
    out.println("window.addEventListener('load', function() {");
    out.println("var forms = document.getElementsByClassName('needs-validation');");
    out.println("var validation = Array.prototype.filter.call(forms, function(form) {");
    out.println("form.addEventListener('submit', function(event) {");
    out.println("if (form.checkValidity() === false) {");
    out.println("event.preventDefault();");
    out.println("event.stopPropagation();");
    out.println("}");
    out.println("form.classList.add('was-validated');");
    out.println("}, false);");
    out.println("});");
    out.println("}, false);");
    out.println("})();");
    out.println("</script>");
    out.println("</div>");


    out.println("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>");
    out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>");
    out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>");
    out.println("</body>");
    out.println("<div class=\"footer\">");
    out.println("<div>Designed and created by Kevin Florio, Emery Valencia, and Jose Vargas.</div>");
    out.println("<div>Copyright © 2019 PetsRUs, Inc. All Rights Reserved.</div>");
    out.println("</div>");
    out.println("</html>");

%>
