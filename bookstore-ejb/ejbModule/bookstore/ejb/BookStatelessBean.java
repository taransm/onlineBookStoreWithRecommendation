package bookstore.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import bookstore.model.Book;
import bookstore.model.Cluster;
import bookstore.model.IdDescription;
import bookstore.repository.BookRepository;

/**
 * Session Bean implementation class BookStatelessBean
 */
@Stateless
public class BookStatelessBean implements BookStatelessBeanRemote, BookStatelessBeanLocal {

	private static final Logger LOGGER = Logger.getLogger(BookStatelessBean.class);

	@PersistenceContext(unitName="bookstore")
	private EntityManager entityManager;

	private BookRepository bookRepository;

	@EJB
	RecommendationSingletonLocal recommendationSingletonLocal;
	
	@EJB
	ClusterStatelessBeanLocal clusterStatelessBeanLocal;

    /**
     * Default constructor. 
     */
    public BookStatelessBean() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public Book createBook(Book book) {

		bookRepository = new BookRepository(entityManager);
		LOGGER.debug("Book: " + book);
		Book savedBook = bookRepository.create(book);
		if (savedBook != null) {
			LOGGER.debug("Book creation successful" );
			
			recommendationSingletonLocal.calculateRecommendataion();
			return savedBook;
		} else {
			LOGGER.debug("Book creation failed" );
			return null;
		}
		
	}


	@Override
	public Book updateBook(Book book) {
		bookRepository = new BookRepository(entityManager);
		LOGGER.debug("Book: " + book);
		Book savedBook = bookRepository.update(book);
		if (savedBook != null) {
			LOGGER.debug("Book modification successful" );
			
			recommendationSingletonLocal.calculateRecommendataion();
			return savedBook;
		} else {
			LOGGER.debug("Book modification failed" );
			return null;
		}
	}


	@Override
	public void deleteBook(Book book) {
		bookRepository = new BookRepository(entityManager);
		LOGGER.debug("Book: " + book);
		Book bookToDelete = bookRepository.findById(book.getBookId());
		bookRepository.delete(bookToDelete);
		LOGGER.debug("Book deleted" );
		
		clusterStatelessBeanLocal.deleteByBookId(book.getBookId());
	}


	@Override
	public Book findById(int bookId) {
		bookRepository = new BookRepository(entityManager);
		LOGGER.debug("Book Id: " + bookId);
		Book fetchedBook = bookRepository.findById(bookId);
		if (fetchedBook != null) {
			LOGGER.debug("Book retrieval successful" );
			return fetchedBook;
		} else {
			LOGGER.debug("Book retrieval failed" );
			return null;
		}
	}

	@Override
	public List<Book> findByParams(Map<String, String> params) {
		
		LOGGER.debug("Retrieving Book" );
		bookRepository = new BookRepository(entityManager);

		List<Book> bookList = bookRepository.findByParams(params);
		if (bookList != null && !bookList.isEmpty()) {
			LOGGER.debug("Books retrieved : "+bookList.size());
			return bookList;
		} else {
			LOGGER.debug("Book retrieval failed" );
			return null;
		}
	}

	@Override
	public List<Book> findAll() {
		
		LOGGER.debug("Retrieving Book" );
		bookRepository = new BookRepository(entityManager);

		List<Book> bookList = bookRepository.findAll();
		if (bookList != null && !bookList.isEmpty()) {
			LOGGER.debug("Books retrieved : "+bookList.size());
			return bookList;
		} else {
			LOGGER.debug("Book retrieval failed" );
			return null;
		}
	}

	@Override
	public List<IdDescription> getGenres() {
		
		LOGGER.debug("Retrieving Genre" );
		bookRepository = new BookRepository(entityManager);

		List<IdDescription> bookList = bookRepository.getGenres();
		if (bookList != null && !bookList.isEmpty()) {
			LOGGER.debug("Genre retrieved : "+bookList.size());
			return bookList;
		} else {
			LOGGER.debug("Genre retrieval failed" );
			return null;
		}
	}

	@Override
	public List<IdDescription> getCategories() {
		
		LOGGER.debug("Retrieving Categories" );
		bookRepository = new BookRepository(entityManager);

		List<IdDescription> bookList = bookRepository.getCategories();
		if (bookList != null && !bookList.isEmpty()) {
			LOGGER.debug("Categories retrieved : "+bookList.size());
			return bookList;
		} else {
			LOGGER.debug("Category retrieval failed" );
			return null;
		}
	}
	
	@Override
	public List<Book> findRecommended(int bookId) {
		
		LOGGER.debug("Retrieving Recommended Books" );
		List<Cluster> centroidsList = clusterStatelessBeanLocal.findAllByBookId(bookId);
		if (centroidsList != null && !centroidsList.isEmpty()) {
			LOGGER.debug("Centrolds retrieved : "+centroidsList.size());
			bookRepository = new BookRepository(entityManager);
			List<Book> bookList = new ArrayList<>();
			for (Cluster centroid : centroidsList) {
				
				Book book = bookRepository.findById(centroid.getBookId());
				if (book!=null) {
					bookList.add(book);
				}
			}
			return bookList;
		} else {
			LOGGER.debug("No Recommended Books" );
			return null;
		}
	}

}
