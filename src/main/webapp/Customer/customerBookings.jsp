<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    String userName = request.getParameter("username"); // Replace this with the actual username
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass", "root", "kevin");

        String sqlQuery = "SELECT * FROM bookings WHERE user_id = ?";
        pstmt = con.prepareStatement(sqlQuery);
        pstmt.setString(1, userName);

        resultSet = pstmt.executeQuery();

        out.println("<html><head><title>Booking Confirmation</title></head><body>");

        if (resultSet.next()) {
            out.println("<p>User has booked a flight!</p>");
        } else {
            out.println("<p>User has not booked a flight.</p>");
        }

        out.println("</body></html>");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>