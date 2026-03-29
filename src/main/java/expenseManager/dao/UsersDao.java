package expenseManager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import expenseManager.connection.DbConnection;
import expenseManager.dto.User;

public class UsersDao {
	Connection connection = DbConnection.connection();
	
	
	public User insertUser(User user) {
		
		String query ="insert into users(id,name,email,password) values (?,?,?,?)";
		try {
			PreparedStatement ps =connection.prepareStatement(query);
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			
			int result=ps.executeUpdate();
			
			return result!=0 ? user : null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
	}
	public List<User> getAllUSers() {
		
		String query = "select * from users";
		try {
			PreparedStatement ps =connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			List<User> users = new ArrayList<User>(); 
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password= rs.getString("password");
				
				User user = new User();
				
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				
				users.add(user);
				
			}
			
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public User getUserById(int id) {
		String query = "select * from users where id = ?";
		try {
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
			int userId = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String password= rs.getString("password");
			
			User user = new User();
			
			user.setId(userId);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			
			return user;
			}
		
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public User getUserByEmail(String email) {
		String query = "select * from users where email =?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			User user = new User();
			
			if(rs.next()) {
				int userId = rs.getInt("id");
				String name = rs.getString("name");
				String mail = rs.getString("email");
				String password= rs.getString("password");
				
				User user2 = new User();
				
				user.setId(userId);
				user.setName(name);
				user.setEmail(mail);
				user.setPassword(password);
				
				return user;
				}
			
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void updateUserById(User user ) {
		String query = "update users set name = ? , email = ? , password = ? where id = ?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getId());
			
			int res=ps.executeUpdate();
			
			if(res>0) {
				System.out.println("update successfully");
			}else {
				System.out.println("something went wrong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void deleteUser(int userId) {
		String query = "delete from users where id =?";
		
		try {
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setInt(1, userId);
			
			int res=ps.executeUpdate();
			
			if(res>0)
				System.out.println("delete user successfully");
			else
				System.out.println("something went wrong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean userLogin(String email , String password) {
		String query = "select * from users where email = ? AND password =?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			
			return rs.next() ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
