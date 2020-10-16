package com.ajai.restful.productcatalogue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.ajai.restful.productcatalogue.entity.Product;

public interface ProductCatalogueRepository extends JpaRepository<Product, Long> {

	@Query("select products from Product products where lower(products.productType)like %:productType%")
	List<Product> findByProductType(@Param("productType") String productType);
	
	@Query("select products from Product products where lower(products.supplier) like %:supplier%")
	List<Product> findBySupplier(@Param("supplier") String supplier);
	
	@Query("select products from Product products where lower(products.name) like %:name%")
	List<Product> findByName(@Param("name") String name);
	
	@Modifying
    @Transactional
    @Query("delete from Product products where products.id = :id ")
    void deleteById(@Param("id") Long id);
	
}
