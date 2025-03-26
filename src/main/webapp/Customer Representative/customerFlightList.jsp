<%@ page import="java.sql.*" %>

<%
    String cusname = request.getParameter("cusname");
    String fnum = request.getParameter("fnum");
    double fee = 200.00;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass", "root", "kevin");

        String query = "INSERT INTO TicketBuys (TicketNumber, PassengerName, BookingFee, SeatNumber, FlightClass, CustomerID) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);

        pstmt.setString(1, "ticketNum");
        pstmt.setString(2, "passengerName");
        pstmt.setDouble(3, fee);
        pstmt.setString(4, "seatNum");
        pstmt.setString(5, "class");
        pstmt.setString(6, "custID");

        int rows = pstmt.executeUpdate();

        if (rows > 0) {
            out.println("Reservation made successfully!");
        } else {
            out.println("Failed to make a reservation.");
        }

        pstmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
