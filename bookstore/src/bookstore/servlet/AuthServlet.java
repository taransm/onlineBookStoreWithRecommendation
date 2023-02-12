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
import bookstore.service.SecurityService;

@WebServlet(
		urlPatterns = {"/authenticate"}
		)
public class AuthServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(AuthServlet.class);

	private static final long serialVersionUID = 1L;
	private static String RESPONSE_PARAM_USER = "LoggedInUser";
	
	@Inject
	SecurityService securityService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("Inside AuthServlet.doPost()");

		String username = request.getParameter("j_username");
		String password = request.getParameter("j_password");

		boolean isValidUser = securityService.validateUser(username, password);
		LOGGER.info("Inside AuthServlet.doPost() : isValidUser : "+isValidUser);

		if (!isValidUser) {
			request.setAttribute("errorMessage", "Invalid Credentials");
			request.getRequestDispatcher("/LoginError.jsp").forward(request, response);
			//response.sendRedirect("/LoginError.jsp");
		}

		User user = securityService.findByUsername(username);
		request.getSession().setAttribute(RESPONSE_PARAM_USER, user);
	
		response.sendRedirect(request.getContextPath()+"/searchBook");
	}
}
