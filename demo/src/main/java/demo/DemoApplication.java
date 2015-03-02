package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@ComponentScan
@EnableAutoConfiguration
public class DemoApplication {

   @Autowired
   private static RestTemplate restTemplate;
   private static Logger log = Logger.getLogger(DemoApplication.class);

	public static void main(String[] args) {
       ApplicationContext ctx = SpringApplication.run(DemoApplication.class);
	   
        /** 
		
		STRANGE!!!  When this is launched in a windows environment the code executes no problem whereas on
		the we receive a 400...and I was unable to get a useful log message.
			
		As an alternative I've created a shell script to post the message instead: postproduct.sh
			
		ProductDetail detail1 = new ProductDetail();
        detail1.setProductId("ABCD1234");
        detail1.setProductName("Dan's Book of Writing");
        detail1.setShortDescription("A book about writing books.");
        detail1.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
        detail1.setInventoryId("009178461");
		
        ProductDetail detail2 = new ProductDetail();
        detail2.setProductId("XYZ567");
        detail2.setProductName("Bad Book");
        detail2.setShortDescription("A bad book");
        detail2.setLongDescription("A very bad book");
        detail2.setInventoryId("0");		
		
		RestTemplate restTemplate = new RestTemplate();
				
		log.info("Storing a valid product");
		restTemplate.postForObject("http://localhost:8080/products", detail1, ProductDetail.class);

		log.info("Storing an invalid product");		
		restTemplate.postForObject("http://localhost:8080/products", detail2, ProductDetail.class);
		**/

    }
}