package com.tw.bootcamp.bookshop.book;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>  {
    List<Book> findAllByOrderByPriceDesc();
    List<Book> findAllByOrderByPriceAsc();
    List<Book> findByAuthorName(String authorName, Sort by);
}
