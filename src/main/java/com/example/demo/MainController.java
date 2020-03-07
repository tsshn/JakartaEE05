package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class MainController {

    private Repository repository;

    @Autowired
    public MainController(Repository repository) {
        this.repository = repository;
    }

    @RequestMapping({"/", ""})
    public String allBooks(Model model) {
        ArrayList<Book> books = repository.getLibrary();
        model.addAttribute("books", books);
        return "allBooks";
    }

    @RequestMapping(value = "/redirectAddBook", method = RequestMethod.GET)
    public String redirect() {
        return "addBook";
    }

    @RequestMapping(value = "addBook", method = {RequestMethod.POST, RequestMethod.GET})
    public String addBook(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", book);
        repository.add(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/removeBook", method = {RequestMethod.POST, RequestMethod.GET})
    public String removeBook(@ModelAttribute Book book, Model model) {
        repository.remove(book);
        return "redirect:/";
    }

}