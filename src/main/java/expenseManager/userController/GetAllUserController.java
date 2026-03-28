package expenseManager.userController;


import java.util.ArrayList;

import java.util.List;

import expenseManager.dao.UsersDao;
import expenseManager.dto.User;

public class GetAllUserController {
	public static void main(String[] args) {
		UsersDao usersDao = new UsersDao();
		
		List<User> users = new ArrayList<User>();
		users=usersDao.getAllUSers();
		
		for(User user : users) {
			System.out.println(user);
		}
	}
}
