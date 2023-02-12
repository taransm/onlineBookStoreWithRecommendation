package bookstore.servlet;

import java.io.IOException;
import java.util.Enumeration;
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
import bookstore.service.BookService;

@WebServlet(
		urlPatterns = {"/searchBook"}
		)
public class ListBooksServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(ListBooksServlet.class);

	private static final long serialVersionUID = 1L;
	private static String RESPONSE_PARAM_BOOKLIST = "BookList";
	private static String RESPONSE_PARAM_SEARCH = "SearchParam";

	@Inject
	BookService bookService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("Inside ListBooksServlet.doPost()");
    	
    	Map<String, String> params = extractParameters(request);
    	LOGGER.debug("Inside ListBooksServlet() : params : "+params);
    			
    	List<Book> bookList = bookService.searchBooks(params);
    	LOGGER.debug("Inside ListBooksServlet() : bookList : "+bookList);
    	
        if (bookList!=null && !bookList.isEmpty()) {
        	request.setAttribute(RESPONSE_PARAM_SEARCH, params);
        	request.setAttribute(RESPONSE_PARAM_BOOKLIST, bookList);
        }
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}
	
	
    private Map<String, String> extractParameters(HttpServletRequest request) {
        
    	LOGGER.debug("Inside ListBooksServlet.extractParameters()");
        Map<String, String> params = new HashMap<String, String>();
        
        Enumeration<String> enumeration = request.getParameterNames();
        
        while(enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getParameter(key);
            params.put(key, value);
        }
        
        LOGGER.debug("Inside ListBooksServlet.extractParameters() : params : "+params);
        return params;
    }
	
}
