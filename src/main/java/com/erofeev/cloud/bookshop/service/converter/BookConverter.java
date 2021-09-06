package com.erofeev.cloud.bookshop.service.converter;

import com.erofeev.cloud.bookshop.dao.model.Book;
import com.erofeev.cloud.bookshop.service.dto.BookDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookConverter {


    public BookDto toDto(Book book) {
        BookDto dto = new BookDto();
        BeanUtils.copyProperties(book, dto);
        return dto;
    }

    public Book toEntity(BookDto dto) {
        Book book = new Book();
        BeanUtils.copyProperties(dto, book);
        return book;
    }

    public Set<BookDto> toDtos(Set<Book> books) {
        return books.stream().map(this::toDto).collect(Collectors.toSet());
    }

    public Set<Book> toEntities(Set<BookDto> books) {
        return books.stream().map(this::toEntity).collect(Collectors.toSet());
    }
}
