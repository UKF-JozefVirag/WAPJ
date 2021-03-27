	package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	
	@Override
	public List<Book> getBooksByTitle(String title){
		TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		tq.setParameter("title", title);
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
		em.merge(book);
		return book;
	}

	@Override
	public void deleteBook(Book book) {
		em.remove(book);
	}

	@Override
	public List<Book> getAllBooks() {
		TypedQuery<Book> tq = em.createNamedQuery("GetAllBooks", Book.class);
		return tq.getResultList();
	}

	@Override
	public Book getRandomBook() {
		Query query = (Query)em.createNamedQuery("Book_maxID", Book.class);
		Object obj = query.getSingleResult();
		int rdm = (int) (Math.random()*((Integer)obj));
		TypedQuery<Book> tq = em.createNamedQuery("Book_findById", Book.class);
		tq.setParameter("id", rdm);
		return tq.getSingleResult();
	}

	@Override
	public Book getBookById(Integer id) {
		TypedQuery<Book> tq = em.createNamedQuery("Book_findById", Book.class);
		return (Book) tq;
	}
}
