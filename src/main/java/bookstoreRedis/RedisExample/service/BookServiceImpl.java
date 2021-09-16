package bookstoreRedis.RedisExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookstoreRedis.RedisExample.mode.Book;
import bookstoreRedis.RedisExample.repository.BookDao;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
    private BookDao bookDao;

 
	@Override
	public boolean saveBook(Book book) {
		// TODO Auto-generated method stub
		 return bookDao.saveBook(book);
		
	}

	@Override
	public List<Book> fetchAllBook() {
		// TODO Auto-generated method stub
		return bookDao.fetchAllBook();
		
	}

	@Override
	public Book fetchBookById(Long id) {
		// TODO Auto-generated method stub
		return bookDao.fetchBookById(id);
	}

	@Override
	public boolean deleteBook(Long id) {
		// TODO Auto-generated method stub
		return bookDao.deleteBook(id);
		
	}

	@Override
	public boolean updateBook(Long id, Book book) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(id,book);
	}
}

