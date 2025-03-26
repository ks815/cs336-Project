<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    int flightNumber = Integer.parseInt(request.getParameter("flightNumber"));
    int customerID = Integer.parseInt(request.getParameter("customerID"));

    Connection con = null;
    PreparedStatement pstmt = null;

    try {
    	Class.forName("com.mysql.jdbc.Driver");
    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass","root",
    "kevin");

        String sqlQuery = "INSERT INTO WaitingList (FlightNumber, CustomerID) VALUES (?, ?)";
        pstmt = con.prepareStatement(sqlQuery);
        pstmt.setInt(1, flightNumber);
        pstmt.setInt(2, customerID);

        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected > 0) {
            out.println("<p>You have been added to the waiting list for Flight " + flightNumber + ".</p>");
        } else {
            out.println("<p>Failed to add to the waiting list. Please try again later.</p>");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>