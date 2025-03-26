<!DOCTYPE html>
<html>
	<head>
		<title>Login Form</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	</head>
	<body>
	 <form action="checkLoginDetails.jsp" method="POST" autocomplete="off">
		Username: <input type="text" name="username"/> <br/>
		<br/>
		<br/>
		
		Password(Credentials):<input type="password" name="password"/> <br/>
		<input type="submit" value="Customer Login"/>
	</form>
	
	<br/>
	<form action = "createAccountDetails.jsp">
		<button><a href='adminNavigation.jsp'>Admin Login</a><button>
	</form>
	
	<br/>
	<form action = "createAccountDetails.jsp">
		<button><a href='cusRepNavigation.jsp'>Customer Rep Login</a><button>
	</form>
	<br />
		<button><a href='createAccount.jsp'>Create Account</a><button>
	</body>
</html>