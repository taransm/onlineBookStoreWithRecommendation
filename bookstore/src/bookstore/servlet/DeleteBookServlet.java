package bookstore.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import bookstore.data.User;
import bookstore.service.BookService;

@WebServlet(
		urlPatterns = {"/deleteBook"}
		)
public class DeleteBookServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(DeleteBookServlet.class);

	private static final long serialVersionUID = 1L;
	private static String RESPONSE_PARAM_USER = "LoggedInUser";
	private static String PARAM_BOOKID = "bookId";

	@Inject
	BookService bookService;

	private Boolean isValidRequest(HttpServletRequest request) {

		User user = (User)request.getSession().getAttribute(RESPONSE_PARAM_USER);
		return user!=null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("Inside DeleteBookServlet.doGet()");

		if (!isValidRequest(request)) {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
		}
		
    	String paramBookId = request.getParameter(PARAM_BOOKID);
    	LOGGER.debug("Inside ListBooksServlet() : BookId : "+paramBookId);
    	bookService.deleteBook(paramBookId);
    	
		response.sendRedirect(request.getContextPath()+"/searchBook");
	}
}
