<%@page import="java.util.List"%>
<%@page import="expenseManager.dto.User"%>
<%@page import="expenseManager.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Displaying All Users</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #1e3c72, #2a5298);
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
        width: 70%;
        background-color: #ffffff;
        color: #333;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 8px 20px rgba(0,0,0,0.3);
    }

    th {
        background-color: #2a5298;
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
</style>

</head>
<body>

<h2>All Users List</h2>

<%
    UsersDao usersDao = new UsersDao();
    List<User> userList = usersDao.getAllUSers();
%>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>

    <% for(User user : userList) { %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getEmail() %></td>
    </tr>
    <% } %>

</table>

</body>
</html>