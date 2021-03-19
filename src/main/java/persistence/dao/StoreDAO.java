package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistence.model.Store;

@Stateless
public class StoreDAO {
	@PersistenceContext(unitName = "wapjPU")
	private EntityManager em;

	@PostConstruct
	private void init() {
		System.out.println("Created StoreDAO");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("Destroying StoreDAO");
	}
	
	public List<Store> getStoreWithRatingMoreThan(int rating){
		TypedQuery<Store> tq = em.createNamedQuery("Store_ratingMoreThan", Store.class);
		tq.setParameter("rating", "title");
		return tq.getResultList();
	}
	
	public List<Store> getStore_sortAlpAscending(){
		TypedQuery<Store> tq = em.createNamedQuery("Store_sortAlpAscending", Store.class);
		tq.setParameter(0, "title");
		return tq.getResultList();
	}
	
	public Store create(Store s){
		/*
		 * EntityManagerFactory emf = Persistence.createEntityManagerFactory("wapjPU");
		 * EntityManager em = emf.createEntityManager();
		 */
		
		em.persist(s);
		
		return s;
	}

}
