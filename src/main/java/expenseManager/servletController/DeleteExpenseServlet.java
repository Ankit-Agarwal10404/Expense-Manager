package expenseManager.servletController;

import java.io.IOException;
import java.io.PrintWriter;

import expenseManager.dao.ExpensesDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/expenseDelete")
public class DeleteExpenseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("expenseId"));
        ExpensesDao expensesDao = new ExpensesDao();
        boolean deleted = expensesDao.deleteExpenseById(id);

        if (deleted) {
            req.setAttribute("message", "Expense deleted successfully.");
            RequestDispatcher rd = req.getRequestDispatcher("expense.jsp");
            rd.forward(req, resp);
        } else {
            req.setAttribute("message", "Expense not found or could not be deleted.");
            RequestDispatcher rd = req.getRequestDispatcher("deleteExpense.jsp");
            rd.forward(req, resp);
        }
    }
}
