package com.example._28_crud_proj.dao;

import com.example._28_crud_proj.ds.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
