package bookstore.ejb;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import bookstore.model.Book;
import bookstore.model.IdDescription;

@Local
public interface BookStatelessBeanLocal {

	Book createBook(Book book);

	Book updateBook(Book book);
	
	void deleteBook(Book book);

	Book findById(int bookId);

	List<Book> findByParams(Map<String, String> params);
	
	List<Book> findAll();

	List<IdDescription> getGenres();

	List<IdDescription> getCategories();

	List<Book> findRecommended(int bookId);
}
