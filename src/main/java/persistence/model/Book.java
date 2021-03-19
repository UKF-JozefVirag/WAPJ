package persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@NamedQuery(name = "Book_findByTitle", query = "SELECT b FROM Book b WHERE b.title =:title")
@NamedQuery(name = "DeleteBook", query = "DELETE b FROM Book b WHERE b.title =:title")
@NamedQuery(name = "GetAllBooks", query = "SELECT * FROM Book")
@NamedQuery(name = "GetRandomBook", query = "SELECT b FROM Book b ORDER BY RAND() LIMIT 1")
@NamedQuery(name = "GetBookById", query = "SELECT b FROM Book WHERE id =:id")
public class Book implements Serializable {

	private static final long serialVersionUID = 5150060402411283137L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "fk_autor")
	private Autor autor;
	
	@ManyToOne()
	@JoinColumn(name = "fk_store")
	private Store store;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
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
	
	

}
