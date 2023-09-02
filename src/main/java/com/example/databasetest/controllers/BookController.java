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
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<String> getAllBooks() {
        return bookService.getAllBooks();
    }
//    @GetMapping("/{book_id}")
//    public Book getBookById(@PathVariable long book_id){
//        return bookService.getBookById(book_id);
//    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/remove/{book_id}")
    public ResponseEntity<String>removeBook(@PathVariable long book_id){
        return bookService.removeBook(book_id);
    }

}
