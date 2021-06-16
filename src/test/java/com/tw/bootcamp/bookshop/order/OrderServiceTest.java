package com.tw.bootcamp.bookshop.order;

import com.tw.bootcamp.bookshop.book.Book;
import com.tw.bootcamp.bookshop.book.BookRepository;
import com.tw.bootcamp.bookshop.user.User;
import com.tw.bootcamp.bookshop.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepositry orderRepositry;

    @Test
    public void shouldCreateOrder() {

        Book book = new Book("anyName", "anyAuthor", 100);
        bookRepository.save(book);
        User user = new User("Jhon", "Flash@32");
        userRepository.save(user);

        Order order = new Order(1L, book, user);

        orderService.create(order);

        Order orderFromDb = orderRepositry.findById(1L).get();
        assertEquals(1L, orderFromDb.getId());
    }
}
