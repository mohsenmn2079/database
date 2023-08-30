package com.example.databasetest.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

@Entity
@Getter
@Setter
@Table(name = "book")
public class Book {

    private static Log log = LogFactory.getLog(Book.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_name", nullable = false)
    @Basic(fetch = FetchType.LAZY)
    private String name;
}
