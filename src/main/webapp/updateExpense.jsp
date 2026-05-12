<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Expense</title>
<style>
body {
    font-family: 'Segoe UI', sans-serif;
    background: #f0f4f8;
    margin: 0;
    color: #333;
}
.container {
    width: 420px;
    margin: 70px auto;
    background: white;
    padding: 28px;
    border-radius: 16px;
    box-shadow: 0 18px 40px rgba(0,0,0,0.08);
}
h2 {
    text-align: center;
    color: #1d3557;
    margin-bottom: 20px;
}
label {
    display: block;
    margin-top: 14px;
    font-weight: 600;
}
input {
    width: 100%;
    padding: 12px;
    margin-top: 6px;
    border: 1px solid #cee0f4;
    border-radius: 10px;
}
button {
    width: 100%;
    margin-top: 20px;
    padding: 12px;
    border: none;
    border-radius: 10px;
    background: linear-gradient(90deg, #3f72af, #112d4e);
    color: white;
    font-weight: 700;
    cursor: pointer;
}
a {
    display: block;
    margin-top: 18px;
    text-align: center;
    color: #3f72af;
    text-decoration: none;
}
</style>
</head>
<body>
<div class="container">
    <h2>Update Expense</h2>
    <form action="expenseUpdate" method="post">
        <label>Expense ID</label>
        <input type="number" name="expenseId" placeholder="Expense ID" required>

        <label>Amount</label>
        <input type="number" step="0.01" name="expenseAmount" placeholder="New amount" required>

        <label>Category</label>
        <input type="text" name="expenseCategory" placeholder="New category" required>

        <label>Date</label>
        <input type="date" name="expenseDate" required>

        <label>Description</label>
        <input type="text" name="expenseDescription" placeholder="New description">

        <button type="submit">Update Expense</button>
    </form>
    <a href="expense.jsp">Back to Expense Dashboard</a>
</div>
</body>
</html>
