package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Books;
import com.practice.service.BooksService;

@RestController
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@GetMapping("/books/getall")
	
	@PostMapping("/books/createbook")
	public Books createBook(@RequestBody Books book) {
		return booksService.createBook(book);
	}
	
	@DeleteMapping("/books/deletebook/{bid}")
	public Books deleteBook(@PathVariable("bid")Integer bid) {
		return booksService.deleteBook(bid);
	}
	
	@GetMapping("/books/getonebook/{bid}")
	public Books getOneBook(@PathVariable("bid")Integer bid) {
		return booksService.getOneBook(bid);
	}
	
	@PutMapping("/books/updateBook/{bid}")
	public Books updateBook(@PathVariable("bid")Integer bid, @RequestBody()Books books) {
		return booksService.updateBook(bid, books);
	}
	
}
