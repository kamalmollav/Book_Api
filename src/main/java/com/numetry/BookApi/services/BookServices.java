package com.numetry.BookApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.numetry.BookApi.dao.BookDao;
import com.numetry.BookApi.dto.Book;
import com.numetry.BookApi.dto.ResponseStructure;
import com.numetry.BookApi.exception.IdNotFoundException;

@Service
public class BookServices {
	
	@Autowired
	private BookDao dao;
	
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book){
		ResponseStructure<Book> structure=new ResponseStructure<>();
		structure.setMessage("Book Registration Succefully");
		structure.setBody(dao.saveBook(book));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Book>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Book>> updateBook(Book book){
		ResponseStructure<Book> structure=new ResponseStructure<>();
		structure.setMessage("Book updation Succefully");
		structure.setBody(dao.updateBook(book));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Book>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Book>> getBook(int id) {
		ResponseStructure<Book> structure = new ResponseStructure<>();
		Optional<Book> recBook = dao.getBook(id);
		if (recBook.isPresent()) {
			structure.setMessage("Book Found");
			structure.setBody(recBook.get());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBook() {
		ResponseStructure<List<Book>> structure = new ResponseStructure<>();
		structure.setBody(dao.getAllBook());
		structure.setMessage("All Book are display");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteBook(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		Optional<Book> recUser = dao.getBook(id);
		if (recUser.isPresent()) {
			dao.deleteBook(id);
			structure.setMessage("Book Found");
			structure.setBody("Book deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}


}
