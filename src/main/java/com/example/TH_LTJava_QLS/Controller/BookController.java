package com.example.TH_LTJava_QLS.Controller;



import com.example.TH_LTJava_QLS.Model.Book;
import com.example.TH_LTJava_QLS.services.BookService;
import com.example.TH_LTJava_QLS.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/add")
    public  String addBookFrom(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("category", categoryService.getAllCategories());
        return "book/add";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book")Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }
}