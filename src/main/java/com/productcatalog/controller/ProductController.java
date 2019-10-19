package com.productcatalog.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.model.Category;
import com.productcatalog.model.Product;
import com.productcatalog.repository.productRepository;

@RestController
public class ProductController {
	
	@Autowired
	private productRepository productRepo;
	
	@GetMapping("/product")
	public List<Product> getAllProducts(Sort product){
		return productRepo.findAll(product);
	}
	
	@GetMapping("/product/{ProdId}")
	public Optional<Product> retrieveOne(@PathVariable long ProdId){
		return productRepo.findById(ProdId);
	}
	
	@PostMapping("/product/{CatId}")
	public Product createProduct(@PathVariable long CatId, @Valid @RequestBody Product product) {		
		return productRepo.save(product);
	}
	
	@PutMapping("/product/{ProdId}")
	public Optional<Product> updateProduct(@PathVariable Long ProdId, @Valid @RequestBody Product productUpdate) {
		return productRepo.findById(ProdId).map(product ->{
			product.setName(productUpdate.getName());
			product.setDetails(productUpdate.getDetails());
			product.setPrice(productUpdate.getPrice());
			product.setQuantity(productUpdate.getQuantity());
			product.setCategory(productUpdate.getCategory());
			return productRepo.save(product);
		})/*.orElseThrow(() -> new ResourceNotFoundException("CatId" + CatId + " not found"))*/;
	}
	
	
	@DeleteMapping("/product/{ProdId}")
	public Optional<Object> deleteproduct(@PathVariable Long ProdId){
		return productRepo.findById(ProdId).map(product -> {
			productRepo.delete(product);
			return ResponseEntity.ok().build();
		})/*.orElseThrow(() -> ResourceNotFoundException("CatId " + CatId + " not found"))*/;
	}

}
