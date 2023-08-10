<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="./assets/style.css" /> 
		<title>CASH.NET</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<div id="r1">
		<h1>WELCOME TO CASH.NET</h1>
		<div id="container">
			<div id="type">
				<a href="#withdraw" id="withdrawbtn">WITHDRAW</a>
				<a href="#balance" id="balancebtn">BALANCE</a>
				<a href="#deposit" id="depositbtn">DEPOSIT</a>
			</div>
			<form action="/jspservlet-app-ATM/withdraw" method="post">
			<br><br><div id="withdraw" class="options">
				<div id="sel">
					<div id="rt">
						<label id="b">Account Type</label> <input class="roomtype" type="radio" name="account-type" value="savings" id="savingsacc" required/><label>Savings</label>
						<input class="roomtype" type="radio" name="account-type" value="current" id="currentacc" required /><label>Current</label>
					</div><br><br><br>
				</div>
				<div id="ins">
					<div id="inputs">
						<input type="number" name="amount" placeholder="Enter the amount to withdraw">
						<input type="number" name="pin" placeholder="Enter your PIN">
						<button name="click">WITHDRAW</button>
					</div>
				</div><br><br>
				
				<div id="msg">
				<h3>Your available balance is <%out.print(request.getAttribute("message")); %> </h3>
				</div>
			</div>
			</form>
			<form action="/jspservlet-app-ATM/balance" method="post">
			<div id="balance" class="options">
				<div id="sel">
					<div id="rt">
						<label id="b">Account Type</label> <input class="roomtype" type="radio" name="account-type" value="savings" id="savingsacc" required/><label>Savings</label>
						<input class="roomtype" type="radio" name="account-type" value="current" id="currentacc" required /><label>Current</label>
					</div><br><br><br>
				</div>
				<div id="ins">
					<div id="inputs">
						<h4>Balance: <%out.print(request.getAttribute("balamt"));%></h4>
						<input type="number" name="pin" placeholder="Enter your PIN">
						<button name="click">SUBMIT</button>
					</div>
				</div>
			</div>
			</form>
			<form action="/jspservlet-app-ATM/deposit" method="post">
			<div id="deposit" class="options">
				<div id="sel">
					<div id="rt">
						<label id="b">Account Type</label> <input class="roomtype" type="radio" name="account-type" value="savings" id="savingsacc" required/><label>Savings</label>
						<input class="roomtype" type="radio" name="account-type" value="current" id="currentacc" required /><label>Current</label>
					</div><br><br><br>
				</div>
				<div id="ins">
					<div id="inputs">
						<input type="number" name="amount" placeholder="Enter the amount to deposit">
						<input type="number" name="pin" placeholder="Enter your PIN">
						<button name="click">DEPOSIT</button>
					</div>
				</div><br><br>
				<div id="msg">
				<h3>Your available balance is <%out.print(request.getAttribute("message")); %> </h3>
				</div>
			</div>
			</form>		
		</div>
	</div>
	
	</body>
	<script>
		document.getElementById('withdrawbtn').addEventListener('click',()=>{
			document.getElementById('withdraw').style.display="block";
			document.getElementById('deposit').style.display="none";
			document.getElementById('balance').style.display="none";
			
		})
		document.getElementById('depositbtn').addEventListener('click',()=>{
			document.getElementById('withdraw').style.display="none";
			document.getElementById('deposit').style.display="block";
			document.getElementById('balance').style.display="none";
			
		})
		document.getElementById('balancebtn').addEventListener('click',()=>{
			document.getElementById('withdraw').style.display="none";
			document.getElementById('deposit').style.display="none";
			document.getElementById('balance').style.display="block";
			
		})
		
	</script>
	</html>