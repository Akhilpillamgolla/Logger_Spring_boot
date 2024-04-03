package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;

import javax.management.loading.PrivateClassLoader;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Book;

import com.example.demo.service.BookServiceImpl;

import ch.qos.logback.classic.Logger;

@RestController
public class BookController {

	@Autowired
	BookServiceImpl bookServiceImpl;
	
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(BookController.class); 

	@PostMapping("/")
	public void addBook(@RequestBody Book book) {
		bookServiceImpl.addBook(book);
	}

	@GetMapping("/findall")
	public HashSet<Book> getAllBook() {
		LOGGER.info("Finding all Books ");		
		return bookServiceImpl.findAllBook();
	}

	@GetMapping("/findbyid/{id}")
	public Book geBookById(@PathVariable long id) {
		LOGGER.info("Finding book By ID");		
		return bookServiceImpl.findBookByID(id);
	}

	@DeleteMapping("/delete")
	public void deleteBook() {
		LOGGER.info(" Deletion of Book");		
		bookServiceImpl.deleteAllData();
	}

}
