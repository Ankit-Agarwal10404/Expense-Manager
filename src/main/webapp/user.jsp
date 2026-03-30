<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>

<style>
body{
    font-family: Arial, sans-serif;
    margin:0;
    background:#f4f6f9;
}

header{
    background:#2c3e50;
    color:white;
    padding:20px;
    text-align:center;
}

.container{
    width:80%;
    margin:40px auto;
    text-align:center;
}

.card{
    display:inline-block;
    width:220px;
    margin:20px;
    padding:25px;
    background:white;
    border-radius:10px;
    box-shadow:0 2px 8px rgba(0,0,0,0.1);
    transition:0.3s;
}

.card:hover{
    transform:scale(1.05);
}

.card a{
    text-decoration:none;
    color:#2c3e50;
    font-size:18px;
    font-weight:bold;
}

footer{
    position:fixed;
    bottom:0;
    width:100%;
    background:#2c3e50;
    color:white;
    text-align:center;
    padding:10px;
}
</style>

</head>
<body>

<header>
    <h1>Employee Management System</h1>
</header>

<div class="container">

    <div class="card">
        <a href="addUser.jsp">Add User</a>
    </div>

    <div class="card">
        <a href="login.jsp">Login User</a>
    </div>

    <div class="card">
        <a href="updateUser.jsp">Update User</a>
    </div>
    
    <div class="card">
        <a href="displayUser.jsp">Display All Users</a>
    </div>

    <div class="card">
        <a href="deleteUSer.jsp">Delete User</a>
    </div>

</div>

<footer>
    <p>© 2026 Employee Management System</p>
</footer>

</body>
</html>