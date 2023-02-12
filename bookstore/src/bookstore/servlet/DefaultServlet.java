package bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

@WebServlet("/home")
public class DefaultServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(DefaultServlet.class);

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			LOGGER.debug("Inside DefaultServlet.doGet()");
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
		} catch (Exception ex) {
			LOGGER.error("Inside DefaultServlet.doGet() : "+ex.getMessage());
			ex.printStackTrace();
		}
	}
}
