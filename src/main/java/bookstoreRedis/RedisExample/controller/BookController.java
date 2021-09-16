package bookstoreRedis.RedisExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bookstoreRedis.RedisExample.mode.Book;
import bookstoreRedis.RedisExample.service.BookService;

@Controller
public class BookController {

	
	@Autowired
    private BookService bookService;
	
	 @PostMapping("/book")
	    public ResponseEntity<String> saveBook(@RequestBody Book book) {
	        boolean result = bookService.saveBook(book);
	        if(result)
	            return ResponseEntity.ok("Book Created Successfully!!");
	        else
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }

	    @GetMapping("/book")
	    public ResponseEntity<List<Book>> fetchAllBook() {
	        List<Book> users;
	        users = bookService.fetchAllBook();
	        return ResponseEntity.ok(users);
	    }

	    @GetMapping("/book/{id}")
	    public ResponseEntity<Book> fetchBookById(@PathVariable("id") Long id) {
	        Book book;
	        book = bookService.fetchBookById(id);
	        return ResponseEntity.ok(book);
	    }

	    @DeleteMapping("/book/{id}")
	    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
	        boolean result = bookService.deleteBook(id);
	        if(result)
	            return ResponseEntity.ok("Book deleted Successfully!!");
	        else
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }

	    @PutMapping("/book/{id}")
	    public ResponseEntity<String> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
	        boolean result = bookService.updateBook(id,book);
	        if(result)
	            return ResponseEntity.ok("Book Updated Successfully!!");
	        else
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }
}
