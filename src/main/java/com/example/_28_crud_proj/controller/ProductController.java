package com.example._28_crud_proj.controller;

import com.example._28_crud_proj.dao.CategoryDao;
import com.example._28_crud_proj.dao.ProductDao;
import com.example._28_crud_proj.ds.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
public class ProductController {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductDao productDao;

    @GetMapping("/category")
    public String categoryForm(Model model){
        model.addAttribute("category",new Category());
        return "category-form";
    }

    @PostMapping("/category")
    public String saveCategory(Category category, BindingResult result){
        if(result.hasErrors()){
            return "category-form";
        }

        categoryDao.save(category);
        return "redirect:/list-category";
    }

    @GetMapping("/list-category")
    public String listCategory(Model model){
        model.addAttribute("categories",categoryDao.findAll());
        return "list-category";
    }
}
