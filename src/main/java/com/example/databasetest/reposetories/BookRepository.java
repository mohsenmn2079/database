package com.example.databasetest.reposetories;

import com.example.databasetest.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM book")
    List<Book> getAllBooks();

    @Query(nativeQuery = true, value = "SELECT book.book_name FROM book WHERE id = (:book_id)")
    Book getBooksById(@Param("book_id") long book_id);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO book (book_name) VALUES (:name)")
    void createBook(@Param("name") String name);

    @Modifying
    @Query(value = "UPDATE book SET book_name = :book_name WHERE id = :book_id", nativeQuery = true)
    void updateBook(@Param("book_id") Long book_id, @Param("book_name") String book_name);

    @Modifying
    @Query(value = "DELETE FROM book WHERE id = :book_id", nativeQuery = true)
    void deleteBook(@Param("book_id") Long book_id);
}
