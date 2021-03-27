package persistence.fakestuff;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import persistence.model.Book;

@Singleton
public class FakeDatabase {
	private Integer lastId = -1;
	
	private HashMap<Integer, Book> bookTable = new HashMap<Integer, Book>();
	
	@PostConstruct
	private void init() {
		this.lastId = 0;
	}
	
	public Book insertBook(Book book) {
		lastId++;
		book.setId(lastId);
		this.bookTable.put(lastId, book);
		return book;
	}
	
	public void remove(Book book) {
		bookTable.remove(book.getId(), book);
	}
	
	public Book editBook(Book book) {
		this.bookTable.put(book.getId(), book);
		return book;
	}
	
	public HashMap<Integer, Book> getAllBooks() {
		return bookTable;
	}
	
	public Book getRandom() {
		int size = bookTable.size();
		int rand = (int) (Math.random() * size);
		return this.bookTable.get(rand);
	}
	
	public Book getBookById(Integer id) {
		return this.bookTable.get(id);
	}
	
}
