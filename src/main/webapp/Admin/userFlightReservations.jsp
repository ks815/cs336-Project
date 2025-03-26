<%@ page import="java.sql.*" %>

<%
    String flightNumber = request.getParameter("flightnum");
    String customerName = request.getParameter("cusName");

    try {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass","root",
    "kevin");

        String query = "SELECT TicketBuys.TicketNumber, TicketBuys.FlightNumber, FlightOperates.DepartureAirport, FlightOperates.DestinationAirport, TicketBuys.PassengerName AS CustomerName, TicketBuys.BookingFee FROM TicketBuys JOIN FlightOperates ON TicketBuys.FlightNumber = FlightOperates.FlightNumber WHERE TicketBuys.FlightNumber = ? OR TicketBuys.PassengerName = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, flightNumber);
        pstmt.setString(2, customerName);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int ticketNumber = rs.getInt("TicketNumber");
            int flightNum = rs.getInt("FlightNumber");
            String departureAirport = rs.getString("DepartureAirport");
            String destinationAirport = rs.getString("DestinationAirport");
            String customer = rs.getString("CustomerName");
            double bookingFee = rs.getDouble("BookingFee");

            out.println("Ticket Number: " + ticketNumber + " | Flight Number: " + flightNum + " | Departure: " + departureAirport + " | Destination: " + destinationAirport + " | Customer: " + customer + " | Booking Fee: $" + bookingFee);
        }

        rs.close();
        pstmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
