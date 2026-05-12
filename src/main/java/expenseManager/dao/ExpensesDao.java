package expenseManager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import expenseManager.connection.DbConnection;
import expenseManager.dto.Expenses;

public class ExpensesDao {
	Connection connection=DbConnection.connection();
	public Expenses addExpenses(Expenses expenses) {
		String query = "insert into expenses(id, user_id , amount , category , date, description) values (? ,? ,? ,? ,? ,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, expenses.getId());
			ps.setInt(2, expenses.getUserId());
			ps.setDouble(3, expenses.getAmount());
			ps.setString(4, expenses.getCategory());
			ps.setDate(5, java.sql.Date.valueOf(expenses.getDate()));
			ps.setString(6, expenses.getDescription());
			
			int result =ps.executeUpdate();
			return result!=0 ? expenses : null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Expenses> getAllExpenses() {
		String query = "select * from expenses";
		try {
			PreparedStatement ps =connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			ArrayList<Expenses> expensesList =  new ArrayList<Expenses>();
			
			while(rs.next()) {
				Expenses expenses = new Expenses();
				int id = rs.getInt("id");
				double amount = rs.getDouble("amount");
				String category = rs.getString("category");
				Date date = rs.getDate("date");
				String description = rs.getString("description");
				int userId = rs.getInt("user_id");
				
				expenses.setId(id);
				expenses.setAmount(amount);
				expenses.setCategory(category);
				expenses.setDate(date.toLocalDate());
				expenses.setDescription(description);
				expenses.setUserId(userId);
				
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
				expenses.setDate(date.toLocalDate());
				expenses.setDescription(description);
				expenses.setUserId(userId);
				
				return expenses;
			}
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	public Expenses updateExpenseByID(Expenses expenses) {
		String query = "UPDATE expenses SET amount=?, category=?, date=?, description=? WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDouble(1, expenses.getAmount());
			ps.setString(2, expenses.getCategory());
			ps.setDate(3, java.sql.Date.valueOf(expenses.getDate()));
			ps.setString(4, expenses.getDescription());
			ps.setInt(5, expenses.getId());
			int result = ps.executeUpdate();
			return result > 0 ? expenses : null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	public boolean deleteExpenseById(int id) {
		String query ="DELETE FROM expenses WHERE id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			int result=ps.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
