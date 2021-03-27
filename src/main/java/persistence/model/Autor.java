package persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "autor")
@NamedQuery(name = "Autor_findByName", query = "SELECT a FROM Autor a WHERE a.firstName =:first_name AND a.lastName =:last_name")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1557478708874389190L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@OneToMany(mappedBy = "autor")
	private List<Book> books;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Autor() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
