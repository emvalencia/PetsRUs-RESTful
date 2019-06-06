
/------------------------------------------------------------------------------
    Authors:
    Emery Valencia, SID: 59325878   netid: emvalenc
    Jose Vargas, SID: 14677838      netid: kflorio
    Kevin Florio, SID: 10816068     netid: josev3 
/------------------------------------------------------------------------------

/------------------------------------------------------------------------------
GENERAL WEBSITE INFORMATION 
/------------------------------------------------------------------------------

Website URL: http://centaurus-1.ics.uci.edu:1045/index/

General Description 
PetsRUs is a simple, interactive e-commerce RESTful website generated with 
HTML, CSS, JS,Bootstrap. The website contains a homepage, 
about page, and multiple product pages. Each product page contains a form that 
allows the user to input information, such as name, shipping address, and payment 
information, to buy the product, as per project guidelines.

index.html
The index.php file leads to the website's homepage. The top of the website has
consists of a navigation bar that will take you to 3 sections: the homepage, 
the about page, and the main (all) products page. The 3rd tab has a dropdown menu
that will navigate to 4 different categories of pet items based on pet type (all, 
dog, cat, and reptile). 

about.html
The about.html page contains information about PetsRUs, including redirections to
product pages and information about the management team. 

product-pages
Clicking on tab dropdowns in the products tab will take you to the main page
for each pet type or all products. Each of those product pages has a list of all 
products available for that pet. Clicking on the "more info" button or product 
picture will lead you to that individual product's page. The product page contains 
additional information about a product, key features, and a product order form. 

order form
The order form collects and verifies information required to order the product 
and open an email. Fill in the form to completion and click on the "checkout"
button to continue with the transaction and open the email. 

/------------------------------------------------------------------------------
REQUIREMENTS SECTION 
/------------------------------------------------------------------------------
1. Using JSP reimplement the product list page. This is the page that contains 
the list of your products. 

This requirement is fulfilled in the allproducts.jsp file in src/product-pages. 
The product directory is retrieved from the database and displayed as a webpage. 

2. Create REST services to allow for interaction with the order and product 
resources stored in your application database. You will need to implement 
services that use the following verbs: GET, PUT, POST, DELETE

Implemented in Source Packages under petsruseservice.
- petsrusservice: contains the ProductResource which performs all HTTP requests
    (GET, POST, PUT, and DELETE) on the product table in the database. Contains
    OrderResource which performs POST request for the order form to submit to 
    the database.
- petsrusservice.db: contains the ProductDBManager which performs all database
    connections and management operations (adding new products, deleting products,
    updating products, getting database information, establishing database 
    connection...). Contains the OrderDBManager which performs all database
    connections and management operations (add orders to database).
- petsusservice.model: contains the Product class which holds a product's 
    information.
- petsrusservice.service: establishes the petsrusservice to create the API.

*******************************************************************************
        Screenshots are located in Source Packages > examples directory
*******************************************************************************
Example commands via Postman: 
    GET http://localhost:8080/PetsRUs-Restful/api/v1/products/
        (retrives the database in JSON format)
    POST http://localhost:8080/PetsRUs-Restful/api/v1/products/ 
        (in x-www-form-urlencoded, adds a new product to the database via
        product id)
        id              1000000012
        name            test12
        price           12.99
        type            toy
        category        dog
        summary         stuff
        description     stuff
        benefits        stuff
        pageURL         n/a
        imageURL        n/a
    PUT http://localhost:8080/PetsRUs-Restful/api/v1/products/1000000011?
       (in x-www-form-urlencoded, can change any parameter that is NOT id, 
        updates an existing product in the database via product id)
        name            newName
    DELETE http://localhost:8080/PetsRUs-Restful/api/v1/products/1000000012?id=1000000012
        (deletes a product from the database via product id)

3. You will now need to replace all the database interactions in your web 
application with REST calls. Your web application will now act as a REST client 
and retrieve the MySQL data indirectly through the new RESTful web service. That 
is, you will have two applications: (1) a backend application that provides 
RESTful APIs that essentially exposes the available operations in your database, 
and (2) an application that is the client of the RESTful APIs, generates the 
HTML pages, and handles requests from the user.  While in this assignment you 
are developing both applications yourself, in practice, each application may be 
developed by a separate company. For example, companies such as Google, Amazon, 
and PayPal may develop the RESTful APIs that allow others to leverage their 
services in building their web applications. 

In the readme file, provide proper documentation highlighting the details for 
each RESTful service method that you implement. Your documentation should include 
the following at the very least: Method Type, Request URL, Sample Response, 
Sample Request (if applicable)

