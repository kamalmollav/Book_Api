package com.numetry.BookApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numetry.BookApi.dto.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
