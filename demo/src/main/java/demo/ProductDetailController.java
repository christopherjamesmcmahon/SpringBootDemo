package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/products")
public class ProductDetailController {
    private final ProductDetailRepository repository;
    private final ProductDetailValidator validator;
	private Logger log = Logger.getLogger(ProductDetailController.class);
	
    @Autowired
    public ProductDetailController(ProductDetailRepository repository, ProductDetailValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable findAll() {
		log.info("Recovering all products");
        return repository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public ProductDetail create(@RequestBody @Valid ProductDetail detail) {
		log.info("Storing product: "+detail.getProductId());
        return repository.save(detail);
    }
}