package ui.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import business.BookService;
import business.dto.TOBook;
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
public class BookSinglePageController implements Serializable {
	
	private static final long serialVersionUID = 7491691984849149L;
	private String inputAutorFName;
	private String inputAutorLName;
	private String inputStore;

	
	private List<TOBook> booksList;
	
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
		this.booksList= this.ibookdao.getAllTOBooks();
	}	
	
	public void loadList() {
		this.ibookdao.getAllTOBooks();
	}
	
	
	/*
	 	public void addBook() {
		Autor autor = new Autor();
		autor.setFirstName(this.inputAutorFName);
		autor.setLastName(this.inputAutorLName);
		autordao.create(autor);
		
		Store store = new Store();
		store.setWebUrl(this.inputStore);
		storedao.create(store);
		
		Book book = new Book();
		book.setAutor(autor);
		book.setStore(store);
		ibookdao.createBook(book);
		
		System.out.println("Adding autor with name: " + this.inputAutorFName + " " + this.inputAutorLName);
		System.out.println("Adding store webpage: " + this.inputStore);
	}
	*/
	public void editBook(TOBook tobook) {		
        tobook.setEditingMode(true);
        System.out.println("Edit mode on");
        System.out.println(tobook.getId());
        System.out.println(tobook.getTitle());
    }

    public void saveBook(TOBook tobook) {
    	bookservice.editBook(tobook);
        tobook.setEditingMode(false);
        System.out.println("Edit mode off");
        bookservice.editBook(tobook);
    }
    
    public void delete(TOBook tobook) {
    	try {
    		bookservice.deleteBook(tobook);
    		refresh();
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deleted book", "success"));
    	} catch (Exception e) {
    		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deleted book", e.getMessage()));
    	}
    }
    
    public String newBook() {
    	return "newBook.xhtml?faces-redirect=true";
    }
    
    public String newShop() {
    	return "newShop.xhtml?faces-redirect=true";
    }
    
    public void refresh() throws IOException {
    	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
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

	public List<TOBook> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<TOBook> booksList) {
		this.booksList = booksList;
	}
}
