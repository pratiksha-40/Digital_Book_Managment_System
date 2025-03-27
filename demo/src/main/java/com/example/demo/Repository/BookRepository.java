package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.BookModel;

@Repository
public interface BookRepository  extends JpaRepository<BookModel, Long>{


    BookModel  findByBookid(Long bookid);
      
  }
