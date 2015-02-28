package demo;

import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/inventory")
public class InventoryService {

	private Logger log = Logger.getLogger(InventoryService.class);

    @RequestMapping(method = RequestMethod.GET)
    public boolean isValidInventory(@RequestParam(value="id", defaultValue="1") String id) {
		log.info("Validating id: "+id);
		if (id.equals("0")) {
			return false;
		} else {
			return true;
		}
    }
}