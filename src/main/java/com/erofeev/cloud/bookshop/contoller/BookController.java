package com.erofeev.cloud.bookshop.contoller;

import com.erofeev.cloud.bookshop.config.service.BookService;
import com.erofeev.cloud.bookshop.dao.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Flux<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Mono<Book> getBookButId(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

}
