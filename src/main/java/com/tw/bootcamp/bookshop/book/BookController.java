package com.tw.bootcamp.bookshop.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    List<Book> list(@RequestParam(required = false, defaultValue = "ASC") String orderBy,@RequestParam(required = false, defaultValue = "price") String orderByColumn, @RequestParam(required = false, defaultValue = "") String authorName) {
        return bookService.fetchAll(orderBy, orderByColumn,authorName);
    }
}
