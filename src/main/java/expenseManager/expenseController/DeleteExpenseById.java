package expenseManager.expenseController;

import java.util.Scanner;

import expenseManager.dao.ExpensesDao;

public class DeleteExpenseById {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("enter id ");
	int id = sc.nextInt();
	
	ExpensesDao expensesDao = new ExpensesDao();
	
	expensesDao.deleteExpenseById(id);
	
	sc.close();
}
}
