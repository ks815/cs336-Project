<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String flightNumberParam = request.getParameter("flightNumber");

    if (flightNumberParam != null) {
        int flightNumber = Integer.parseInt(flightNumberParam);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass", "root", "kevin");

            String passengersQuery = "SELECT Passengers FROM WaitingRoom WHERE FlightNumber = ?";
            PreparedStatement passengersStmt = con.prepareStatement(passengersQuery);

            passengersStmt.setInt(1, flightNumber);
            ResultSet passengersResult = passengersStmt.executeQuery();

            out.println("<html><head><title>Passengers on Waiting List</title></head><body>");
            out.println("<h1>Passengers on Waiting List for Flight " + flightNumber + "</h1>");

            while (passengersResult.next()) {
                String passengers = passengersResult.getString("Passengers");
                out.println("<p>" + passengers + "</p>");
            }

            out.println("</body></html>");

            passengersStmt.close();
            passengersResult.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        out.println("Flight number parameter is required.");
    }
%>