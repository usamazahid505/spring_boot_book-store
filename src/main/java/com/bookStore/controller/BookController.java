package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
//    @GetMapping("/available_books")  simple get all the books
//    public String getAllBooks(){
//        return "bookLists";
//    }

    @GetMapping("/available_books")   //
    public ModelAndView getAllBooks(){
        List<Book> list = bookService.getAllBooks();
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("bookList");
//        mav.addObject("book", list);
        return new ModelAndView("bookLists","book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        bookService.save(b);
        return "redirect:/available_books";
    }


}
