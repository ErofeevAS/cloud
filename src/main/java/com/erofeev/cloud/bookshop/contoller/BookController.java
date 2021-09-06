package com.erofeev.cloud.bookshop.contoller;

import com.erofeev.cloud.bookshop.service.BookService;
import com.erofeev.cloud.bookshop.service.dto.BookDto;
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
    public Flux<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Mono<BookDto> getBookButId(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Mono<BookDto> createBook(@RequestBody Mono<BookDto> dto) {
        return bookService.createBook(dto);
    }

    @PatchMapping("/{id}")
    public Mono<BookDto> updateBook(@PathVariable String id, @RequestBody Mono<BookDto> dto) {
        return bookService.updateBook(id, dto);
    }


}
