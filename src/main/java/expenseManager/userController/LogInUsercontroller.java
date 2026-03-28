package expenseManager.userController;

import java.util.Scanner;

import expenseManager.dao.UsersDao;

public class LogInUsercontroller {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your email");
		String email = sc.next();
		System.out.println("enter your password");
		String password= sc.next();
		
		UsersDao usersDao = new UsersDao();
		
		boolean res =usersDao.userLogin(email , password);
		System.out.println(res);
		
		sc.close();
	}
}
