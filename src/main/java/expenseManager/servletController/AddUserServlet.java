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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name =req.getParameter("name");
		//this may cause nullPointerException because id may be empty
		//int id =Integer.parseInt(req.getParameter("id"));
		String idStr = req.getParameter("id");
		int id = 0;
		if(idStr != null && !idStr.isEmpty()){
		    id = Integer.parseInt(idStr);
		} else {
		    resp.getWriter().write("ID is required");
		    return;
		}
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
			
			resp.sendRedirect("user.jsp");
			//printWriter.write("you are registered");
			System.out.println("you are registered");
		}else {
			printWriter.write("you are not registered");
			System.out.println("something went wrong");
		}
	}

}
