package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "books")
public class BookModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long bookid;

@Column(nullable = false, unique =  true)
private String title;

@Column(nullable = false)
private String author;

@Column(nullable =  false)
private String genre;

@Column(nullable =  false)
private String status;

   
public BookModel() {
} 

    
}
