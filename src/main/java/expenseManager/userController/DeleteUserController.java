package expenseManager.userController;

import java.util.Scanner;

import expenseManager.dao.UsersDao;

public class DeleteUserController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id");
		int id = sc.nextInt();
		UsersDao usersDao = new UsersDao();
		usersDao.deleteUser(id);
		sc.close();
	}
}
