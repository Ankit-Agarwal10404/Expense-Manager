package expenseManager.servletController;

import java.io.IOException;
import java.time.LocalDate;

import expenseManager.dao.ExpensesDao;
import expenseManager.dto.Expenses;
import expenseManager.dto.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/expenseAdd")
public class AddExpensesServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("expenseId"));
		int userId = Integer.parseInt(req.getParameter("userId"));
		double amount = Double.parseDouble(req.getParameter("expenseAmount"));
		String category = req.getParameter("expenseCategory");
		String date = req.getParameter("expenseDate");
		LocalDate localDate = LocalDate.parse(date);
		String description = req.getParameter("expenseDescription");
		
		Expenses expenses = new Expenses();
		expenses.setId(id);
		expenses.setUserId(userId);
		expenses.setAmount(amount);
		expenses.setCategory(category);
		expenses.setDate(localDate);
		expenses.setDescription(description);
		
		ExpensesDao expensesDao = new ExpensesDao();
		Expenses expenses2 = expensesDao.addExpenses(expenses);
		System.out.println("before if");
		if(expenses2 !=null) {
			req.setAttribute("message", "Expense Added Successfully!");
			RequestDispatcher rd = req.getRequestDispatcher("expense.jsp");
			rd.forward(req, resp);
			System.out.println("you are registered");
		}else {
			System.out.println("in else block");
			req.setAttribute("message", "Expense cannot Added Successfully!");
			RequestDispatcher rd = req.getRequestDispatcher("/expense.jsp");
			//rd.forward(req, resp);
			resp.sendRedirect("expense.jsp");
			System.out.println("something went wrong");
		}

	}

}
