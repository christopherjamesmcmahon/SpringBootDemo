package demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
import org.springframework.web.client.RestTemplate;
import org.apache.log4j.Logger;

@Component
public class ProductDetailValidator implements Validator {
    
	private Logger log = Logger.getLogger(InventoryService.class);
	
    @Override
    public boolean supports(Class<?>clazz) {
        return ProductDetail.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	log.info("Validating product");
        ProductDetail detail = (ProductDetail)target;
		String id = detail.getInventoryId();
    	log.info("Product ID: "+id);
    	
	    RestTemplate restTemplate = new RestTemplate();
        Boolean valid = restTemplate.getForObject("http://localhost:8080/inventory?id={id}", Boolean.class,id);
    	log.info("Validity result: "+valid);
		if (!valid.booleanValue()) {
			errors.rejectValue("inventoryId", "inventory.id.invalid", "Inventory ID is invalid");		
		}
    }
}