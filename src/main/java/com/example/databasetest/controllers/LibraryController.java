package com.example.databasetest.controllers;

import com.example.databasetest.entities.Author;
import com.example.databasetest.entities.Book;
import com.example.databasetest.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LibraryController {
    private final LibraryService libraryService;
    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }
    @GetMapping("/author")
    public List<Author> getAllAuthors() {
        return libraryService.getAllAuthors();
    }
    @GetMapping("/{book_id}")
    public Book getBookById(@PathVariable long book_id){
        return libraryService.getBookById(book_id);
    }

    @PostMapping("/add")
    public ResponseEntity<String>addBook(@RequestBody Book book){
        return libraryService.addBook(book);
    }

    @DeleteMapping("/remove/{book_id}")
    public ResponseEntity<String>removeBook(@PathVariable long book_id){
        return libraryService.removeBook(book_id);
    }

}
