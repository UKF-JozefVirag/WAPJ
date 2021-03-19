	package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import business.qualifiers.Real;
import persistence.model.Book;

@Stateless
@Real
public class BookDAO implements IBookDao{

	@PersistenceContext(unitName = "wapjPU")
	private EntityManager em;

	@PostConstruct
	private void init() {
		System.out.println("Created BookDAO");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("Destroying BookDAO");
	}
	
	public List<Book> getBooksByTitle(String title){
		TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		tq.setParameter("title", "Example title");
		return tq.getResultList();
	}
	
	@Override
	public Book createBook(Book book) {
		/*
		 * EntityManagerFactory emf = Persistence.createEntityManagerFactory("wapjPU");
		 * EntityManager em = emf.createEntityManager();
		 */
		
		em.persist(book);
		
		return book;
	}

	@Override
	public Book editBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(Book book) {
		TypedQuery<Book> tq = em.createNamedQuery("DeleteBook", Book.class);
		
	}

	@Override
	public List<Book> getAllBooks() {
		TypedQuery<Book> tq = em.createNamedQuery("GetAllBooks", Book.class);
		return (List<Book>) tq;
	}

	@Override
	public Book getRandomBook() {
		TypedQuery<Book> tq = em.createNamedQuery("GetRandomBook", Book.class);
		return (Book) tq;
	}

	@Override
	public Book getBookByTitle(String title) {
		return getBookByTitle(title);
	}

	@Override
	public Book getBookById(Integer id) {
		TypedQuery<Book> tq = em.createNamedQuery("GetBookById", Book.class);
		return (Book) tq;
	}
}
