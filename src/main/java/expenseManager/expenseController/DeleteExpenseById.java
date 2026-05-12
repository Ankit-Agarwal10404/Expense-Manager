package expenseManager.expenseController;

import java.util.Scanner;

import expenseManager.dao.ExpensesDao;

public class DeleteExpenseById {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("enter id ");
	int id = sc.nextInt();
	
	ExpensesDao expensesDao = new ExpensesDao();
	
	boolean deleted = expensesDao.deleteExpenseById(id);
	System.out.println(deleted ? "Expense deleted" : "Unable to delete expense");
	
	sc.close();
}
}
