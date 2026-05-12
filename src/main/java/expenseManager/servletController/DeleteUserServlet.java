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
@WebServlet(value = "/userDelete")
public class DeleteUserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		UsersDao usersDao = new UsersDao();
		User user=usersDao.getUserById(id);
		
		if(user != null) {
			usersDao.deleteUser(id);
			RequestDispatcher rq=req.getRequestDispatcher("user.jsp");
			rq.include(req, resp);
			PrintWriter pw=resp.getWriter();
			pw.print("user deleted");
		}
		else {
			
			RequestDispatcher rq=req.getRequestDispatcher("deleteUser.jsp");
			rq.include(req, resp);
			PrintWriter pw=resp.getWriter();
			pw.print("user not deleted");

			
		}
	}
}
