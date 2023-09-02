package com.example.databasetest.controllers;

import com.example.databasetest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
//        return libraryService.getBookById(book_id);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<String>addBook(@RequestBody Book book){
//        return libraryService.addBook(book);
//    }
//
//    @DeleteMapping("/remove/{book_id}")
//    public ResponseEntity<String>removeBook(@PathVariable long book_id){
//        return libraryService.removeBook(book_id);
//    }

}
