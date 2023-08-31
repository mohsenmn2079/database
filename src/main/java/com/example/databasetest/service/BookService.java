package com.example.databasetest.service;

import com.example.databasetest.entities.Book;
import com.example.databasetest.reposetories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.getAllBooks());
    }

    public ResponseEntity<Book> getBookById(long id) {
        return ResponseEntity.ok(bookRepository.getBooksById(id));
    }

    public ResponseEntity<String> createBook(String newBook) {
        bookRepository.createBook(newBook);
        return ResponseEntity.ok("adding success");
    }

    public ResponseEntity<String> updateBook(Long id,Book book) {
        bookRepository.updateBook(id,book.getName());
        return ResponseEntity.ok("updating success");
    }

    public ResponseEntity<String> deleteBook(Long id) {
        bookRepository.deleteBook(id);
        return ResponseEntity.ok("updating success");

    }
}

