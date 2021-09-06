package com.erofeev.cloud.bookshop.contoller;

import com.erofeev.cloud.bookshop.facade.BookShopFacade;
import com.erofeev.cloud.bookshop.service.AuthorService;
import com.erofeev.cloud.bookshop.service.dto.AuthorDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final BookShopFacade bookShopFacade;


    public AuthorController(AuthorService authorService, BookShopFacade bookShopFacade) {
        this.authorService = authorService;
        this.bookShopFacade = bookShopFacade;
    }

    @GetMapping("/{id}")
    public Mono<AuthorDto> getById(@PathVariable String id) {
        return authorService.getById(id);
    }

    @PostMapping
    public Mono<AuthorDto> create(@RequestBody Mono<AuthorDto> dto) {
        return authorService.create(dto);
    }

    @PostMapping("/{authorId}/book/{bookId}")
    public Mono<AuthorDto> addBook(@PathVariable String authorId, @PathVariable String bookId) {
        return bookShopFacade.addBookToAuthor(authorId, bookId);
    }
}
