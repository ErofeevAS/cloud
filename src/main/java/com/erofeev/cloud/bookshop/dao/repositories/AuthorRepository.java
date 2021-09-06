package com.erofeev.cloud.bookshop.dao.repositories;

import com.erofeev.cloud.bookshop.dao.model.Author;
import com.erofeev.cloud.bookshop.dao.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {

}
