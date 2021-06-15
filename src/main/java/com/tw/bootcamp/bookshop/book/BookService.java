package com.tw.bootcamp.bookshop.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> fetchAll() {
        return bookRepository.findAllByOrderByPriceDesc();
    }

    public List<Book> fetchAll(boolean orderByDesc) {
        if (orderByDesc) {
            return bookRepository.findAllByOrderByPriceDesc();
        } else {
            return bookRepository.findAllByOrderByPriceAsc();
        }
    }

    public List<Book> fetchAll(String orderBy, String orderByColumn, String authorName) {
        return bookRepository.findByAuthorName(authorName, Sort.by(Sort.Direction.fromString(orderBy), orderByColumn));
    }
}
