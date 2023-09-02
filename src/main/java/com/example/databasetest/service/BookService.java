package com.example.databasetest.service;

import com.example.databasetest.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private EntityManager entityManager;

    public List<String> getAllBooks(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root.get("name"));
        TypedQuery<String> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}

