package persistence.dao;

import java.util.List;

import persistence.model.Book;

public interface IBookDao {

	public Book createBook(Book book);
	
	public Book editBook(Book book);
	
	public void deleteBook(Book book);
	
	public List<Book> getAllBooks();
	
	public Book getRandomBook();
	
	public Book getBookByTitle(String title);
	
	public Book getBookById(Integer id);
	
}
