package com.erofeev.cloud.bookshop.service.impl;

import com.erofeev.cloud.bookshop.dao.model.Author;
import com.erofeev.cloud.bookshop.dao.repositories.AuthorRepository;
import com.erofeev.cloud.bookshop.service.AuthorService;
import com.erofeev.cloud.bookshop.service.converter.AuthorConverter;
import com.erofeev.cloud.bookshop.service.dto.AuthorDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final AuthorConverter converter;

    public AuthorServiceImpl(AuthorRepository repository, AuthorConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Mono<AuthorDto> create(Mono<AuthorDto> dto) {
        return dto.map(converter::toEntity)
                .flatMap(repository::save)
                .map(converter::toDto);
    }

    @Override
    public Mono<AuthorDto> getById(String id) {
        return repository.findById(id).map(converter::toDto);
    }

    @Override
    public Mono<AuthorDto> update(Mono<AuthorDto> dto) {
        return dto.map(converter::toEntity)
                .flatMap(repository::save)
                .map(converter::toDto);
    }
}
