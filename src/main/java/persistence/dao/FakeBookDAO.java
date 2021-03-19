package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import business.qualifiers.Fake;
import persistence.fakestuff.FakeDatabase;
import persistence.model.Book;

@Stateless
@Fake
public class FakeBookDAO implements IBookDao{

	@Inject
	private FakeDatabase fakeDatabase;
	
	@PostConstruct
	private void init() {
		System.out.println("this is fake dao");
	}
	
	@Override
	public Book createBook(Book book) {
		return fakeDatabase.insertBook(book);
	}

	@Override
	public Book editBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(Book book) {
		fakeDatabase.remove(book);
		
	}

	@Override
	public List<Book> getAllBooks() {
		return (List<Book>) fakeDatabase.getAllBooks();
	}

	@Override
	public Book getRandomBook() {
		return fakeDatabase.getRandom();
	}

	@Override
	public Book getBookByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(Integer id) {
		return fakeDatabase.getBookById(id);
	}

}
