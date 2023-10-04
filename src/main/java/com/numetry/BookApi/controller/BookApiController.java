package com.numetry.BookApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.BookApi.dto.Book;
import com.numetry.BookApi.dto.ResponseStructure;
import com.numetry.BookApi.services.BookServices;

@RestController
@RequestMapping("/api")
public class BookApiController {

	@Autowired
	private BookServices services;

	@GetMapping("/book/{id}")
	public ResponseEntity<ResponseStructure<Book>> getBook(@PathVariable int id) {
		return services.getBook(id);
	}

	@GetMapping("/book")
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBook() {
		return services.getAllBook();
	}

	@PostMapping("/book")
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book) {
		return services.saveBook(book);
	}

	@PutMapping("/book/{id}")
	public ResponseEntity<ResponseStructure<Book>> updateBook(@PathVariable int id, @RequestBody Book book) {
		return services.updateBook(book);
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteBook(@PathVariable int id) {
		return services.deleteBook(id);
	}

}
