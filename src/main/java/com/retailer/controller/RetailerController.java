package com.retailer.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.retailer.entity.Retailer;
import com.retailer.service.RetailerService;

@RestController
@RequestMapping("/retailer")
public class RetailerController { 
	
	
	@Autowired
	private RetailerService retailerServ;
	
	@PostMapping("/addRetailer")
	public ResponseEntity<?> addRetailer(@RequestBody Retailer retailer) {
		return new ResponseEntity<Retailer> (retailerServ.addRetailer(retailer), HttpStatus.CREATED);
	}
	
	@GetMapping("/getRetailer/{retailerId}")
	@HystrixCommand(fallbackMethod = "fallback_getRetailer", commandProperties = {
	        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	public ResponseEntity<?> getRetailer(@PathVariable Long retailerId){
		return new ResponseEntity<Retailer> (retailerServ.getRetailer(retailerId), HttpStatus.OK);
	}
	
	@GetMapping("/getRetailer")
	@HystrixCommand(fallbackMethod = "fallback_getAllRetailers", commandProperties = {
	        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	public ResponseEntity<?> getAllRetailers() {
		return new ResponseEntity<List<Retailer>> (retailerServ.getAllRetailers(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteRetailer/{retailerId}")
	public ResponseEntity<?> deleteRetailer(@PathVariable Long retailerId) {
		return new ResponseEntity<String> (retailerServ.deleteRetailer(retailerId), HttpStatus.OK);
	}
	
	@PutMapping("/updateRetailer/{retailerId}")
	public ResponseEntity<?> updateRetailer(@PathVariable Long retailerId, @RequestBody Retailer retailer) {
		retailerServ.updateRetailer(retailerId, retailer);
		return new ResponseEntity<Retailer> (retailerServ.getRetailer(retailerId), HttpStatus.OK);
	}
	
	private ResponseEntity<?> fallback_getRetailer(Long retailerId) {
        // Fallback response when getRetailer fails
        return new ResponseEntity<String>("Unable to fetch retailer. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private ResponseEntity<?> fallback_getAllRetailers() {
        // Fallback response when getAllRetailers fails
        return new ResponseEntity<String>("Unable to fetch retailers. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
