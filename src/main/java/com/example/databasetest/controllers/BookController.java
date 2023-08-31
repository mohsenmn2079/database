package com.example.databasetest.controllers;
import com.example.databasetest.entities.Book;
import com.example.databasetest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllPersons() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getPersonById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        return bookService.createBook(book.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonUsingNativeQuery(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

}

