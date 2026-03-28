package expenseManager.userController;

import java.util.Scanner;

import expenseManager.dao.UsersDao;
import expenseManager.dto.User;

public class UpdateUserByIdController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id");
		int id = sc.nextInt();
		User user = new User();
		user.setName("aaa");
		user.setEmail("aaa@gmail.com");
		user.setPassword("aaa123");
		user.setId(id);
		
		UsersDao usersDao = new UsersDao();
		usersDao.updateUserById(user);
		
		sc.close();
	}
}
