package expenseManager.servletController;

import java.io.IOException;

import expenseManager.dao.UsersDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class loginUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email =req.getParameter("email");
		String password=req.getParameter("password");
		
		UsersDao usersDao = new UsersDao();
		
		if(usersDao.getUserByEmail(email)!= null) {
			if(usersDao.getUserByEmail(email).getPassword().equals(password)) {
				RequestDispatcher rs=req.getRequestDispatcher("/expense.jsp");
				rs.forward(req, resp);
				System.out.println("successfully login");
			}else {
				RequestDispatcher rs=req.getRequestDispatcher("/login.jsp");
				rs.forward(req, resp);
				System.out.println("check your password");
			}
		}else {
			RequestDispatcher rs=req.getRequestDispatcher("/login.jsp");
			rs.forward(req, resp);
			System.out.println("Something went wrong");
		}
	}
}
