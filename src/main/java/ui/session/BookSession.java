package ui.session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class BookSession implements Serializable{

	private String favoriteBook;

	@PostConstruct
	private void init() {
		System.out.println("Created booksession");
	}
	
	public String getFavoriteBook() {
		return favoriteBook;
	}

	public void setFavoriteBook(String favoriteBook) {
		this.favoriteBook = favoriteBook;
	}
	
}
