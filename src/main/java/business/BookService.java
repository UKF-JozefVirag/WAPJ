package business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import business.dto.TOBook;
import business.qualifiers.Real;
import persistence.dao.IBookDao;
import persistence.model.Book;

@Stateless
public class BookService {
	@Inject @Real
    private IBookDao bookDao;

    public TOBook editBook(TOBook tobook) {
        Book book = bookDao.getBookById(tobook.getId());
        if(book == null) {
            //TODO: throw exception, show message
            System.out.println("Editing book failed: not found id = " + tobook.getId());
            return tobook;
        }
        System.out.println("this:" + tobook.getTitle());
        book.setTitle(tobook.getTitle());
        System.out.println("second:" + tobook.toString());
        return tobook;
    }
}
