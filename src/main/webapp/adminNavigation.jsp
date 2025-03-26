<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	You have registered as Admin as nikhil. 
	Admin Navigation Page
	
	<button><a href='customerInfo.jsp'>Customers(currently in database)</a></button>
	
	<br>
	
	
	<button><a href='sales.jsp'>Sales Report</a></button>
		
	<br>
	
	<form autocomplete="off">
	    Flight Number: 
	    <input type="text" name="flightnum"/> 
		<br>
		Customer Name:
		<input type="text" name="cusName"/> 
		<br>
	</form>
	<button>
		<a href='reservation1.jsp'>
			Reservations
		</a>
	</button>
	
	
	
	<br>
	
	<button><a href='mostFlights.jsp'>Most Flights</a></button>
	
	<br>				
			
	<form autocomplete="off">
	    Flight Number: 
	    <input type="text" name="flightnum"/> 
		<br>
		Airline:
		<input type="text" name="airline"/> 
		<br>
		Customer:
		<input type="text" name="cusName">
		<br>
	</form>
	
	<button>
		<a href='revenueSum.jsp'>
			Revenue Summary
		</a>
	</button>	
	
	<button><a href='logout.jsp'>Log out</a><button>
	
	
			
		
</body>
</html>