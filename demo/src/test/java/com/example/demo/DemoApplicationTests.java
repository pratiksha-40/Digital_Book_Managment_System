package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.demo.Model.BookModel;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Services.BookServices;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
    private BookServices bookService;

   
    private BookRepository bookRepository;

    private BookModel book1;
    private BookModel book2;

    @BeforeEach
    void setUp() {
        // Initialize book objects
        book1 = new BookModel();
        book1.setBookid(1L);
        book1.setTitle("Java Basics");

        book2 = new BookModel();
        book2.setBookid(2L);
        book2.setTitle("Spring Boot Guide");

        // Mock repository methods
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));
        when(bookRepository.findByBookid(1L)).thenReturn(book1);
        when(bookRepository.findByBookid(99L)).thenReturn(null);
        when(bookRepository.save(any(BookModel.class))).thenReturn(book1);
        when(bookRepository.existsById(1L)).thenReturn(true);
        when(bookRepository.existsById(99L)).thenReturn(false);
    }

    @Test
    void testGetAllBooks() {
        List<BookModel> books = bookService.getAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    void testGetBookById_ValidId() {
        BookModel foundBook = bookService.getBookById(1L);
        assertNotNull(foundBook);
        assertEquals("Java Basics", foundBook.getTitle());
    }

    @Test
    void testGetBookById_InvalidId() {
        BookModel foundBook = bookService.getBookById(99L);
        assertNull(foundBook);
    }

    @Test
    void testAddBook() {
        BookModel newBook = new BookModel();
        newBook.setBookid(3L);
        newBook.setTitle("Microservices Architecture");

        when(bookRepository.save(any(BookModel.class))).thenReturn(newBook);

        BookModel savedBook = bookService.addBooks(newBook);
        assertNotNull(savedBook);
        assertEquals("Microservices Architecture", savedBook.getTitle());
    }

    @Test
    void testUpdateBook_ValidId() {
        book1.setTitle("Updated Java Basics");
        String result = bookService.updateBooks(book1);
        assertEquals("BOOKS UPDATED SUCCESSFULLY", result);
    }

    @Test
    void testUpdateBook_InvalidId() {
        BookModel book = new BookModel();
        book.setBookid(99L);
        book.setTitle("Unknown Book");

        String result = bookService.updateBooks(book);
        assertEquals("BOOKS NOT FOUND!", result);
    }

    @Test
    void testDeleteBook() {
        doNothing().when(bookRepository).deleteById(1L);
        assertDoesNotThrow(() -> bookService.deleteBooks(1L));
        verify(bookRepository, times(1)).deleteById(1L);
    }

}
