<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Expense</title>
<style>
body {
    font-family: 'Segoe UI', sans-serif;
    background: #eff3f6;
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    margin: 0;
}
.container {
    width: 360px;
    padding: 30px;
    background: white;
    border-radius: 18px;
    box-shadow: 0 18px 36px rgba(38, 78, 118, 0.12);
}
h2 {
    margin-bottom: 20px;
    color: #1d3557;
    text-align: center;
}
label {
    display: block;
    font-weight: 700;
    margin-bottom: 8px;
}
input {
    width: 100%;
    padding: 12px;
    border: 1px solid #d3dce6;
    border-radius: 10px;
    margin-bottom: 18px;
}
button {
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 10px;
    background: #d62828;
    color: white;
    font-weight: 700;
    cursor: pointer;
}
a {
    display: block;
    margin-top: 18px;
    text-align: center;
    color: #1d3557;
    text-decoration: none;
}
</style>
</head>
<body>
<div class="container">
    <h2>Delete Expense</h2>
    <form action="expenseDelete" method="get">
        <label>Expense ID</label>
        <input type="number" name="expenseId" placeholder="Enter expense ID" required>
        <button type="submit">Delete Expense</button>
    </form>
    <a href="expense.jsp">Back to Expense Dashboard</a>
</div>
</body>
</html>
