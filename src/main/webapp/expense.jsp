<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Management DashBoard</title>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Body */
body {
    font-family: 'Segoe UI', sans-serif;
    background: linear-gradient(to right, #eef2f3, #dfe9f3);
}

/* Header */
header {
    background: linear-gradient(135deg, #2c3e50, #4ca1af);
    color: white;
    text-align: center;
    padding: 25px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.2);
}

header h1 {
    font-size: 30px;
    letter-spacing: 1px;
}

/* Container */
.container {
    width: 85%;
    margin: 50px auto;
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    gap: 25px;
}

/* Cards */
.card {
    width: 240px;
    padding: 30px 20px;
    background: white;
    border-radius: 15px;
    box-shadow: 0 6px 18px rgba(0,0,0,0.1);
    text-align: center;
    transition: all 0.3s ease;
    position: relative;
    overflow: hidden;
}

/* Hover Effect */
.card:hover {
    transform: translateY(-10px) scale(1.03);
    box-shadow: 0 10px 25px rgba(0,0,0,0.2);
}

/* Top Color Bar */
.card::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 5px;
    background: linear-gradient(90deg, #4ca1af, #2c3e50);
}

/* Icons */
.card span {
    font-size: 40px;
    display: block;
    margin-bottom: 15px;
}

/* Links */
.card a {
    text-decoration: none;
    color: #2c3e50;
    font-size: 18px;
    font-weight: 600;
}

/* Footer */
footer {
    background: #2c3e50;
    color: white;
    text-align: center;
    padding: 12px;
    margin-top: 50px;
    font-size: 14px;
}
</style>

</head>
<body>

<header>
    <h1>💰 Expense Management Dashboard</h1>
</header>
	<h3>${message}</h3>
<div class="container">
	
    <div class="card">
        <span>➕</span>
        <a href="AddExpense.jsp">Add Expense</a>
    </div>

    <div class="card">
        <span>✏️</span>
        <a href="updateExpense.jsp">Update Expense</a>
    </div>

    <div class="card">
        <span>📊</span>
        <a href="displayExpense">View Expenses</a>
    </div>

    <div class="card">
        <span>🗑️</span>
        <a href="deleteExpense.jsp">Delete Expense</a>
    </div>

</div>

<footer>
    <p>© 2026 Expense Management System | Designed by Ankit Agarwal 🚀</p>
</footer>

</body>
</html>