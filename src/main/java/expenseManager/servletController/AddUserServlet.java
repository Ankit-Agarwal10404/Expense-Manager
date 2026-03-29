package expenseManager.servletController;

import java.io.IOException;
import java.io.PrintWriter;

import expenseManager.dao.UsersDao;
import expenseManager.dto.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userRegister")
public class AddUserServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name =req.getParameter("name");
		int id =Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		String password = req.getParameter("psw");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UsersDao usersDao = new UsersDao();
		User user2=usersDao.insertUser(user);
		
		PrintWriter printWriter=resp.getWriter();
		
		if(user2 != null) {
			
			RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
			//printWriter.write("you are registered");
			System.out.println("you are registered");
		}else {
			printWriter.write("you are not registered");
			System.out.println("something went wrong");
		}
	}

}
