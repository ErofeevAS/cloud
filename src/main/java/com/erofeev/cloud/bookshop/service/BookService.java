package com.erofeev.cloud.bookshop.service;

import com.erofeev.cloud.bookshop.dao.model.Book;
import com.erofeev.cloud.bookshop.service.dto.BookDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Mono<BookDto> getBookById(String id);

    Mono<BookDto> createBook(Mono<BookDto> dto);

    Flux<BookDto> getBooks();

    Mono<BookDto> updateBook(String id, Mono<BookDto> dto);
}
