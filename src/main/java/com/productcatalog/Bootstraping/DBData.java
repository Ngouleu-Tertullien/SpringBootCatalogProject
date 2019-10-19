/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productcatalog.Bootstraping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.productcatalog.model.Category;
import com.productcatalog.model.Product;
//import java.util.List;
import com.productcatalog.repository.*;

/**
 *
 * @author Tert
 */
@Component
public class DBData implements CommandLineRunner{
	
	@Autowired
    private final productRepository productRepository;
    @Autowired
    private final categoryRepository categoryRepository;
  
   public DBData (productRepository productRepo, categoryRepository categoryRepo) {
        this.productRepository = productRepo;
        this.categoryRepository = categoryRepo;
    }
    
 
    @Override
    public void run (String... args) throws Exception {
    	 ///Category
      
        Category t1 = new Category();
        
        t1.setId(1);
        t1.setName("Phone");
        categoryRepository.save(t1);
       
        Category t2 = new Category();
        t2.setId(2);
        t2.setName("Phone");
        categoryRepository.save(t2);
        
        Category t3 = new Category();
        t3.setId(3);
        t3.setName("Phone");
        categoryRepository.save(t3);
       
        
    
       
       
       
       
       System.out.println("Customers Saves" + productRepository);   
    
		
		 System.out.println("Loading Customers Data");
		  
		  Product c1 = new Product(); 
		  c1.setName("USB"); 
		  c1.setQuantity(51);
		  c1.setPrice(2500);		  
		  c1.setDetails("Saandpit");
		  c1.setCategory(new Category(1));
		  productRepository.save(c1);
		  
		  Product c2 = new Product(); 
		  c2.setName("Iphone x"); 
		  c2.setQuantity(7);
		  c2.setPrice(3500);		  
		  c2.setDetails("TKC");
		  c2.setCategory(new Category(2));
		  productRepository.save(c2);
		  
		  Product c3 = new Product(); 
		  c3.setName("Samsung fold"); 
		  c3.setQuantity(14);
		  c3.setPrice(800000);
		  c3.setDetails("Latest"); 
		  c3.setCategory(new Category(3));
		  productRepository.save(c3);
		  
       
		  System.out.println("ategory Saves" +categoryRepository.count());
    
    }
    
    
    
}
