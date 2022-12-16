package com.example._28_crud_proj.controller;

import com.example._28_crud_proj.dao.CategoryDao;
import com.example._28_crud_proj.dao.ProductDao;
import com.example._28_crud_proj.ds.Category;
import com.example._28_crud_proj.ds.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
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


    @GetMapping("/product")
    public ModelAndView productForm(@ModelAttribute("categories")List<Category>categories){
        ModelAndView mv=new ModelAndView("product-form","product",new Product());
        mv.addObject("categories",categories);
        return mv;
    }

    @Transactional
    @PostMapping("/product")
    public String saveProduct(Product product,BindingResult result){
        if(result.hasErrors()){
            return "product-form";
        }
        Category category=categoryDao.findById(product.getCategory().getId()).get();
        category.addProduct(product);
        productDao.save(product);
        return "redirect:/list-product";
    }

    @GetMapping("list-product")
    public String listProduct(Model model){
        model.addAttribute("products",productDao.findAll());
        return "list-product";
    }

    @ModelAttribute("categories")
    public List<Category>listCategory(){
        return categoryDao.findAll();
    }
}
