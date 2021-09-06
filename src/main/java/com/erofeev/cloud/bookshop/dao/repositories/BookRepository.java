package com.erofeev.cloud.bookshop.dao.repositories;

import com.erofeev.cloud.bookshop.dao.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {

}
