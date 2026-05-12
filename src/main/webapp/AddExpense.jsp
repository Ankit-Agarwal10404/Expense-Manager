<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Expense</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: 'Segoe UI', sans-serif;
}

/* Animated Background */
body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background: linear-gradient(-45deg,#667eea,#764ba2,#6dd5ed,#2193b0);
    background-size:400% 400%;
    animation:bg 10s ease infinite;
}

@keyframes bg{
    0%{background-position:0% 50%;}
    50%{background-position:100% 50%;}
    100%{background-position:0% 50%;}
}

/* Glass Container */
.expenseContainer{
    width:100%;
    max-width:420px;
    padding:35px;
    border-radius:20px;
    background: rgba(255,255,255,0.15);
    backdrop-filter: blur(12px);
    box-shadow:0 8px 32px rgba(0,0,0,0.3);
    border:1px solid rgba(255,255,255,0.2);
}

/* Title */
.expenseContainer h2{
    text-align:center;
    color:white;
    margin-bottom:25px;
    letter-spacing:1px;
}

/* Label */
label{
    color:white;
    font-size:14px;
    font-weight:500;
}

/* Inputs */
input{
    width:100%;
    padding:12px;
    margin:8px 0 15px 0;
    border:none;
    border-radius:10px;
    background: rgba(255,255,255,0.8);
    transition:0.3s;
    font-size:14px;
}

/* Focus Effect */
input:focus{
    outline:none;
    box-shadow:0 0 8px rgba(255,255,255,0.8);
    background:white;
}

/* Button */
button{
    width:100%;
    padding:12px;
    border:none;
    border-radius:25px;
    background: linear-gradient(90deg,#ff7e5f,#feb47b);
    color:white;
    font-size:16px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s;
}

/* Button Hover */
button:hover{
    background: linear-gradient(90deg,#43cea2,#185a9d);
    transform:scale(1.03);
}

/* Responsive */
@media(max-width:480px){
    .expenseContainer{
        padding:25px;
    }
}
</style>

</head>

<body>

<div class="expenseContainer">

<h2>💰 Add Expense</h2>

<form action="expenseAdd" >

<label>Expense ID</label>
<input type="number" placeholder="Enter Expense Id" name="expenseId" required>

<label>User ID</label>
<input type="number" placeholder="Enter User Id" name="userId" required>

<label>Amount</label>	
<input type="number" placeholder="Enter Expense Amount" name="expenseAmount" required>

<label>Category</label>
<input type="text" placeholder="Enter Category (Food, Travel...)" name="expenseCategory" required>

<label>Date</label>
<input type="date" name="expenseDate" required>

<label>Description</label>
<input type="text" placeholder="Enter Description" name="expenseDescription">



<button type="submit" >➕ Add Expense</button>



</form>

</div>

</body>
</html>