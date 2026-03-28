package expenseManager.expenseController;

import java.util.ArrayList;


import expenseManager.dao.ExpensesDao;
import expenseManager.dto.Expenses;

public class getAllExpensesController {
	public static void main(String[] args) {
		ExpensesDao expensesDao = new ExpensesDao();
		
		ArrayList<Expenses> expensesList=expensesDao.getAllExpenses();
		
		for(Expenses expense : expensesList) {
			System.out.println(expense);
		}
		
	}
}
