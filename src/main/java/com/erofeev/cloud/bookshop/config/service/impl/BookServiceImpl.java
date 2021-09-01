package com.erofeev.cloud.bookshop.config.service.impl;

import com.erofeev.cloud.bookshop.config.service.BookService;
import com.erofeev.cloud.bookshop.dao.model.Book;
import com.erofeev.cloud.bookshop.dao.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private  BookRepository repository;



    @Override
    public Mono<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Book> createBook(Book book) {
        return repository.insert(book);
    }

    @Override
    public Flux<Book> getBooks() {
        return repository.findAll();
    }

}
