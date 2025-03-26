<%
	if ((session.getAttribute("user") == null)) {
%>
You are not logged in<br/>
<a href="login.jsp">Please Login</a>
<%} else {
%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

Welcome 

<br />

Customer Home Page

You have logged in as <%=session.getAttribute("user")%> + customer/admin

<br />

Depart From
<select>
  <option value="Select">Select here</option>
  <option value="NY-LN">New York</option>
  <option value="LA-TK">Los Angeles</option>
  <option value="PR-DU">Paris</option>
  <option value="SY-SG">Sydney</option>
  <option value="BJ-MC">Beijing</option>
  <option value="CA-CT">Cairo</option>
  <option value="BA-RJ">Buenos Aires</option>
  <option value="VC-MX">Vancouver</option>
  <option value="RM-AT">Rome</option>
  <option value="DL-MB">Delhi</option>
</select>

<br />


Destination To
<select>
  <option value="Select">Select here</option>	
  <option value="NY-LN">London</option>
  <option value="LA-TK">Tokoyo</option>
  <option value="PR-DU">Dubai</option>
  <option value="SY-SG">Singapore</option>
  <option value="BJ-MC">Moscow</option>
  <option value="CA-CT">Cape Town</option>
  <option value="BA-RJ">Rio de Janiero</option>
  <option value="VC-MX">Mexico City</option>
  <option value="RM-AT">Athens</option>
  <option value="DL-MB">Mumbai</option>
  
  
</select>

<br />


Type of Trip
<select>
  <option value="Select">Select here</option>
  <option value ="one">One Way Trip</option>
  <option value ="Round">Round Trip</option>
</select>

<br />


Sort Flights
<select>
  <option value="Select">Select here</option>
  <option value ="price">Price</option>
  <option value ="take-off time">Take off Time</option>
    <option value ="landing time">Landing Time</option>
    <option value ="duration of flight">Duration of flight</option>
</select>

<br />

Filter All of the Flights:
<select>
  <option value="Select">Select here</option>
  <option value ="price">Price</option>
  <option value ="take-off time">Take off Time</option>
    <option value ="number of stops">Number of stops</option>
    <option value ="airline">Airline</option>
    <option value ="duration of flight">Landing Time</option>
    
</select>

<br />
Flexible Days: 
<select>
  <option value="S">-</option>
  <option value ="1">1</option>
    <option value ="2">2</option>
    <option value ="3">3</option>
</select>

<div style = "display: block;">
<button><a href='searchFlights.jsp'>Search Flights</a><button>

<br />


<button><a href='filterAll.jsp'>Filter All Flights</a><button>





<br />

<button><a href='logout.jsp'>Log out</a><button>

<br />


<button><a href = "qa.jsp">Questions and Answers</a><button>

<br />


<button><a href = "reservedFlights.jsp">Current Flights Reserved</a><button>

<button><a href = "pastFlights.jsp">Past Flights</a><button>

<button><a href = "futureFlights.jsp">Future Flights</a><button>
</div>
<%
	}
%>