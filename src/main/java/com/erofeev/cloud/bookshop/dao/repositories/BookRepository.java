package com.erofeev.cloud.bookshop.dao.repositories;

import com.erofeev.cloud.bookshop.dao.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Long> {

    Book findBookById(Long id);

    List<Book> findBooksByAuthor(String author);
}