/-------------------------------------------------------------------------------
Products:
Method type:    GET (all products)
Request URL:    http://localhost:8080/PetsRUs-Restful/api/v1/products/
Sample response:    
{
    "productDatabase": [
        {
            "id": 1000000001,
            "name": "Petmate® Compass Fashion Pet Carrier",
            "price": 29.99,
            "type": "other",
            "category": "cat",
            "summary": "The Petmate cat carrier comes in a bright hot pink color 
                        and is perfect for most cat sizes! It has Quick Slide N 
                        Snap technology that allows for easy assembly. It also 
                        provides 360-degree ventilation and has a 
                        Quick-Latch-2-way door.",
            "description": "Redefine pet training and transportation with the 
                        Petmate Compass. This crate comes with a straightforward 
                        assembly process that takes only seconds, so you waste 
                        less time setting up and more time getting out. It's the 
                        perfect companion for traveling and potty training your 
                        new pup. With Petmate's Quick-Latch design, increased 
                        ventilation and larger doorway size, the Compass combines 
                        the ultimate convenience for pet parents and extra 
                        comfort for pets. Travel and train in style with a 
                        kennel that takes ingenuity to new heights.",
            "benefits": "Quick Slide 'N Snap assembly allows quick assembly 
                        without tools. 360-degree ventilation & visibility means 
                        a more comfortable journey for your pet. Additional 
                        doorway size for comfort. Meets most airlines 
                        requirements. Quick-Latch 2-Way door design opens left 
                        or right, and stays closed with safeguard door bars at 
                        top and bottom.",
            "imageURL": "cat-carrier.jpg",
            "pageURL": "/src/product-pages/cat-pages/cat-carrier.php"
        },
        ...... (whole database) 
}
Sample request: http://localhost:8080/PetsRUs-Restful/api/v1/products/ 

Method type:    GET (individual product)
Request URL:    http://localhost:8080/PetsRUs-Restful/api/v1/products/1000000001
Sample response:    
{
    "id": 1000000001,
    "name": "Petmate® Compass Fashion Pet Carrier",
    "price": 29.99,
    "type": "other",
    "category": "cat",
    "summary": "The Petmate cat carrier comes in a bright hot pink color and is 
                perfect for most cat sizes! It has Quick Slide N Snap technology 
                that allows for easy assembly. It also provides 360-degree 
                ventilation and has a Quick-Latch-2-way door.",
    "description": "Redefine pet training and transportation with the Petmate 
                Compass. This crate comes with a straightforward assembly process 
                that takes only seconds, so you waste less time setting up and 
                more time getting out. It's the perfect companion for traveling 
                and potty training your new pup. With Petmate's Quick-Latch 
                design, increased ventilation and larger doorway size, the 
                Compass combines the ultimate convenience for pet parents and 
                extra comfort for pets. Travel and train in style with a kennel 
                that takes ingenuity to new heights.",
    "benefits": "Quick Slide 'N Snap assembly allows quick assembly without         
                tools. 360-degree ventilation & visibility means a more 
                comfortable journey for your pet. Additional doorway size for 
                comfort. Meets most airlines requirements. Quick-Latch 2-Way 
                door design opens left or right, and stays closed with safeguard 
                door bars at top and bottom.",
    "imageURL": "cat-carrier.jpg",
    "pageURL": "/src/product-pages/cat-pages/cat-carrier.php"
}
Sample request:     http://localhost:8080/PetsRUs-Restful/api/v1/products/1000000001

Method type:        PUT
Request URL:        http://localhost:8080/PetsRUs-Restful/api/v1/products/id
Sample response:    (updates entire database, displays whole database in Postman)
Sample request:     http://localhost:8080/PetsRUs-Restful/api/v1/products/
                    1000000001?id=1000000001

Method type:        DELETE
Request URL:        http://localhost:8080/PetsRUs-Restful/api/v1/products/id
Sample response:    (updates entire database, displays whole database in Postman)
Sample request:     http://localhost:8080/PetsRUs-Restful/api/v1/products/
                    1000000001?id=1000000001

/-------------------------------------------------------------------------------
Orders:
Method type:        POST
Request URL:        http://localhost:8080/PetsRUs-Restful/api/v1/products/
Sample response:    TODO
Sample request:     TODO

/------------------------------------------------------------------------------
ADDITIONAL INFORMATION
/------------------------------------------------------------------------------

References and sources for product information: petco.com, chewy.com, walmart.com