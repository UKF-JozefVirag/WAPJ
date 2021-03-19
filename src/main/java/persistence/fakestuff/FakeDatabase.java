package persistence.fakestuff;

import java.util.HashMap;

import javax.ejb.Singleton;
import persistence.model.Book;

@Singleton
public class FakeDatabase {
	private Integer lastId;
	
	private HashMap<Integer, Book> bookTable;
	
	private void init() {
		this.lastId = 0;
		this.bookTable = new HashMap<Integer, Book>();
	}
	
	public Book insertBook(Book book) {
		lastId++;
		book.setId(lastId);
		this.bookTable.put(lastId, book);
		return book;
	}
	
	public void remove(Book book) {
		bookTable.remove(book);
	}
	
	public HashMap<Integer, Book> getAllBooks() {
		return bookTable;
	}
	
	public Book getRandom() {
		return bookTable.get((int)Math.random()*bookTable.size());
	}
	
	public Book getBookById(Integer id) {
		return bookTable.get(id);
	}
	
}
