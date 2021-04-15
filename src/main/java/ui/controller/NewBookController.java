package ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.BookService;
import business.qualifiers.Real;
import persistence.dao.AutorDAO;
import persistence.dao.BookDAO;
import persistence.dao.IBookDao;
import persistence.dao.StoreDAO;
import persistence.model.Autor;
import persistence.model.Book;
import persistence.model.Store;

@ViewScoped
@Named
public class NewBookController implements Serializable {

	private static final long serialVersionUID = -4382653688500109282L;

	private String inputTitle;
	private String inputAutorFName;
	private String inputAutorLName;
	private String inputStore;
	@Inject @Real
	private IBookDao ibookdao;
	
	@Inject
	private StoreDAO storedao;
	
	@Inject
	private AutorDAO autordao;

	@Inject
	private BookService bookservice;

	@PostConstruct
	private void init() {
		this.inputTitle = "Example title";
		this.inputAutorFName = "First Name";
		this.inputAutorLName = "Last name";
		this.inputStore = "alza.sk";
	}
	
	public void addBook() {
		Autor autor = new Autor();
		autor.setFirstName(this.inputAutorFName);
		autor.setLastName(this.inputAutorLName);
		autordao.create(autor);
		
		Store store = new Store();
		store.setWebUrl(this.inputStore);
		storedao.create(store);
		
		Book book = new Book();
		book.setTitle(this.inputTitle);
		book.setAutor(autor);
		book.setStore(store);
		ibookdao.createBook(book);
		
		System.out.println("Adding autor with name: " + this.inputAutorFName + " " + this.inputAutorLName);
		System.out.println("Adding store webpage: " + this.inputStore);
	}

	public String showBooks() {
		return "index.xhtml?faces-redirect=true";
	}
	
	public String getInputTitle() {
		return inputTitle;
	}

	public void setInputTitle(String inputTitle) {
		this.inputTitle = inputTitle;
	}

	public String getInputAutorFName() {
		return inputAutorFName;
	}

	public void setInputAutorFName(String inputAutorFName) {
		this.inputAutorFName = inputAutorFName;
	}

	public String getInputAutorLName() {
		return inputAutorLName;
	}

	public void setInputAutorLName(String inputAutorLName) {
		this.inputAutorLName = inputAutorLName;
	}

	
	public String getInputStore() {
		return inputStore;
	}

	public void setInputStore(String inputStore) {
		this.inputStore = inputStore;
	}
	
	
}
