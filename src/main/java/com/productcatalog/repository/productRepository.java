/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productcatalog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productcatalog.model.Category;
import com.productcatalog.model.Product;

/**
 *
 * @author collins
 */
@Repository
    public interface productRepository extends JpaRepository<Product, Long> {
	 
	@SuppressWarnings("null")
	public default Product createProduct(Long catId, Product product) {
    	//Set<Product> products = new HashSet<>();
       // Category author1 = new Category();

        categoryRepository categoryRepo = null;
        
		Optional<Category> byId = categoryRepo.findById(catId);
//        if (!catId.isPresent()) {
//            throw new ResourceNotFoundException("Author with id " + catId + " does not exist");
//        }
        Category category = byId.get();

        //tie Author to Book
        product.setCategory(category);

        productRepository productRepo = null;
		Product product1 = productRepo.save(product);
        //tie Book to Author
        //products.add(product1);
        
        return product1;

    }

    
    
}
