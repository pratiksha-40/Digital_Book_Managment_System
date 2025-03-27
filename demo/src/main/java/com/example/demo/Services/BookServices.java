package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.BookModel;
import com.example.demo.Repository.BookRepository;

@Service
public class BookServices {
    @Autowired

    private BookRepository br;

    public List<BookModel> getAllBooks()
    {

      return br.findAll();
        
    }
     
    public BookModel getBookById(Long bookid)
    {

        return br.findByBookid(bookid);

    }


    public BookModel addBooks(BookModel book)
    {

        return br.save(book);

    }

    public String updateBooks(BookModel book)
    {
      
        if (br.existsById(book.getBookid())) 
        {
            br.save(book);
            return "BOOKS UPDATED SUCCESSFULLY";
        }
        else
        {
            return "BOOKS NOT FOUND!";

        }
        

    }
    
    public void deleteBooks(Long id)
    {

        br.deleteById(id);
    }
    
}
