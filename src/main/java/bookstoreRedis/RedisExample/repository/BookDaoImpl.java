package bookstoreRedis.RedisExample.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import bookstoreRedis.RedisExample.mode.Book;

@Repository
public class BookDaoImpl implements BookDao{
	@Autowired
    private RedisTemplate redisTemplate; 
	
	//private RedisTemplate<String, Book> redisTemplate;

    private static final String KEY = "BOOK";

    
	@Override
	public boolean saveBook(Book book) {
		// TODO Auto-generated method stub
		try {
            redisTemplate.opsForHash().put(KEY, book.getId(),book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
//
//	@Override
//	public List<Book> fetchAllBook() {
//		// TODO Auto-generated method stub
//		List<Object> books;
//        books = redisTemplate.opsForHash().values(KEY);
//        List<Book>book = new ArrayList<Book>();
//        for(Object o: books) {
//        	book.add((Book)o);
//        }
//        return  book;
//	}

	
	@Override
	public List<Book> fetchAllBook() {
		// TODO Auto-generated method stub
		List<Book> books;
        books = redisTemplate.opsForHash().values(KEY);
        return  books;
	}

	@Override
	public Book fetchBookById(Long id) {
		// TODO Auto-generated method stub
		Book book;
	        book = (Book) redisTemplate.opsForHash().get(KEY,id.toString());
	        return book;
	}

	@Override
	public boolean updateBook(Long id, Book book) {
		// TODO Auto-generated method stub
		try {
            redisTemplate.opsForHash().put(KEY, id, book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean deleteBook(Long id) {
		// TODO Auto-generated method stub
		 try {
	            redisTemplate.opsForHash().delete(KEY,id.toString());
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}

}
