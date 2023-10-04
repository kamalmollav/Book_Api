package com.numetry.BookApi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.numetry.BookApi.dto.Book;
import com.numetry.BookApi.repository.BookRepository;

@Repository
public class BookDao {

	@Autowired
	private BookRepository repository;

	public Book saveBook(Book book) {
		return repository.save(book);
	}

	public Book updateBook(Book book) {
		return repository.save(book);
	}

	public Optional<Book> getBook(int id) {
		return repository.findById(id);
	}

	public List<Book> getAllBook() {
		return repository.findAll();
	}

	public void deleteBook(int id) {
		repository.deleteById(id);
	}

}
