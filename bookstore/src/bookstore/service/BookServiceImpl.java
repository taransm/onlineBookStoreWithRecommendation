package bookstore.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import org.jboss.logging.Logger;

import bookstore.data.Book;
import bookstore.ejb.BookStatelessBeanRemote;
import bookstore.model.IdDescription;

@SessionScoped
public class BookServiceImpl implements Serializable, BookService {

	private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);

	@EJB
	BookStatelessBeanRemote bookStatelessBeanRemote;
	
	@Override
	public List<Book> searchBooks(Map<String, String> params) {

		LOGGER.debug("Inside BookService.searchBooks() : params : "+params);

		try {
			List<bookstore.model.Book> books = bookStatelessBeanRemote.findByParams(params);
			if (books!=null && !books.isEmpty()) {
				LOGGER.debug("Inside BookService.searchBooks() : Books : "+books.size());
				List<bookstore.data.Book> dataBooks = new ArrayList<>();
				for (bookstore.model.Book book : books) {
					bookstore.data.Book dataBook = new bookstore.data.Book();
					dataBook.setBookId(book.getBookId());
					dataBook.setTitle(book.getTitle());
					dataBook.setAuthor(book.getAuthor());
					dataBook.setEdition(book.getEdition());
					dataBook.setGenreId(book.getGenreId());
					dataBook.setGenreDesc(book.getGenreDesc());
					dataBook.setCategoryId(book.getCategoryId());
					dataBook.setCategoryDesc(book.getCategoryDesc());
					dataBook.setPrice(book.getPrice());
					dataBook.setRatings(book.getRatings());
					dataBook.setReviews(book.getReviews());
					dataBook.setSynopsis(book.getSynopsis());
					dataBooks.add(dataBook);
				}
				
				return dataBooks;
			} else {
				LOGGER.debug("Inside BookService.searchBooks() : No Books Found");
			}
		} catch (Exception ex) {
			LOGGER.error("Inside BookService.searchBooks() : Exception:"+ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteBook(String bookId) {

		LOGGER.debug("Inside BookService.deleteBook() : bookId : "+bookId);

		try {
			bookstore.model.Book book = new bookstore.model.Book();
			book.setBookId(Integer.parseInt(bookId));
			bookStatelessBeanRemote.deleteBook(book);
		} catch (Exception ex) {
			LOGGER.error("Inside BookService.searchBooks() : Exception:"+ex.getMessage());
			ex.printStackTrace();
		}
	}

	@Override
	public List<IdDescription> getGenre() {

		LOGGER.debug("Inside BookService.getGenre()");

		try {
			List<bookstore.model.IdDescription> books = bookStatelessBeanRemote.getGenres();
			if (books!=null && !books.isEmpty()) {
				LOGGER.debug("Inside BookService.getGenre() : Books : "+books.size());
				
				return books;
			} else {
				LOGGER.debug("Inside BookService.getGenre() : No Books Found");
			}
		} catch (Exception ex) {
			LOGGER.error("Inside BookService.getGenre() : Exception:"+ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<IdDescription> getCategories() {

		LOGGER.debug("Inside BookService.getCategories()");

		try {
			List<bookstore.model.IdDescription> books = bookStatelessBeanRemote.getCategories();
			if (books!=null && !books.isEmpty()) {
				LOGGER.debug("Inside BookService.getCategories() : Books : "+books.size());
				
				return books;
			} else {
				LOGGER.debug("Inside BookService.getCategories() : No Books Found");
			}
		} catch (Exception ex) {
			LOGGER.error("Inside BookService.getCategories() : Exception:"+ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Book saveBook(Book dataBook) {

		LOGGER.debug("Inside BookService.saveBook() : Book : "+dataBook);

		try {
			
			bookstore.model.Book book = new bookstore.model.Book();
			book.setBookId(dataBook.getBookId());
			book.setTitle(dataBook.getTitle());
			book.setAuthor(dataBook.getAuthor());
			book.setEdition(dataBook.getEdition());
			book.setRatings(dataBook.getRatings());
			book.setReviews(dataBook.getReviews());
			book.setGenreId(dataBook.getGenreId());
			book.setGenreDesc(dataBook.getGenreDesc());
			book.setSynopsis(dataBook.getSynopsis());
			book.setCategoryId(dataBook.getCategoryId());
			book.setCategoryDesc(dataBook.getCategoryDesc());
			book.setPrice(dataBook.getPrice());
			
			if (book.getBookId() == null) {
				book = bookStatelessBeanRemote.createBook(book);
				LOGGER.debug("Inside BookService.saveBook() : Book created");
			} else {
				book = bookStatelessBeanRemote.updateBook(book);
				LOGGER.debug("Inside BookService.saveBook() : Book updated");
			}
			
			if (book!=null) {
				dataBook.setBookId(book.getBookId());
				LOGGER.debug("Inside BookService.saveBook() : Book Saved");
				return dataBook;
			} else {
				LOGGER.debug("Inside BookService.saveBook() : Unable to save the book");
			}
		} catch (Exception ex) {
			LOGGER.error("Inside BookService.saveBook() : Exception:"+ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> searchRecommendedBooks(String bookId) {

		LOGGER.debug("Inside BookService.searchRecommendedBooks() : bookId : "+bookId);

		try {
			List<bookstore.model.Book> books = bookStatelessBeanRemote.findRecommended(Integer.parseInt(bookId));
			if (books!=null && !books.isEmpty()) {
				LOGGER.debug("Inside BookService.searchRecommendedBooks() : Books : "+books.size());
				List<bookstore.data.Book> dataBooks = new ArrayList<>();
				for (bookstore.model.Book book : books) {
					bookstore.data.Book dataBook = new bookstore.data.Book();
					dataBook.setBookId(book.getBookId());
					dataBook.setTitle(book.getTitle());
					dataBook.setAuthor(book.getAuthor());
					dataBook.setEdition(book.getEdition());
					dataBook.setGenreId(book.getGenreId());
					dataBook.setGenreDesc(book.getGenreDesc());
					dataBook.setCategoryId(book.getCategoryId());
					dataBook.setCategoryDesc(book.getCategoryDesc());
					dataBook.setPrice(book.getPrice());
					dataBook.setRatings(book.getRatings());
					dataBook.setReviews(book.getReviews());
					dataBook.setSynopsis(book.getSynopsis());
					dataBooks.add(dataBook);
				}
				
				return dataBooks;
			} else {
				LOGGER.debug("Inside BookService.searchRecommendedBooks() : No Books Found");
			}
		} catch (Exception ex) {
			LOGGER.error("Inside BookService.searchRecommendedBooks() : Exception:"+ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	
}
