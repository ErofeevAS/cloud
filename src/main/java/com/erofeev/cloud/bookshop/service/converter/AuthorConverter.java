package com.erofeev.cloud.bookshop.service.converter;

import com.erofeev.cloud.bookshop.dao.model.Author;
import com.erofeev.cloud.bookshop.dao.model.Book;
import com.erofeev.cloud.bookshop.service.dto.AuthorDto;
import com.erofeev.cloud.bookshop.service.dto.BookDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static org.apache.commons.collections4.SetUtils.emptyIfNull;

@Component
public class AuthorConverter {

    private final BookConverter bookConverter;

    public AuthorConverter(BookConverter bookConverter) {
        this.bookConverter = bookConverter;
    }


    public AuthorDto toDto(Author entity) {
        AuthorDto dto = new AuthorDto();
        BeanUtils.copyProperties(entity, dto);
        Set<BookDto> bookDtos = bookConverter.toDtos(emptyIfNull(entity.getBooks()));
        dto.setBooks(bookDtos);
        return dto;
    }

    public Author toEntity(AuthorDto dto) {
        Author author = new Author();
        BeanUtils.copyProperties(dto, author);
        Set<Book> books = bookConverter.toEntities(dto.getBooks());
        author.setBooks(books);
        return author;
    }
}
