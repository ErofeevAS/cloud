package com.erofeev.cloud.bookshop.service.impl;

import com.erofeev.cloud.bookshop.dao.repositories.BookRepository;
import com.erofeev.cloud.bookshop.service.BookConverter;
import com.erofeev.cloud.bookshop.service.BookService;
import com.erofeev.cloud.bookshop.service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Mono<BookDto> getBookById(String id) {
        return repository.findById(id).map(BookConverter::toDto);
    }

    @Override
    public Flux<BookDto> getBooks() {
        return repository.findAll().map(BookConverter::toDto);
    }

    @Override
    public Mono<BookDto> createBook(Mono<BookDto> dto) {
        return dto.map(BookConverter::toEntity)
                .flatMap(repository::insert)
                .map(BookConverter::toDto);
    }

    @Override
    public Mono<BookDto> updateBook(String id, Mono<BookDto> dto) {
        return repository.findById(id)
                .flatMap(p -> dto.map(BookConverter::toEntity))
                .doOnNext(e -> e.setId(id))
                .flatMap(repository::save)
                .map(BookConverter::toDto);

    }

}
