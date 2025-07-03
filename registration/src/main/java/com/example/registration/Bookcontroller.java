package com.example.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Bookcontroller {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/")
    public String listBooks(Model model) {
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        book.setId((int) (books.size() + 1));  // Auto ID
        books.add(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        books.removeIf(b -> b.getId()==(id));
        return "redirect:/";
    }
}