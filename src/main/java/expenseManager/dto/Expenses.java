package expenseManager.dto;

import java.sql.Date;

public class Expenses {

	 private int id;
	 private double amount;
	 private String category;
	 private Date date;
	 private String description;
	 private int userId;
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public double getAmount() {
		 return amount;
	 }
	 public void setAmount(double amount) {
		 this.amount = amount;
	 }
	 public String getCategory() {
		 return category;
	 }
	 public void setCategory(String category) {
		 this.category = category;
	 }
	 public Date getDate() {
		 return date;
	 }
	 public void setDate(Date date) {
		 this.date = date;
	 }
	 public String getDescription() {
		 return description;
	 }
	 public void setDescription(String description) {
		 this.description = description;
	 }
	 public int getUserId() {
		 return userId;
	 }
	 public void setUserId(int userId) {
		 this.userId = userId;
	 }
	 @Override
	 public String toString() {
		return "Expenses [id=" + id + ", amount=" + amount + ", category=" + category + ", date=" + date
				+ ", description=" + description + ", userId=" + userId + "]";
	 }
	 
	 
}
