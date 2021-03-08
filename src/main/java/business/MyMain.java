package business;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import persistence.dao.BookDAO;
import persistence.model.Book;
import persistence.model.Store;
import persistence.dao.StoreDAO;

@Singleton
@Startup
public class MyMain {
	
	@Inject
	BookDAO bookDAO = new BookDAO();
	
	@Inject
	StoreDAO storeDAO = new StoreDAO();
	
	@PostConstruct
	private void init() {
		Book b = new Book();
		Store s = new Store();
		System.out.println("INIT");
		b.setTitle("Example title");
		
		bookDAO.getBooksByTitle("Inferno");
		storeDAO.getStoreWithRatingMoreThan(4);
		
		bookDAO.create(b);
		storeDAO.create(s);
		
	}

}
