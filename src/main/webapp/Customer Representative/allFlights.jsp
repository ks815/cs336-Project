<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String airportCodeParam = request.getParameter("airportCode");

    if (airportCodeParam != null) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass", "root", "kevin");

            String flightsQuery = "SELECT FlightNumber, DepartureTime, ArrivalTime, DepartureAirport, DestinationAirport, AirlineID FROM FlightOperates WHERE DepartureAirport = ? OR DestinationAirport = ?";
            PreparedStatement flightsStmt = con.prepareStatement(flightsQuery);

            flightsStmt.setString(1, airportCodeParam);
            flightsStmt.setString(2, airportCodeParam);

            ResultSet flightsResult = flightsStmt.executeQuery();

            out.println("<html><head><title>Flights for Airport " + airportCodeParam + "</title></head><body>");
            out.println("<h1>Flights for Airport " + airportCodeParam + "</h1>");

            while (flightsResult.next()) {
                int flightNumber = flightsResult.getInt("FlightNumber");
                Timestamp departureTime = flightsResult.getTimestamp("DepartureTime");
                Timestamp arrivalTime = flightsResult.getTimestamp("ArrivalTime");
                String departureAirport = flightsResult.getString("DepartureAirport");
                String destinationAirport = flightsResult.getString("DestinationAirport");
                String airlineID = flightsResult.getString("AirlineID");

                out.println("<p>Flight Number: " + flightNumber + "</p>");
                out.println("<p>Departure Time: " + departureTime + "</p>");
                out.println("<p>Arrival Time: " + arrivalTime + "</p>");
                out.println("<p>Departure Airport: " + departureAirport + "</p>");
                out.println("<p>Destination Airport: " + destinationAirport + "</p>");
                out.println("<p>Airline ID: " + airlineID + "</p>");
            }

            out.println("</body></html>");

            flightsStmt.close();
            flightsResult.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        out.println("Airport code parameter is required.");
    }
%>