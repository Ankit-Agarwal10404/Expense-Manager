<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Login</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial, Helvetica, sans-serif;
}

/* Background */
body{
height:100vh;
display:flex;
justify-content:center;
align-items:center;
background: linear-gradient(135deg,#36d1dc,#5b86e5);
}

/* Login Card */
.login-container{
background:white;
padding:40px;
border-radius:12px;
width:100%;
max-width:380px;
box-shadow:0 10px 25px rgba(0,0,0,0.2);
}

/* Title */
.login-container h2{
text-align:center;
margin-bottom:25px;
color:#333;
}

/* Labels */
label{
font-weight:bold;
color:#444;
font-size:14px;
}

/* Inputs */
input{
width:100%;
padding:10px;
margin-top:6px;
margin-bottom:18px;
border-radius:6px;
border:1px solid #ccc;
transition:0.3s;
}

/* Focus Effect */
input:focus{
border-color:#5b86e5;
outline:none;
box-shadow:0 0 5px rgba(91,134,229,0.5);
}

/* Button */
button{
width:100%;
padding:12px;
border:none;
border-radius:6px;
background: linear-gradient(135deg,#36d1dc,#5b86e5);
color:white;
font-size:16px;
cursor:pointer;
transition:0.3s;
}

/* Hover */
button:hover{
opacity:0.9;
}

/* Responsive */
@media(max-width:480px){
.login-container{
padding:25px;
}
}

</style>

</head>

<body>

<div class="login">

<h2>User delete</h2>

<form action="userDelete" method="get">

<label>Employee id</label>
<input type="number" name="id" placeholder="Enter your user id" required>

<button type="submit">submit</button>

</form>

</div>

</body>
</html>