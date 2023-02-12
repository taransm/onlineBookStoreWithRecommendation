package bookstore.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import bookstore.data.Book;
import bookstore.data.User;
import bookstore.model.IdDescription;
import bookstore.service.BookService;

@WebServlet(
		urlPatterns = {"/updateBook"}
		)
public class EditBookServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(EditBookServlet.class);

	private static final long serialVersionUID = 1L;
	private static String RESPONSE_PARAM_USER = "LoggedInUser";
	private static String PARAM_BOOKID = "bookId";
	private static String PARAM_GENRE_LIST = "Genres";
	private static String PARAM_CATEGORY_LIST = "Categories";
	private static String PARAM_SELECTED_BOOK = "SelectedBook";
	private static String PARAM_LAST_ACTION = "lastAction";

	@Inject
	BookService bookService;

	private Boolean isValidRequest(HttpServletRequest request) {

		User user = (User)request.getSession().getAttribute(RESPONSE_PARAM_USER);
		return user!=null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("Inside EditBookServlet.doGet()");

		if (!isValidRequest(request)) {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
		}
		
		// TODO Get genre
    	List<IdDescription> genreList = bookService.getGenre();
    	LOGGER.debug("Inside EditBookServlet() : genreList : "+genreList);
        if (genreList!=null && !genreList.isEmpty()) {
        	request.setAttribute(PARAM_GENRE_LIST, genreList);
        }

		// TODO Get category
    	List<IdDescription> categoryList = bookService.getCategories();
    	LOGGER.debug("Inside EditBookServlet() : categoryList : "+categoryList);
        if (categoryList!=null && !categoryList.isEmpty()) {
        	request.setAttribute(PARAM_CATEGORY_LIST, categoryList);
        }
		
		// TODO Fetch the book here
    	String paramBookId = request.getParameter(PARAM_BOOKID);
    	Map<String, String> params = new HashMap<>();
    	params.put(PARAM_BOOKID, paramBookId);
    	LOGGER.debug("Inside EditBookServlet() : BookId : "+paramBookId);
    	List<Book> books = bookService.searchBooks(params);
    	if (books!=null && !books.isEmpty()) {
    		Book selectedBook = books.get(0);
        	request.setAttribute(PARAM_LAST_ACTION, request.getParameter(PARAM_LAST_ACTION));
        	request.setAttribute(PARAM_SELECTED_BOOK, selectedBook);
			request.getRequestDispatcher("/UpdateBook.jsp").forward(request, response);
    		return;
    	} else {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
    	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("Inside EditBookServlet.doPost()");

		if (!isValidRequest(request)) {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
		}

		// TODO Edit Book Here
		Integer bookId = getInteger(getRequestParam(request, "BookId"));
		String bookTitle = getRequestParam(request, "BookTitle");
		String bookAuthor = getRequestParam(request, "BookAuthor");
		String bookEdition = getRequestParam(request, "BookEdition");
		String synopsis = getRequestParam(request, "Synopsis");
		Double price = getDouble(getRequestParam(request, "BookPrice"));
		Double bookRating = getDouble(getRequestParam(request, "BookRating"));
		Integer bookReview = getInteger(getRequestParam(request, "BookReview"));
		
		String value = getRequestParam(request, "BookGenre");
		Integer genreId = getInteger(value.substring(0, value.indexOf("|")));
		String genreDesc = value.substring(value.indexOf("|")+1);
		value = null;
		
		value = getRequestParam(request, "BookCategory");
		Integer categoryId = getInteger(value.substring(0, value.indexOf("|")));
		String categoryDesc = value.substring(value.indexOf("|")+1);
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setTitle(bookTitle);
		book.setAuthor(bookAuthor);
		book.setEdition(bookEdition);
		book.setRatings(bookRating);
		book.setReviews(bookReview);
		book.setGenreId(genreId);
		book.setGenreDesc(genreDesc);
		book.setSynopsis(synopsis);
		book.setCategoryId(categoryId);
		book.setCategoryDesc(categoryDesc);
		book.setPrice(price);

		bookService.saveBook(book);

		String lastAction = request.getParameter(PARAM_LAST_ACTION);
		if (lastAction==null) {
			response.sendRedirect(request.getContextPath()+"/searchBook");
		} else if ("list".equalsIgnoreCase(lastAction.trim())) {
			response.sendRedirect(request.getContextPath()+"/searchBook");
		} else if ("view".equalsIgnoreCase(lastAction.trim())) {
			response.sendRedirect(request.getContextPath()+"/viewBook?bookId="+bookId);
		} else {
			response.sendRedirect(request.getContextPath()+"/searchBook");
		}
	}
	
	private String getRequestParam(HttpServletRequest request, String param) {
		
		String paramValue = (String)request.getParameter(param);
		if (paramValue!=null) {
			return paramValue;
		}
		return "";
	}
	
	private Integer getInteger(String value) {
		if (value!=null && !"".equals(value.trim())) {
			try {
				return Integer.parseInt(value.trim());
			} catch(Exception ex) {
				LOGGER.debug("Inside EditBookServlet.getInteger() : Exception : "+ex.getMessage());
				return 0;
			}
		}
		return 0;
	}	
	
	private Double getDouble(String value) {
		if (value!=null && !"".equals(value.trim())) {
			try {
				return Double.parseDouble(value.trim());
			} catch(Exception ex) {
				LOGGER.debug("Inside EditBookServlet.getDouble() : Exception : "+ex.getMessage());
				return 0.0;
			}
		}
		return 0.0;
	}	
	
}
