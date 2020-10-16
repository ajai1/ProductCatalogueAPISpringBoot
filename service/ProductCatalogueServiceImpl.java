package com.ajai.restful.productcatalogue.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.ajai.restful.productcatalogue.entity.Product;
import com.ajai.restful.productcatalogue.repository.ProductCatalogueRepository;

@Service
@ComponentScan(basePackages="com.ajai.restful.productcatalogue.database")
public class ProductCatalogueServiceImpl implements ProductCatalogueService {
	
	
	@Autowired
	ProductCatalogueRepository productCatalogueRepository;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> allProd = Arrays.asList(new Product(1,"GoodDay", "Its a biscuit", "123",
				"Biscuits", 10,100));
		return productCatalogueRepository.findAll();
	}

	public Product addProduct(Product product) {
		if(product !=null){
			return productCatalogueRepository.save(product);
		}
		// TODO Auto-generated method stub
		return new Product();
	}

	@Override
	public List<Product> searchProduct(Map<String, String> allRequstParam) {
		if(!CollectionUtils.isEmpty(allRequstParam)){
			for(Entry<String, String> entry : allRequstParam.entrySet()){
				String param = entry.getKey();
				String val = entry.getValue();
				if("productType".equalsIgnoreCase(param) && !StringUtils.isEmpty(val)){
					return productCatalogueRepository.findByProductType(val.toLowerCase());
				}
				if("supplier".equalsIgnoreCase(param) && !StringUtils.isEmpty(val)){
					return productCatalogueRepository.findBySupplier(val.toLowerCase());
				}
				if("name".equalsIgnoreCase(param) && !StringUtils.isEmpty(val)){
					return productCatalogueRepository.findByName(val.toLowerCase());
				}
			}
		}
		return null;
	}
	
	@Override
	public String deleteProduct(long id) {
		productCatalogueRepository.deleteById(id);
		return "Product Removed";
	}
	
	
	

}
