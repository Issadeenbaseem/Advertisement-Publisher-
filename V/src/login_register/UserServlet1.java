package login_register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class UserServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private UserDeo userDeo = new UserDeo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

           User user = new User();
           
           user.setFirstname(firstname);
           user.setLastname(lastname);
           user.setUsername(username);
           user.setPassword(password);
           user.setAddress(address);
           user.setContact(contact);
           
           try {
			userDeo.registerUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           response.sendRedirect("UserLogin.jsp");
	}
}
