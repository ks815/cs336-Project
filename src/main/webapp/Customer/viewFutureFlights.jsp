<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%
    String username = (String) session.getAttribute("user");

    if (username == null) {
        response.sendRedirect("login.jsp");
    } else {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass","root",
        "kevin");


            String sqlQuery = "SELECT * FROM FlightOperates WHERE ArrivalTime > NOW() ORDER BY DepartureTime";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = pstmt.executeQuery();

            List<Map<String, Object>> futureFlights = new ArrayList<>();

            while (rs.next()) {
                Map<String, Object> flightDetails = new HashMap<>();
                flightDetails.put("FlightNumber", rs.getInt("FlightNumber"));
                flightDetails.put("DepartureAirport", rs.getString("DepartureAirport"));
                flightDetails.put("DestinationAirport", rs.getString("DestinationAirport"));
                flightDetails.put("DepartureTime", rs.getTimestamp("DepartureTime"));
                flightDetails.put("ArrivalTime", rs.getTimestamp("ArrivalTime"));

                futureFlights.add(flightDetails);
            }

            for (Map<String, Object> flight : futureFlights) {
                out.println("<p>Flight Number: " + flight.get("FlightNumber") + "</p>");
                out.println("<p>Departure Airport: " + flight.get("DepartureAirport") + "</p>");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>
