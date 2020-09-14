package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Books;
import com.practice.repository.BooksRepo;

@Service
public class BooksService {
	
	@Autowired
	private BooksRepo booksRepo;

	public Books createBook(Books book) {
		return booksRepo.save(book);
	}

	public Books deleteBook(Integer bid) {
		Books books=booksRepo.findById(bid).orElse(null);
		booksRepo.delete(books);
		return books;
	}

	public Books getOneBook(Integer bid) {
		return booksRepo.findById(bid).orElse(null);
	}

	public Books updateBook(Integer bid, Books books) {
		Books book1=booksRepo.getOne(bid);
		book1.setBname(books.getBname());
		return booksRepo.save(book1);
	}

}
