package expenseManager.servletController;

import java.io.IOException;
import java.time.LocalDate;

import expenseManager.dao.ExpensesDao;
import expenseManager.dto.Expenses;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/expenseUpdate")
public class UpdateExpenseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("expenseId"));
        double amount = Double.parseDouble(req.getParameter("expenseAmount"));
        String category = req.getParameter("expenseCategory");
        String date = req.getParameter("expenseDate");
        LocalDate localDate = LocalDate.parse(date);
        String description = req.getParameter("expenseDescription");

        Expenses expenses = new Expenses();
        expenses.setId(id);
        expenses.setAmount(amount);
        expenses.setCategory(category);
        expenses.setDate(localDate);
        expenses.setDescription(description);

        ExpensesDao expensesDao = new ExpensesDao();
        Expenses updated = expensesDao.updateExpenseByID(expenses);

        if (updated != null) {
            req.setAttribute("message", "Expense updated successfully!");
            RequestDispatcher rd = req.getRequestDispatcher("expense.jsp");
            rd.forward(req, resp);
        } else {
            req.setAttribute("message", "Unable to update expense. Please check the expense ID.");
            RequestDispatcher rd = req.getRequestDispatcher("updateExpense.jsp");
            rd.forward(req, resp);
        }
    }
}
