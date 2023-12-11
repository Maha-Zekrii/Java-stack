package com.mahazekri.bookapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahazekri.bookapi.models.Book;
import com.mahazekri.bookapi.services.BookService;

//..

@RestController
public class Bookapi {
 private final BookService bookService;
 public Bookapi(BookService bookService){
     this.bookService = bookService;
 }
 @RequestMapping("/api/books")
 public List<Book> index() {
     return bookService.allBooks();
 }
 
 @RequestMapping(value="/api/books", method=RequestMethod.POST)
 public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
     Book book = new Book(title, desc, lang, numOfPages);
     return bookService.createBook(book);
 }
 
 @RequestMapping("/api/books/{id}")
 public Book show(@PathVariable("id") Long id) {
     Book book = bookService.findBook(id);
     return book;
 }
 

 @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	// first we get the Book ID from our path, we then get the title, description, language, and pages values
 public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		// we create a new Book object with the values we passed in
		Book book = new Book(title, desc, lang, numOfPages);
		// we then set the ID of the new Book object to equal the ID of the Book we are updating
		book.setId(id);
		// now we can use our bookService to update the book
		Book updatedBook = bookService.updateBook(book);
     return updatedBook;
 }
 
	
 @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
 // we only need the Book ID to delete the book in our bookService
 public void destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
 }
}


