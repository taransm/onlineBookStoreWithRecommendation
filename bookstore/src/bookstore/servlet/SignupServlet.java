package bookstore.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import bookstore.service.SecurityService;

@WebServlet(
		urlPatterns = {"/signup"}
		)
public class SignupServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(SignupServlet.class);

	private static final long serialVersionUID = 1L;
	
	@Inject
	SecurityService securityService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("Inside SignupServlet.doPost()");

		String username = request.getParameter("j_username");
		String password = request.getParameter("j_password");

		boolean isUserCreated = securityService.createCustomerUser(username, password);
		LOGGER.info("Inside SignupServlet.doPost() : isUserCreated : "+isUserCreated);
		
		request.removeAttribute("errorMessage");
		if (!isUserCreated ) {
			request.setAttribute("errorMessage", "Signup failed");
		}
		request.getRequestDispatcher("/PostSignup.jsp").forward(request, response);
	}
}
