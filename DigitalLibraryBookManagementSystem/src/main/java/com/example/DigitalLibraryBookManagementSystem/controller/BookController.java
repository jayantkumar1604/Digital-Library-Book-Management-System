package com.example.DigitalLibraryBookManagementSystem.controller;

import com.example.DigitalLibraryBookManagementSystem.model.Book;
import com.example.DigitalLibraryBookManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;  // ✅ Correct import
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping
    public Page<Book> getAllBooks(Pageable pageable) {
        return service.getAllBooks(pageable);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return service.getBookById(id);
    }

    @GetMapping("/search")
    public Book getBookByTitle(@RequestParam String title) {
        return service.getBookByTitle(title);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return service.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        service.deleteBook(id);
        return "Book deleted successfully.";
    }
}
