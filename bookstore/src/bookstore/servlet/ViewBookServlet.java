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
import bookstore.service.BookService;

@WebServlet(
		urlPatterns = {"/viewBook"}
		)
public class ViewBookServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(ViewBookServlet.class);

	private static final long serialVersionUID = 1L;
	private static String RESPONSE_PARAM_USER = "LoggedInUser";
	private static String PARAM_BOOKID = "bookId";
	private static String PARAM_SELECTED_BOOK = "SelectedBook";
	private static String RESPONSE_PARAM_BOOKLIST = "BookList";


	@Inject
	BookService bookService;

	private Boolean isValidRequest(HttpServletRequest request) {

		User user = (User)request.getSession().getAttribute(RESPONSE_PARAM_USER);
		return user!=null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("Inside ViewBookServlet.doGet()");

		if (!isValidRequest(request)) {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
		}
		
		// TODO Fetch the book here
    	String paramBookId = request.getParameter(PARAM_BOOKID);
    	Map<String, String> params = new HashMap<>();
    	params.put(PARAM_BOOKID, paramBookId);
    	LOGGER.debug("Inside ViewBookServlet() : BookId : "+paramBookId);
    	List<Book> books = bookService.searchBooks(params);
    	if (books!=null && !books.isEmpty()) {

    		Book selectedBook = books.get(0);
        	request.setAttribute(PARAM_SELECTED_BOOK, selectedBook);
        	
        	List<Book> recommendedBooks = bookService.searchRecommendedBooks(paramBookId);
        	request.setAttribute(RESPONSE_PARAM_BOOKLIST, recommendedBooks);
        	
			request.getRequestDispatcher("/ViewBook.jsp").forward(request, response);
    		return;
    	} else {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
    	}
	}
}
