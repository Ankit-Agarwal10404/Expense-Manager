package expenseManager.servletController;

import java.io.IOException;
import java.util.List;

import expenseManager.dao.ExpensesDao;
import expenseManager.dto.Expenses;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/displayExpense")
public class DisplayExpenseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExpensesDao expensesDao = new ExpensesDao();
        List<Expenses> expenseList = expensesDao.getAllExpenses();
        req.setAttribute("expenseList", expenseList);

        RequestDispatcher rd = req.getRequestDispatcher("displayExpense.jsp");
        rd.forward(req, resp);
    }
}
