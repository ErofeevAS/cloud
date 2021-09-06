package com.erofeev.cloud.bookshop.facade;

import com.erofeev.cloud.bookshop.service.AuthorService;
import com.erofeev.cloud.bookshop.service.BookService;
import com.erofeev.cloud.bookshop.service.converter.AuthorConverter;
import com.erofeev.cloud.bookshop.service.dto.AuthorDto;
import com.erofeev.cloud.bookshop.service.dto.BookDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

@Component
public class BookShopFacade {

    private final BookService bookService;
    private final AuthorService authorService;
    private final AuthorConverter converter;

    public BookShopFacade(BookService bookService, AuthorService authorService, AuthorConverter converter) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.converter = converter;
    }


    public Mono<AuthorDto> addBookToAuthor(String authorId, String bookId) {
        Mono<AuthorDto> author = authorService.getById(authorId);
        Mono<BookDto> book = bookService.getBookById(bookId);


        return Mono
                .zip(author, book, (a, b) -> {
                    Set<BookDto> books = a.getBooks();
                    books.add(b);
                    return Mono.just(a);
                })
                .flatMap(authorService::update);
    }
}
