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

I created this project to experiment directly with Spring Boot and microservices directly rather than just reading examples.

## Installation

- Install gradle: https://gradle.org/ (Add the gradle bin directory to your PATH variable)
- Checkout project
- Navegate to SpringBootDemo\demo
- gradle bootRun 

