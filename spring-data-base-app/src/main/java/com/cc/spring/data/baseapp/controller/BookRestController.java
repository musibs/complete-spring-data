package com.cc.spring.data.baseapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cc.spring.data.baseapp.model.Book;
import com.cc.spring.data.baseapp.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookRestController {
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/{bookId}")
	public Book getBookById(@PathVariable("bookId") int bookId) {
		Optional<Book> book = bookRepository.findById(bookId);
		if(book.isPresent()) {
			return book.get();
		}
		else {
			throw new IllegalArgumentException("No such book exists with id "+bookId);
		}
	}
	
	@GetMapping
	public Iterable<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("{pageNo}/{pageSize}")
	public List<Book> getBooksByPage(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
		Page<Book> book = bookRepository.findAll(PageRequest.of(pageNo, pageSize));
		return book.toList();
	}
	
	@DeleteMapping("/{bookId}")
	public void deleteBookById(@PathVariable("bookId") int bookId) {
		bookRepository.deleteById(bookId);
	}
	
	@DeleteMapping
	public void deleteAllBooks() {
		bookRepository.deleteAll();
	}
	
	@PostMapping
	public void saveBook(Book book) {
		bookRepository.save(book);
	}
	
	
	
	
}
