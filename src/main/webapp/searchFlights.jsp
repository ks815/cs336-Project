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

<table border="1">
  <thead>
    <tr>
      <th>Aircraft ID</th>
      <th>Airline ID</th>
      <th>Domestic</th>
      <th>Flight Number</th>
      <th>Arrival Time</th>
      <th>Departure Time</th>
      <th>Destination Airport</th>
      <th>Departure Airport</th>
      <th>Departure Day</th>
      <th>Flight Duration</th>
      <th>Waiting List</th>
      <th>Price</th>
      
    </tr>
  
  <tr>
    <td>A43</td>
    <td>AA</td>
    <td>Y</td>
    <td>123</td>
    <td>2023-12-21 4:00:00</td>
    <td>2023-12-21 8:00:00</td>
    <td>JFK</td>
    <td>LHR</td>
    <td>Monday</td>
    <td>4 hours</td>
    <td>Yes</td>
    <td>$431.00</td> 
  </tr>
  
  <tr>
    <td>B34</td>
    <td>BA</td>
    <td>N</td>
    <td>456</td>
    <td>2023-12-22 12:30:00</td>
    <td>2023-12-22 17:30:00</td>
    <td>JFK</td>
    <td>LHR</td>
    <td>Tuesday</td>
    <td>5 hours</td>
    <td>Yes</td>
    <td>$339.00</td>
  </tr>
  
  <tr>
    <td>C3X</td>
    <td>CX</td>
    <td>Y</td>
    <td>789</td>
    <td>2023-12-23 21:00:00</td>
    <td>2023-12-24 3:00:00</td>
    <td>JFK</td>
    <td>LHR</td>
    <td>Wednesday</td>
    <td>6 hours</td>
    <td>No</td>
    <td>$224.00</td>
  </tr>  
  
  </thead>
  </table>

<button><a href='flightBook.jsp'>Reserve #1</a><button>
<button><a href='bookFlight.jsp'>Reserve #2</a><button>
<button><a href='bookFlightss.jsp'>Reserve #3</a><button>


</body>
</html>