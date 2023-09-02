package com.example.databasetest.service;

import com.example.databasetest.entities.Book;
import com.example.databasetest.reposetories.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;
    public List<String> getAllBooks(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root.get("name"));
        TypedQuery<String> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    public ResponseEntity<String> addBook(Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("add book is successful");
    }

    public ResponseEntity<String> removeBook(long bookId) {
        bookRepository.deleteById(bookId);
        return ResponseEntity.ok("remove book is successful");
    }
}

