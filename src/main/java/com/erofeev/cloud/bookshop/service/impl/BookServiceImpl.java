package com.erofeev.cloud.bookshop.service.impl;

import com.erofeev.cloud.bookshop.dao.repositories.BookRepository;
import com.erofeev.cloud.bookshop.service.BookService;
import com.erofeev.cloud.bookshop.service.converter.BookConverter;
import com.erofeev.cloud.bookshop.service.dto.BookDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    private final BookConverter converter;

    public BookServiceImpl(BookRepository repository, BookConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Mono<BookDto> getBookById(String id) {
        return repository.findById(id).map(converter::toDto);
    }

    @Override
    public Flux<BookDto> getBooks() {
        return repository.findAll().map(converter::toDto);
    }

    @Override
    public Mono<BookDto> createBook(Mono<BookDto> dto) {
        return dto.map(converter::toEntity)
                .flatMap(repository::insert)
                .map(converter::toDto);
    }

    @Override
    public Mono<BookDto> updateBook(String id, Mono<BookDto> dto) {
        return repository.findById(id)
                .flatMap(p -> dto.map(converter::toEntity))
                .doOnNext(e -> e.setId(id))
                .flatMap(repository::save)
                .map(converter::toDto);

    }

}
