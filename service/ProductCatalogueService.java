package com.ajai.restful.productcatalogue.service;

import java.util.List;
import java.util.Map;

import com.ajai.restful.productcatalogue.entity.Product;

public interface ProductCatalogueService {
	
	List<Product> getAllProducts();
	
	List<Product> searchProduct(Map<String,String> allRequstParam);
	
	Product addProduct(Product product);
	
	String deleteProduct(long id);

}
