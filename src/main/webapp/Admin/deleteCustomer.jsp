<%@ page import="java.sql.*" %>

<%
    String custID = request.getParameter("custID");
    String custName = request.getParameter("custName");

    try {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass","root",
    "kevin");

        String query = "DELETE FROM Customer WHERE CustomerID = ? AND customerName = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, custID);
        pstmt.setString(2, custName);

        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected > 0) {
            response.sendRedirect("delete1.jsp");
        }

        pstmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
