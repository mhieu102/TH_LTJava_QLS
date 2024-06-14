package com.example.TH_LTJava_QLS.Controller;


import com.example.TH_LTJava_QLS.Model.Book;
import com.example.TH_LTJava_QLS.Model.Category;
import com.example.TH_LTJava_QLS.services.BookService;
import com.example.TH_LTJava_QLS.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories/list";
    }

    @GetMapping("/add")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());

        return "categories/add";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/categories";
    }


    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") long id, Model model) {
        model.addAttribute("categories", categoryService.getCategoryById(id));
        return "categories/edit";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@ModelAttribute("book") Category category) {
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
