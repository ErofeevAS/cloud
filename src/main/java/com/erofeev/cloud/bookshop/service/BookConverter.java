package com.erofeev.cloud.bookshop.service;

import com.erofeev.cloud.bookshop.dao.model.Book;
import com.erofeev.cloud.bookshop.service.dto.BookDto;
import org.springframework.beans.BeanUtils;

public class BookConverter {

    private BookConverter() {
        throw new UnsupportedOperationException();
    }

    public static BookDto toDto(Book book) {
        BookDto dto = new BookDto();
        BeanUtils.copyProperties(book, dto);
        return dto;
    }

    public static Book toEntity(BookDto dto) {
        Book book = new Book();
        BeanUtils.copyProperties(dto, book);
        return book;
    }
}
