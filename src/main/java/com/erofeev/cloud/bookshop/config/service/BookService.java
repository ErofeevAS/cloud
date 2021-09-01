package com.erofeev.cloud.bookshop.config.service;

import com.erofeev.cloud.bookshop.dao.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Mono<Book> getBookById(Long id);

    Mono<Book> createBook(Book book);

    Flux<Book> getBooks();
}
