package com.example.demo.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.BookModel;
import com.example.demo.Services.BookServices;

@RestController
@RequestMapping("/library")
public class BookControler {
    @Autowired
    private BookServices bs;

    @GetMapping
    public List<BookModel> getMethodName() 
    {
        return bs.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookModel getMethodName(@PathVariable Long id) {
        return bs.getBookById(id);
    }

    @PostMapping("/")
    public BookModel postMethodName(@RequestBody BookModel book) {
       
        return bs.addBooks(book);
    }

    @PutMapping("/{id}")
    public String putMethodName(@RequestBody BookModel book) {
        bs.updateBooks(book);
        return "BOOK UPDATED SUCCESSFULLY";
    }

    @DeleteMapping("/{id}")
        public String DeleteMapping(@PathVariable Long id)
        {
            bs.deleteBooks(id);
            return "BOOK DELETED SUCCESSFULLY";
        }
    
    
}
