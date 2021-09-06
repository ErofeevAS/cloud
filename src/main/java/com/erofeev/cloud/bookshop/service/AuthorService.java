package com.erofeev.cloud.bookshop.service;

import com.erofeev.cloud.bookshop.service.dto.AuthorDto;
import reactor.core.publisher.Mono;

public interface AuthorService {

    Mono<AuthorDto> create(Mono<AuthorDto> dto);

    Mono<AuthorDto> getById(String id);

    Mono<AuthorDto> update(Mono<AuthorDto> dto);

}
