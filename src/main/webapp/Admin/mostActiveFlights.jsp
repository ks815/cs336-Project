<%@ page import="java.sql.*" %>

<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass","root",
        	    "kevin");

        String query = "SELECT TicketBuys.CustomerID, Customer.customerName AS CustomerName, SUM(TicketBuys.BookingFee) AS TotalRevenue FROM TicketBuys JOIN Customer ON TicketBuys.CustomerID = Customer.CustomerID GROUP BY TicketBuys.CustomerID, Customer.customerName ORDER BY TotalRevenue DESC LIMIT 1";
        PreparedStatement pstmt = con.prepareStatement(query);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int customerID = rs.getInt("CustomerID");
            String customerName = rs.getString("CustomerName");
            double totalRevenue = rs.getDouble("TotalRevenue");

            out.println("Customer ID: " + customerID + " | Customer Name: " + customerName + " | Total Revenue: $" + totalRevenue);
        }

        rs.close();
        pstmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>