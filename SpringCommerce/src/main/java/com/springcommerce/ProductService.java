/*services to retrieve product data*/
package com.springcommerce;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/product")
class ProductService{
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public HashMap<String,Product>getAllProducts() {
		return SpringCommerceApplication.productList;
	}
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Product viewProduct(@RequestParam(value="pid")String pid) {
		return SpringCommerceApplication.productList.get(pid);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Product addProduct(@RequestParam(value="pid")String pid,@RequestParam(value="name")String name) {
		
		Product dynamic= new Product(pid,name);
		
		SpringCommerceApplication.productList.put(dynamic.getProductId(), dynamic);
		return SpringCommerceApplication.productList.get(pid); 
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) throws Exception{
		
		if (SpringCommerceApplication.productList.containsKey(product.getProductId())) {
			SpringCommerceApplication.productList.put(product.getProductId(), product);
		} else {
			throw new Exception("Product ID : "+ product.getProductId() + " does not exist");
		}
		
		return product;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable String id) throws Exception{
		
		Product product;
		if (SpringCommerceApplication.productList.containsKey(id)) {
			product = SpringCommerceApplication.productList.get(id);
			SpringCommerceApplication.productList.remove(product.getProductId());
		} else {
			throw new Exception("Product ID : "+ id + " does not exist");
		}
		
		return product;
	}
}
	
