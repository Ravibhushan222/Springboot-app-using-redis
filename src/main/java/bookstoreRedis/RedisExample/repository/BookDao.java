package bookstoreRedis.RedisExample.repository;

import java.util.List;

import bookstoreRedis.RedisExample.mode.Book;

public interface BookDao {

	boolean saveBook(Book book);

	List<Book> fetchAllBook();

	Book fetchBookById(Long id);

	boolean updateBook(Long id, Book book);

	boolean deleteBook(Long id);

}
