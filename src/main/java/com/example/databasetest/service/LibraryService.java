package com.example.databasetest.service;

import com.example.databasetest.entities.Author;
import com.example.databasetest.entities.Book;
import com.example.databasetest.reposetories.AuthorRepository;
import com.example.databasetest.reposetories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public LibraryService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
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

