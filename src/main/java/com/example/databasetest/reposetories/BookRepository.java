package com.example.databasetest.reposetories;

import com.example.databasetest.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Book getBooksById(long id);
}
