package persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
@NamedQueries({
	@NamedQuery(name = "Book_findByTitle", query = "SELECT b FROM Book b WHERE b.title =:title"),
	@NamedQuery(name = "GetAllBooks", query = "SELECT b FROM Book b"),
	@NamedQuery(name = "Book_maxID", query = "SELECT MAX(b.id) AS maxId FROM Book b"),
	@NamedQuery(name = "Book_findById", query = "SELECT b FROM Book b WHERE b.id =:id"),
	@NamedQuery(name = "Book_selectNew", query = "SELECT NEW business.dto.TOBook(b) FROM Book b")
})

public class Book implements Serializable {

	private static final long serialVersionUID = 5150060402411283137L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title")
	@NotNull
	@Size(max = 15)
	private String title;
	
	@Transient
	private int age;
	
	@Transient
	private String autorFullName;
	
	

	@ManyToOne
	@JoinColumn(name = "fk_autor")
	private Autor autor;
	
	@ManyToOne()
	@JoinColumn(name = "fk_store")
	private Store store;

	public Book() {
		super();
		this.autorFullName = autor == null ? "-" : autor.getFirstName() + " " + autor.getLastName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public Store getStore() {
		return store;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}

	public String getAutorFullName() {
		if(this.autor == null) return "-";
		return this.autor.getFirstName() + " " + this.autor.getLastName();
	}

	public void setAutorFullName(String autorFullName) {
		this.autorFullName = autorFullName;
	}
	
	
	
}
