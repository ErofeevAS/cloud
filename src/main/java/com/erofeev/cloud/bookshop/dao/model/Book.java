package com.erofeev.cloud.bookshop.dao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {
    @Id
    public Long id;

    @Indexed
    public String name;
    @Indexed
    public String author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
