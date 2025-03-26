<%@ page import="java.sql.*" %>

<%
    String inputMonth = request.getParameter("inputMonth");

    try {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass","root",
    "kevin");


        String query = "SELECT YEAR(FlightOperates.ArrivalTime) AS Year, MONTH(FlightOperates.ArrivalTime) AS Month, SUM(TicketBuys.BookingFee) AS TotalSales FROM TicketBuys JOIN FlightOperates ON TicketBuys.FlightNumber = FlightOperates.FlightNumber WHERE YEAR(FlightOperates.ArrivalTime) = YEAR(NOW()) AND MONTH(FlightOperates.ArrivalTime) = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, inputMonth);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int year = rs.getInt("Year");
            int month = rs.getInt("Month");
            double totalSales = rs.getDouble("TotalSales");

            out.println("Year: " + year + " | Month: " + month + " | Total Sales: $" + totalSales);
        }

        rs.close();
        pstmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
