package expenseManager.userController;

import expenseManager.dao.UsersDao;
import expenseManager.dto.User;

public class InsertUserController {
	public static void main(String[] args) {
		
		UsersDao usersDao = new UsersDao();
		User user = new User();
		
		user.setId(103);
		user.setName("ankit");
		user.setEmail("ankit@gmail.com");
		user.setPassword("ankit@123");
		
		User user2=usersDao.insertUser(user);
		
		String msg = user2 !=null ? "Data stored " : "something went wrong";
		System.out.println(msg);
		
	}
	
	
}
