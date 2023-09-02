package com.example.databasetest.reposetories;

import com.example.databasetest.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AuthorRepository extends JpaRepository<Author ,Long> {
}
