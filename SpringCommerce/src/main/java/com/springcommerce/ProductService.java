/*services to retrieve product data*/
package com.springcommerce;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
class ProductService{

	 

	public HashMap<String,Product>getAllProducts() {
		return SpringCommerceApplication.productList;
	}
	
	
	public Product viewProduct(@RequestParam(value="pid")String pid) {
		return SpringCommerceApplication.productList.get(pid);
	}
	
	
	public Product addProduct(@RequestParam(value="pid")String pid,@RequestParam(value="name")String name) {
		
		Product dynamic= new Product(pid,name);
		
		SpringCommerceApplication.productList.put(dynamic.getProductId(), dynamic);
		return SpringCommerceApplication.productList.get(pid); 
	}
	

	public Product updateProduct(@RequestBody Product product) throws Exception{
		
		if (SpringCommerceApplication.productList.containsKey(product.getProductId())) {
			SpringCommerceApplication.productList.put(product.getProductId(), product);
		} else {
			throw new Exception("Product ID : "+ product.getProductId() + " does not exist");
		}
		
		return product;
	}
	

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
	
