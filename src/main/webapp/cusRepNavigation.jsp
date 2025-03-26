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

	<h1>
		Customer Representative Navigation Page
	</h1>

	<h2>
		Edit User and Flight Information
	</h2>
	<br>
	
	<b>
		Reserve a flight on behalf of a user
	</b>
	<form action="cusflightlist.jsp" autocomplete="off">
		Customer name:
		<input type="text" name="cusname"/>
		<br>
		Flight Number:
		<input type="text" name="fnum"/>
		<br>
		<input type="submit" value="Submit">
	</form>
	<br>
	
	
	<b>
		Replace a flight on behalf of a user
	</b>
	<form action="cusflightlist1.jsp" autocomplete="off">
		Customer name:
		<input type="text" name="cusname"/>
		<br>
		Old Flight Number:
		<input type="text" name="fnum"/>
		<br>
		New Flight Number:
		<input type="text" name="fnum"/>
		<br>
		<input type="submit" value="Submit">	
	</form>
	<br>
	
	
	
	
	<b>
		Delete a flight on behalf of a user
	</b>
	<form action="cusflightlist2.jsp" autocomplete="off">
		Customer name:
		<input type="text" name="cusname"/>
		<br>
		Flight Number: 
		<input type="text" name="fnum"/>	
		<br>
		<input type="submit" value="Submit">
	</form>
	<br>
	
	<br>
	
	<h2>
		Edit Flight, Aircraft, and Airport Details
	</h2>
	<br>

	<b>
		Add a Flight, Aircraft, or Airport
	</b>
	<form action="edflightlist.jsp" autocomplete="off">
		Add Information for:
		<br>
		<input type="radio" name="fnum" value="Aircraft" id="q11"/>
		<label for="q11">
			Aircraft
		</label>
		<br>
		<input type="radio" name="fnum" value="Airport" id="q12"/>
		<label for="q12">
			Airport
		</label>
		<br>
		<input type="radio" name="fnum" value="Flight" id="q13"/>
		<label for="q13">
			Flight
		</label>
		<br>
		Flight Number, Aircraft ID, or Airport ID:
		<br>
		<input type="text" name="datanum"/>
		<br>
		<input type="submit" value="Submit">
	</form>
	<br>
	
	
	<b>
		Edit a Flight, Aircraft, or Airport
	</b>
	<form action="edflightlist1.jsp" autocomplete="off">
		Add Information for:
		<br>
		<input type="radio" name="fnum" value="Aircraft" id="q21"/>
		<label for="q21">
			Aircraft
		</label>
		<br>
		<input type="radio" name="fnum" value="Airport" id="q22"/>
		<label for="q22">
			Airport
		</label>
		<br>
		<input type="radio" name="fnum" value="Flight" id="q23"/>
		<label for="q23">
			Flight
		</label>
		<br>
		Flight Number, Aircraft ID, or Airport ID:
		<br>
		<input type="text" name="datanum"/>
		<br>
		<input type="submit" value="Submit">
	</form>
	<br>
	
	
	<b>
		Delete a Flight, Aircraft, or Airport
	</b>
	<form action="edflightlist2.jsp" autocomplete="off">
		Add Information for:
		<br>
		<input type="radio" name="fnum" value="Aircraft" id="q31"/>
		<label for="q31">
			Aircraft
		</label>
		<br>
		<input type="radio" name="fnum" value="Airport" id="q32"/>
		<label for="q32">
			Airport
		</label>
		<br>
		<input type="radio" name="fnum" value="Flight" id="q33"/>
		<label for="q33">
			Flight
		</label>
		<br>
		Flight Number, Aircraft ID, or Airport ID:
		<br>
		<input type="text" name="datanum"/>
		<br>
		<input type="submit" value="Submit">
	</form>
	<br>
	
	<h2>
		Waiting List
	</h2>
	<!-- currwaitinglist.jsp, make some random customers and flights
	for waitining list -->
	<a href = "currwaitinglist.jsp">
		Retrieve Waiting List
	</a>
	<br>
	
	<h2>
		Flights for airport
	</h2>
	
	<!-- airflights.jsp, list of flights but MAKE SURE departing
		or arriving flight is the same for all -->
	<b>
		Flights for airport:
	</b>
	<form action="airflights.jsp" autocomplete="off">
		Airport:
		<br>
		<input type="text" name="airport"/>
		<br>
		<input type="submit" value="Submit">
	</form>
	<br>
	
	<h2>
		Access user questions
	</h2>

	<a href = "userquestions.jsp">		Answer User Questions
	</a>
	<br>
	<br>
	<br>
	
	<a href = "logout.jsp">Logout</a>
</body>
</html>