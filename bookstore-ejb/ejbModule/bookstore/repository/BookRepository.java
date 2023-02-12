package bookstore.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import bookstore.model.Book;
import bookstore.model.IdDescription;

public class BookRepository {
	
	private static final Logger LOGGER = Logger.getLogger(BookRepository.class);
	
    private EntityManager entityManager;

    private static String FIELD_BOOK_ID          = "BookId";
    private static String FIELD_PRICE_START      = "PriceStart";
    private static String FIELD_PRICE_END        = "PriceEnd";
    private static String FIELD_BOOK_TITLE       = "BookTitle";
    private static String FIELD_BOOK_AUTHOR      = "BookAuthor";
    
    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional
    public Book update(Book book) {
    	LOGGER.info("BookRepository.Update()" );
        try {
            //entityManager.getTransaction().begin();
            entityManager.merge(book);
            //entityManager.getTransaction().commit();
            return book;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Transactional
    public Book create(Book book) {
    	LOGGER.info("BookRepository.Create()" );
        try {
            //entityManager.getTransaction().begin();
            entityManager.persist(book);
            //entityManager.getTransaction().commit();
            return book;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Transactional
    public void delete(Book book) {
    	LOGGER.info("BookRepository.Delete()" );
        try {
            entityManager.remove(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<Book> findAll() {
    	LOGGER.info("BookRepository.FindAll()" );
        return entityManager
        		.createQuery("from Book")
        		.getResultList();
    }
    
    public Book findById(Integer id) {
    	LOGGER.info("BookRepository.FindById() :"+id );
        Book book = entityManager.find(Book.class, id);
        return book != null ? book : null;
    }
    
    public List<Book> findByParams(Map<String, String> params) {
    	LOGGER.info("BookRepository.findByParams() : Params : "+params);
    	
        StringBuilder sb = new StringBuilder("select * from Book where 1=1 ");
        
        if (params!=null && !params.isEmpty()) {

            for (Map.Entry<String, String> entry : params.entrySet()) {
                String strKey = entry.getKey();
                String strValue = entry.getValue();

                if (!(strValue!=null && !"".equalsIgnoreCase(strValue.trim()))) {
                    continue;
                }
                if (FIELD_BOOK_AUTHOR.equalsIgnoreCase(strKey)) {
                    sb.append(" and Author like '%"+strValue+"%' ");
                }
                if (FIELD_BOOK_TITLE.equalsIgnoreCase(strKey)) {
                    sb.append(" and Title like '%"+strValue+"%' ");
                }
                if (FIELD_BOOK_ID.equalsIgnoreCase(strKey)) {
                    sb.append(" and BookId = "+strValue+" ");
                }
                if (FIELD_PRICE_START.equalsIgnoreCase(strKey)) {
                    sb.append(" and Price >= "+strValue+" ");
                }
                if (FIELD_PRICE_END.equalsIgnoreCase(strKey)) {
                    sb.append(" and Price <= "+strValue+" ");
                }
            }
        }

		Query query = entityManager.createNativeQuery(sb.toString(), Book.class);

        return query.getResultList();
    }

    
    public List<IdDescription> getGenres() {
    	LOGGER.info("BookRepository.getGenres()");
    	
        StringBuilder sb = new StringBuilder("select distinct GenreId as GenreId, GenreDesc as GenreDesc from Book order by GenreId");

		Query query = entityManager.createNativeQuery(sb.toString(), IdDescription.class);

        return query.getResultList();
    }
    
    public List<IdDescription> getCategories() {
    	LOGGER.info("BookRepository.getCategories()");
    	
        StringBuilder sb = new StringBuilder("select distinct CategoryId as GenreId, CategoryDesc as GenreDesc from Book order by CategoryId");

		Query query = entityManager.createNativeQuery(sb.toString(), IdDescription.class);

        return query.getResultList();
    }

}