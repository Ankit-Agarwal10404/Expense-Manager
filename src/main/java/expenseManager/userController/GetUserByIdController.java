package expenseManager.userController;

import expenseManager.dao.UsersDao;
import expenseManager.dto.User;

public class GetUserByIdController {
	public static void main(String[] args) {
		UsersDao usersDao = new UsersDao();
		User user=usersDao.getUserById(105);
		
		System.out.println(user);
	}
}
