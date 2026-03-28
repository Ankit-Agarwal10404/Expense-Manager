package expenseManager.expenseController;

import java.sql.Date;

import expenseManager.dao.ExpensesDao;
import expenseManager.dto.Expenses;

public class AddExpenseController {
	public static void main(String[] args) {
		Expenses expenses = new Expenses();
		ExpensesDao expensesDao = new ExpensesDao();
		expenses.setId(103);
		expenses.setUserId(103);
		expenses.setAmount(4000);
		expenses.setCategory("sports");
		expenses.setDescription("sports expense are 4000");
		expenses.setDate(Date.valueOf("2000-04-19"));
		
		
		expensesDao.addExpenses(expenses);
	}
}
