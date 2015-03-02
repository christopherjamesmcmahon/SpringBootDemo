# SpringBootDemo

## Synopsis

This is a sample project to demonstrate some of the capabilities available in Spring Boot for creating Microservices.  It is based on the article: http://www.infoq.com/articles/boot-microservices

## Code Example

        ProductDetail detail1 = new ProductDetail();
        detail1.setProductId("ABCD1234");
        detail1.setProductName("Dan's Book of Writing");
        detail1.setShortDescription("A book about writing books.");
        detail1.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
        detail1.setInventoryId("009178461");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:8080/products", detail1, ProductDetail.class);
		

## Motivation

I created this project to experiment directly with Spring Boot and microservices directly rather than just reading examples.  I've changed the examples to use inter service calls via REST.  The InventoryService is not really RESTful but I wanted to get the example up and running as quick as possible.

## Installation

- Install gradle: https://gradle.org/ (Add the gradle bin directory to your PATH variable)
- Checkout project
- Navegate to SpringBootDemo\demo
- gradle bootRun (CTRl-C to stop process)

## Executing

To retrieve list of products:

http://localhost:8080/products

[
	{	"productId":"ABCD1234",
		"productName":"Dan's Book of Writing",
		"shortDescription":"A book about writing books.",
		"longDescription":"In this book about writing books, Dan will show you how to write a book.",
		"inventoryId":"009178461"}
]

To check an inventory item:

http://localhost:8080/inventory?id=2

true

http://localhost:8080/inventory?id=0

false

To add a product:

POST: http://localhost:8080/product

{
    	"productId" : "ABCD1234",
    	"productName" : "A Book",
    	"shortDescription" : "A really good book",
    	"longDescription" : "A really really good book",
    	"inventoryId" : "0123234" 
}

Using the shell script (bash):

The script "postproduct.sh" receives one parameter, the name of the .txt containing the REST message to send to the /products endpoint.  
