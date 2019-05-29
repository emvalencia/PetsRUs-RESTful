
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
PetsRUs is a simple, interactive e-commerce website generated with HTML, CSS, JS,
Bootstrap, PHP, and Ajax. The website contains a homepage, about page, and multiple 
product pages. Each product page contains a form that allows the user to input information,
such as name, shipping address, and payment information, to buy the product, as per 
project guidelines.

index.php
The index.php file leads to the website's homepage. The top of the website has
consists of a navigation bar that will take you to 3 sections: the homepage, 
the about page, and the main (all) products page. The 3rd tab has a dropdown menu
that will navigate to 4 different categories of pet items based on pet type (all, 
dog, cat, and reptile). 

about.php
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

This requirement is fulfilled in the index.jsp. The product directory is
retrieved from the database and displayed in the PetsRUs webpage. 

2. Create REST services to allow for interaction with the order and product 
resources stored in your application database. You will need to implement 
services that use the following verbs: GET, PUT, POST, DELETE

TODO

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

Service:            TODO
Method type:        TODO
Request URL:        TODO
Sample response:    TODO
Sample request:     TODO

/------------------------------------------------------------------------------
ADDITIONAL INFORMATION
/------------------------------------------------------------------------------

References and sources for product information: petco.com, chewy.com, walmart.com