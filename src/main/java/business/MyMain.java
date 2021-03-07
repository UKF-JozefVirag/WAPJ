package business;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import persistence.model.Book;

@Singleton
@Startup
public class MyMain {
	
	@PostConstruct
	private void init() {
		Book b = new Book();
		System.out.println("INIT");
		b.setTitle("Example title");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wapjPU");
		EntityManager em = emf.createEntityManager();
		em.persist(b);
		
		TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		tq.setParameter("title", "Example title");
		//tq.setParameter("title", "Example");
		//tq.getResultList();
		try {
			tq.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No result excepltion");
		} catch (NonUniqueResultException e) {
			System.out.println("NonUniqueResultException");
		}
	}

}
