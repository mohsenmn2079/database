package com.example.databasetest.service;

import com.example.databasetest.entities.Book;
import com.example.databasetest.reposetories.BookRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private static Log log = LogFactory.getLog(Book.class);

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(long id){
        return bookRepository.getBooksById(id);
    }

    public ResponseEntity<String> addBook(Book newBook){
        bookRepository.save(newBook);
        return ResponseEntity.ok("adding success");
    }

    public ResponseEntity<String> removeBook(long bookId) {
        bookRepository.deleteById(bookId);
        return ResponseEntity.ok("deleting success");
    }
}

