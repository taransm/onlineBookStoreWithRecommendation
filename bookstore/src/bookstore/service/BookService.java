package bookstore.service;

import java.util.List;
import java.util.Map;

import bookstore.data.Book;
import bookstore.model.IdDescription;

public interface BookService {

	public List<Book> searchBooks(Map<String, String> params);

	public void deleteBook(String bookId);

	public List<IdDescription> getGenre();

	public List<IdDescription> getCategories();
	
	public Book saveBook(Book book);

	public List<Book> searchRecommendedBooks(String bookId);
}
