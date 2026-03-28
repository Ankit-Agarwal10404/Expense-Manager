package expenseManager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import expenseManager.connection.DbConnection;
import expenseManager.dto.Expenses;

public class ExpensesDao {
	Connection connection=DbConnection.connection();
	public void addExpenses(Expenses expenses) {
		String query = "insert into expenses(id, user_id , amount , category , date, description) values (? ,? ,? ,? ,? ,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, expenses.getId());
			ps.setInt(2, expenses.getUserId());
			ps.setDouble(3, expenses.getAmount());
			ps.setString(4, expenses.getCategory());
			ps.setDate(5, expenses.getDate());
			ps.setString(6, expenses.getCategory());
			
			int result =ps.executeUpdate();
			String msg = result > 0 ? "expense inserted": "Something went wrong";
			System.out.println(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Expenses> getAllExpenses() {
		Expenses expenses = new Expenses();
		String query = "select * from expenses";
		try {
			PreparedStatement ps =connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			ArrayList<Expenses> expensesList =  new ArrayList<Expenses>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				double amount = rs.getDouble("amount");
				String category = rs.getString("category");
				Date date = rs.getDate("date");
				String description = rs.getString("description");
				int userId = rs.getInt("user_id");
				
				expenses.setId(id);
				expenses.setAmount(amount);
				expenses.setCategory(category);
				expenses.setUserId(userId);
				expenses.setDate(date);
				expenses.setDescription(description);
				
				expensesList.add(expenses);
			}
			
			return expensesList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Expenses getExpenseByUserId(int id) {
		String query =  "select * from expenses where id = ?";
		
		try {
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			Expenses expenses = new Expenses();
			if(rs.next()) {
				int id1 = rs.getInt("id");
				double amount = rs.getDouble("amount");
				String category = rs.getString("category");
				Date date = rs.getDate("date");
				String description = rs.getString("description");
				int userId = rs.getInt("user_id");
				
				expenses.setId(id1);
				expenses.setAmount(amount);
				expenses.setCategory(category);
				expenses.setUserId(userId);
				expenses.setDate(date);
				expenses.setDescription(description);
				
				return expenses;
			}
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	public void updateExpenseByID() {
		String query = "UPDATE expenses SET amount=?, category=? WHERE id=?;";
		
		try {
			PreparedStatement ps =connection.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	public void deleteExpenseById(int id) {
		String query ="DELETE FROM expenses WHERE id=?;";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			int result=ps.executeUpdate();
			
			String msg = result>0 ?"id deleted" : "something went wrong";
			System.out.println(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
