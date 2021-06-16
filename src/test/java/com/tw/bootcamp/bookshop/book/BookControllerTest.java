package com.tw.bootcamp.bookshop.book;

import com.tw.bootcamp.bookshop.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    UserService userService;

//    @Test
//    void shouldListAllBooksWhenPresent() throws Exception {
//        List<Book> books = new ArrayList<>();
//        Book book = new Book("title", "author name", 300);
//        books.add(book);
//        when(bookService.fetchAll()).thenReturn(books);
//
//        mockMvc.perform(get("/books")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(1));
//        verify(bookService, times(1)).fetchAll();
//    }
//
//    @Test
//    void shouldBeEmptyListWhenNoBooksPresent() throws Exception {
//        when(bookService.fetchAll()).thenReturn(new ArrayList<>());
//
//        mockMvc.perform(get("/books")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(0));
//        verify(bookService, times(1)).fetchAll();
//    }
//
//    @Test
//    void shouldListAllBooks() throws Exception {
//        List<Book> books = new ArrayList<>();
////        when(bookService.fetchAllByAuthorName(any())).thenReturn(books);
//
//        MockHttpServletRequestBuilder builder = get("/books")
//                .queryParam("orderByDesc", "true")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        mockMvc.perform(builder)
//                .andExpect(status().isOk());
//        verify(bookService, times(1)).fetchAll(true);
//    }
//
//    @Test
//    void shouldListAllBooksForFalseOrder() throws Exception {
//        List<Book> books = new ArrayList<>();
//        when(bookService.fetchAll(any())).thenReturn(books);
//
//        MockHttpServletRequestBuilder builder = get("/books")
//                .queryParam("orderByDesc", "false")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        mockMvc.perform(builder)
//                .andExpect(status().isOk());
//        verify(bookService, times(1)).fetchAll(false);
//    }

    @Test
    void shouldListAllBooksForAuthorName() throws Exception {
        List<Book> books = new ArrayList<>();
        when(bookService.fetchAll(any(),anyString(),anyString())).thenReturn(books);

        MockHttpServletRequestBuilder builder = get("/books")
                .queryParam("authorName", "Shakespare")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(builder)
                .andExpect(status().isOk());
//        verify(bookService, times(1)).fetchAllByAuthorName("Shakespare");
    }
}