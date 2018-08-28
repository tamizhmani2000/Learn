/*services to retrieve product data*/
package com.springcommerce;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/product")
class ProductController{
	
	 @Autowired
	 private DiscoveryClient discoveryClient;
	 
	 @Autowired
	 ProductService productservice; 
	
	 @RequestMapping("/service-instances/{applicationName}")
	    public List<ServiceInstance> serviceInstancesByApplicationName(
	            @PathVariable String applicationName) {
	        return this.discoveryClient.getInstances(applicationName);
	    }
	 
	@RequestMapping(value="/",method=RequestMethod.GET)
	public HashMap<String,Product>getAllProducts() {
		return productservice.getAllProducts();
	}
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Product viewProduct(@RequestParam(value="pid")String pid) {
		return productservice.viewProduct(pid);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Product addProduct(@RequestParam(value="pid")String pid,@RequestParam(value="name")String name) {
		
		productservice.addProduct(pid, name);
		return productservice.viewProduct(pid); 
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) throws Exception{
		
		productservice.updateProduct(product);
		return product;
	}
	
	public Product deleteProduct(@PathVariable String id) throws Exception{
		
		Product product = productservice.deleteProduct(id);
		return product;
	}
}
	
