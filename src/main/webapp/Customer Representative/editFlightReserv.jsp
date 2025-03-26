<%@ page import="java.sql.*" %>

<%
    String ticketNum = request.getParameter("ticketNum");
    String custID = request.getParameter("custID");
    double fee = Double.parseDouble(request.getParameter("fee")); // Assuming fee is provided from form

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass", "root", "kevin");

        String query = "UPDATE TicketBuys SET BookingFee = ? WHERE TicketNumber = ? AND CustomerID = ?";
        PreparedStatement pstmt = con.prepareStatement(query);

        pstmt.setDouble(1, fee);
        pstmt.setString(2, ticketNum);
        pstmt.setString(3, custID);

        int rows = pstmt.executeUpdate();

        if (rows > 0) {
            out.println("Flight reservation updated successfully!");
        } else {
            out.println("Failed to update flight reservation.");
        }

        pstmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
