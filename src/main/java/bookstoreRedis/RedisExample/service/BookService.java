package bookstoreRedis.RedisExample.service;

import java.util.List;

import bookstoreRedis.RedisExample.mode.Book;

public interface BookService {
	boolean saveBook(Book book);

    List<Book> fetchAllBook();

    Book fetchBookById(Long id);

    boolean deleteBook(Long id);

    boolean updateBook(Long id, Book book);
}
