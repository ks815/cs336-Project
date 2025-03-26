<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    String username = (String) session.getAttribute("user");

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
    	Class.forName("com.mysql.jdbc.Driver");
    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass","root",
    "kevin");

        String sqlQuery = "SELECT TicketBuys.*, FlightOperates.DepartureAirport, FlightOperates.DestinationAirport, FlightOperates.DepartureTime, FlightOperates.ArrivalTime " +
                          "FROM TicketBuys " +
                          "JOIN FlightOperates ON TicketBuys.FlightNumber = FlightOperates.FlightNumber " +
                          "JOIN Users ON TicketBuys.CustomerID = Users.user_id " +
                          "WHERE Users.username = ? AND FlightOperates.ArrivalTime < NOW()";

        pstmt = con.prepareStatement(sqlQuery);
        pstmt.setString(1, username);

        rs = pstmt.executeQuery();

        while (rs.next()) {
            out.println("<p>Flight Number: " + rs.getInt("FlightNumber") + "</p>");
            out.println("<p>Departure Airport: " + rs.getString("DepartureAirport") + "</p>");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>