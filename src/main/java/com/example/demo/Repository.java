package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Repository {

    private ArrayList<Book> library;

    public Repository() {
        this.library = new ArrayList<>();
    }

    public void add(Book book) {
        this.library.add(book);
    }

    public void remove(Book book) {
        System.out.println("Local: " + this.library.get(0) + "\nReceived: " + book);
        this.library.removeIf(item -> item.getTitle().equals(book.getTitle()) && item.getAuthor().equals(book.getAuthor()) && item.getIsbn().equals(book.getIsbn()));
    }

    public ArrayList<Book> getLibrary() {
        return this.library;
    }

}
