/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.productcatalog.model.Category;
/**
 *
 * @author collins
 */
public interface categoryRepository extends JpaRepository<Category, Long> {

    //public Category saveAndFlush (Long id);
    
}
