package com.example.demo.service;

import java.util.HashSet;
import com.example.demo.modal.Book;

public interface BookService {
	HashSet<Book> findAllBook();
	Book findBookByID(long id);
	void addBook(Book b);
	void deleteAllData();
}
