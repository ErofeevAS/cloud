package com.erofeev.cloud.bookshop.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    public String id;
    public String name;
    public String author;
}

