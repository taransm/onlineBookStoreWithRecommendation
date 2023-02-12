package bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

@WebServlet(
		urlPatterns = {"/logout"}
		)
public class SignoutServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(SignoutServlet.class);

	private static final long serialVersionUID = 1L;
	private static String RESPONSE_PARAM_USER = "LoggedInUser";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("Inside SignoutServlet.doGet()");
		request.getSession().removeAttribute(RESPONSE_PARAM_USER);
		request.getRequestDispatcher("/Logout.jsp").forward(request, response);
	}
}
