package com.ajai.restful.productcatalogue.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajai.restful.productcatalogue.entity.Product;
import com.ajai.restful.productcatalogue.service.ProductCatalogueService;

@RestController
@RequestMapping("/product-catalogue")
public class ProductCatalogueController {
	
	@Autowired
	ProductCatalogueService productCatalogueServices;
	
	@GetMapping("/product/all")
	public List<Product> getAllProducts() {
		return productCatalogueServices.getAllProducts();
	}
	
	@GetMapping("/product")
	@ResponseBody
	public List<Product> searchProduct(@RequestParam Map<String, String> allParams){
		return productCatalogueServices.searchProduct(allParams);
	}
	
	@PostMapping("/product")
	@ResponseBody
	public Product addProduct(@RequestBody Product product) {
		return productCatalogueServices.addProduct(product);
	}
	
	@DeleteMapping("/product/{id}")
	@ResponseBody
	public String deleteProduct(@PathVariable("id") long id){
		return productCatalogueServices.deleteProduct(id);
	}
 
}
