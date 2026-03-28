package expenseManager.expenseController;

import java.util.Scanner;

import expenseManager.dao.ExpensesDao;
import expenseManager.dto.Expenses;

public class getExpensesByUserIdController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter yout user id");
		int id = sc.nextInt();
		
		ExpensesDao expensesDao = new ExpensesDao();
		Expenses expenses=expensesDao.getExpenseByUserId(id);
		
		System.out.println(expenses);
		
		sc.close();
		
	}
}
