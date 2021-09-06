package com.erofeev.cloud.bookshop.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "books")
public class Book implements Comparable<Book> {
    @Id
    public String id;

    @Indexed
    public String name;
    @Indexed
    public String author;

    @Override
    public int compareTo(Book o) {
        return this.id.compareTo(o.id);
    }
}
