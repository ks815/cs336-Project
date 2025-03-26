<%@ page import="java.sql.*" %>
<%
    String userid = request.getParameter("username");
    String pwd = request.getParameter("password");

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass", "root", "kevin");
        st = con.createStatement();
        rs = st.executeQuery("SELECT FROM users WHERE username='" + userid + "' AND password='" + pwd + "'");

        if (rs.next()) {
            session.setAttribute("user", userid);
            out.println("Welcome " + userid);
            out.println("<a href='logout.jsp'>Log out</a>");

            String departFrom = request.getParameter("departFrom");
            String destinationTo = request.getParameter("destinationTo");
            String tripType = request.getParameter("tripType");
            String sortCriteria = request.getParameter("sortCriteria");
            String filterCriteria = request.getParameter("filterCriteria");
            String flexibleDays = request.getParameter("flexibleDays");

            String sqlQuery = "SELECT * FROM FlightOperates WHERE ";

            if (departFrom != null && !departFrom.equals("Select")) {
                sqlQuery += "DepartureAirport = '" + departFrom + "' AND ";
            }

            if (destinationTo != null && !destinationTo.equals("Select")) {
                sqlQuery += "DestinationAirport = '" + destinationTo + "' AND ";
            }

            if (tripType != null && !tripType.equals("Select")) {
                sqlQuery += "TripType = '" + tripType + "' AND ";
            }

            if (sortCriteria != null && !sortCriteria.equals("Select")) {
                switch (sortCriteria) {
                    case "price":
                        sqlQuery += " ORDER BY BookingFee";
                        break;
                    case "take-off time":
                        sqlQuery += " ORDER BY DepartureTime";
                        break;
                    case "landing time":
                        sqlQuery += " ORDER BY ArrivalTime";
                        break;
                    case "duration of flight":
                        sqlQuery += " ORDER BY TIMEDIFF(ArrivalTime, DepartureTime)";
                        break;
                }
            }
            
            if (filterCriteria != null && !filterCriteria.equals("Select")) {
                sqlQuery += "Filter By = '" + filterCriteria + "' AND ";
            }
            
            if (flexibleDays != null && !flexibleDays.equals("Select")) {
                sqlQuery += "# of flexible days = '" + flexibleDays + "' AND ";
            }

            sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 5);

            response.sendRedirect("../searchFlights.jsp");
        } else {
            out.println("Invalid password <a href='login.jsp'>try again</a>");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>