package com.example._28_crud_proj.dao;

import com.example._28_crud_proj.ds.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
