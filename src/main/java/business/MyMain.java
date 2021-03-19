package business;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import business.qualifiers.Fake;
import business.qualifiers.Real;
import persistence.dao.BookDAO;
import persistence.dao.IBookDao;
import persistence.model.Book;
import persistence.model.Store;
import persistence.dao.StoreDAO;

@Singleton
@Startup
public class MyMain {
	
	@Inject
	@Fake
	private IBookDao ibookDao;
	
	@Inject @Fake
	private String sampleTitle;
	
	@PostConstruct
	private void init() {
		Book b = new Book();	
		b.setTitle(sampleTitle);
		
		ibookDao.createBook(b);
		System.out.println("Created  book with id " + b.getId() + " and title " + b.getTitle());
		
		
	}

}
