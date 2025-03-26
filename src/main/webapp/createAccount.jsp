<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CreateAccount</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
 	<form action="createAccountDetails" method="POST" autocomplete="off">
	Sign up
	Potential Username: <input type="text" name="username"/> <br/>
		<br/>
		<br/>
		
		Potential Password(Credentials):<input type="password" name="password"/> <br/>
		
		<br/>
		
		<form action = "createAccountDetails.jsp">
		Create customer account
		<a href='login.jsp'>Create Customer Account</a>
		
		<br />
		
		<form action = "createAccountDetails.jsp">
		Create admin account
		<a href='login.jsp'>Create Admin Account</a>
		
				<br />
		
		
		<form action = "createAccountDetails.jsp">
		Create customer representative account
		<a href='login.jsp'>Create Customer Representative Account</a>
		
		<br />
		
	</form>
	</form>

</body>

</html>