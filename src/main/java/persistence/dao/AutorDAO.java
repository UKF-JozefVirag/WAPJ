package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistence.model.Autor;

@Stateless
public class AutorDAO {
	
	@PersistenceContext(unitName = "wapjPU") 
	private EntityManager em;
	
	@PostConstruct 
	private void init() {
		System.out.println("Created AutorDAO");
	}
	
	@PreDestroy 
	private void destroy() {
		System.out.println("Destroying AutorDAO");
	}
	
	public List<Autor> getAutorByName (String firstName, String lastName){
		TypedQuery<Autor> tq = em.createNamedQuery("Autor_findByName", Autor.class);
		tq.setParameter("first_name", firstName);
		tq.setParameter("last_name", lastName);
		return tq.getResultList();
	}
	
	public Autor create(Autor autor) {
		em.persist(autor);
		return autor;
	}
}
