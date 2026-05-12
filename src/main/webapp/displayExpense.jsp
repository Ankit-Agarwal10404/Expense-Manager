<%@page import="java.util.List"%>
<%@page import="expenseManager.dto.Expenses"%>
<%@page import="expenseManager.dao.ExpensesDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // Session validation
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Expenses> expenseList = (List<Expenses>) request.getAttribute("expenseList");
    if (expenseList == null) {
        ExpensesDao expensesDao = new ExpensesDao();
        expenseList = expensesDao.getAllExpenses();
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Displaying All Expenses</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #667eea, #764ba2);
        color: #fff;
        text-align: center;
        margin: 0;
        padding: 20px;
    }

    h2 {
        margin-bottom: 20px;
    }

    table {
        margin: auto;
        border-collapse: collapse;
        width: 90%;
        background-color: #ffffff;
        color: #333;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 8px 20px rgba(0,0,0,0.3);
    }

    th {
        background-color: #667eea;
        color: white;
        padding: 12px;
    }

    td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
    }

    tr:hover {
        background-color: #f1f1f1;
        transition: 0.3s;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    .back-btn {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        background: linear-gradient(135deg, #667eea, #764ba2);
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: 0.3s;
    }

    .back-btn:hover {
        opacity: 0.8;
    }
</style>

</head>
<body>

<h2>All Expenses List</h2>

<%
    ExpensesDao expensesDao = new ExpensesDao();
    List<Expenses> expenseList1 = expensesDao.getAllExpenses();
%>

<table>
    <tr>
        <th>ID</th>
        <th>Amount</th>
        <th>Category</th>
        <th>Date</th>
        <th>Description</th>
        <th>User ID</th>
    </tr>

    <% for(Expenses expense : expenseList1) { %>
    <tr>
        <td><%= expense.getId() %></td>
        <td>$<%= expense.getAmount() %></td>
        <td><%= expense.getCategory() %></td>
        <td><%= expense.getDate() %></td>
        <td><%= expense.getDescription() %></td>
        <td><%= expense.getUserId() %></td>
    </tr>
    <% } %>

</table>

<a href="expense.jsp" class="back-btn">Back to Expenses</a>

</body>
</html>