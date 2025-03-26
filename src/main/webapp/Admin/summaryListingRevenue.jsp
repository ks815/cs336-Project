<%@ page import="java.sql.*" %>

<%
    String flightNumber = request.getParameter("flightnum");
    String airlineID = request.getParameter("airline");
    String customerID = request.getParameter("cusID");

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass","root",
        	    "kevin");

        String query = "SELECT TicketBuys.FlightNumber, FlightOperates.DepartureAirport, FlightOperates.DestinationAirport, FlightOperates.AirlineID, SUM(TicketBuys.BookingFee) AS TotalRevenue FROM TicketBuys JOIN FlightOperates ON TicketBuys.FlightNumber = FlightOperates.FlightNumber WHERE TicketBuys.FlightNumber = ? OR FlightOperates.AirlineID = ? OR TicketBuys.CustomerID = ? GROUP BY TicketBuys.FlightNumber, FlightOperates.DepartureAirport, FlightOperates.DestinationAirport, FlightOperates.AirlineID";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, flightNumber);
        pstmt.setString(2, airlineID);
        pstmt.setString(3, customerID);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int flightNum = rs.getInt("FlightNumber");
            String departureAirport = rs.getString("DepartureAirport");
            String destinationAirport = rs.getString("DestinationAirport");
            String airline = rs.getString("AirlineID");
            double totalRevenue = rs.getDouble("TotalRevenue");

            out.println("Flight Number: " + flightNum + " | Departure: " + departureAirport + " | Destination: " + destinationAirport + " | Airline: " + airline + " | Total Revenue: $" + totalRevenue);
        }

        rs.close();
        pstmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
