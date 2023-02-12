package bookstore.servlet;

import java.io.IOException;
import java.util.List;

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
		urlPatterns = {"/newBook"}
		)
public class AddBookServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(AddBookServlet.class);

	private static final long serialVersionUID = 1L;
	private static String RESPONSE_PARAM_USER = "LoggedInUser";
	private static String PARAM_GENRE_LIST = "Genres";
	private static String PARAM_CATEGORY_LIST = "Categories";

	@Inject
	BookService bookService;

	private Boolean isValidRequest(HttpServletRequest request) {

		User user = (User)request.getSession().getAttribute(RESPONSE_PARAM_USER);
		return user!=null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("Inside AddBookServlet.doGet()");

		if (!isValidRequest(request)) {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
		}
		
		// TODO Get genre
    	List<IdDescription> genreList = bookService.getGenre();
    	LOGGER.debug("Inside AddBookServlet() : genreList : "+genreList);
        if (genreList!=null && !genreList.isEmpty()) {
        	request.setAttribute(PARAM_GENRE_LIST, genreList);
        }

		// TODO Get category
    	List<IdDescription> categoryList = bookService.getCategories();
    	LOGGER.debug("Inside AddBookServlet() : categoryList : "+categoryList);
        if (categoryList!=null && !categoryList.isEmpty()) {
        	request.setAttribute(PARAM_CATEGORY_LIST, categoryList);
        }
		
        request.getRequestDispatcher("/NewBook.jsp").forward(request, response);
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
				LOGGER.debug("Inside AddBookServlet.getInteger() : Exception : "+ex.getMessage());
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
				LOGGER.debug("Inside AddBookServlet.getDouble() : Exception : "+ex.getMessage());
				return 0.0;
			}
		}
		return 0.0;
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("Inside AddBookServlet.doPost()");

		if (!isValidRequest(request)) {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
		}

		// TODO Create Book Here
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
		book.setBookId(null);
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

		response.sendRedirect(request.getContextPath()+"/searchBook");
	}
}
