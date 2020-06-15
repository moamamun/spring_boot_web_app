package com.springframework.springwebapp.controllers;

import com.springframework.springwebapp.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepo bookRepo;

    public BookController(BookRepo bookRep) {
        this.bookRepo = bookRep;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepo.findAll());
        return "books/list";
    }
}
