<%@ page import="java.sql.*" %>

<%
    String action = request.getParameter("action");

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass", "root", "kevin");

        if (action.equals("addAircraft")) {
            String airlineID = request.getParameter("airlineID");
            int aircraftID = Integer.parseInt(request.getParameter("aircraftID")); 

            String addAircraftQuery = "INSERT INTO AircraftOwns (AirlineID, AircraftID) VALUES (?, ?)";
            PreparedStatement addAircraftStmt = con.prepareStatement(addAircraftQuery);

            addAircraftStmt.setString(1, airlineID);
            addAircraftStmt.setInt(2, aircraftID);

            int rows = addAircraftStmt.executeUpdate();

            if (rows > 0) {
                out.println("Aircraft information added successfully!");
            } else {
                out.println("Failed to add aircraft information.");
            }

            addAircraftStmt.close();
        } else if (action.equals("editAircraft")) {
        	String airlineID = request.getParameter("airlineID");
            int aircraftID = Integer.parseInt(request.getParameter("aircraftID")); 

            String newAirlineID = request.getParameter("newAirlineID");

            String editAircraftQuery = "UPDATE AircraftOwns SET AirlineID = ? WHERE AircraftID = ?";
            PreparedStatement editAircraftStmt = con.prepareStatement(editAircraftQuery);

            editAircraftStmt.setString(1, newAirlineID);
            editAircraftStmt.setInt(2, aircraftID);

            int rows = editAircraftStmt.executeUpdate();

            if (rows > 0) {
                out.println("Aircraft information updated successfully!");
            } else {
                out.println("Failed to update aircraft information.");
            }

            editAircraftStmt.close();
        } else if (action.equals("deleteAircraft")) {
        	int aircraftID = Integer.parseInt(request.getParameter("aircraftID")); 

            String deleteAircraftQuery = "DELETE FROM AircraftOwns WHERE AircraftID = ?";
            PreparedStatement deleteAircraftStmt = con.prepareStatement(deleteAircraftQuery);

            deleteAircraftStmt.setInt(1, aircraftID);

            int rows = deleteAircraftStmt.executeUpdate();

            if (rows > 0) {
                out.println("Aircraft information deleted successfully!");
            } else {
                out.println("Failed to delete aircraft information.");
            }

            deleteAircraftStmt.close();
        } else if (action.equals("addAirport")) {
        	String airportID = request.getParameter("airportID");

            String addAirportQuery = "INSERT INTO Airport (ID) VALUES (?)";
            PreparedStatement addAirportStmt = con.prepareStatement(addAirportQuery);

            addAirportStmt.setString(1, airportID);

            int rows = addAirportStmt.executeUpdate();

            if (rows > 0) {
                out.println("Airport information added successfully!");
            } else {
                out.println("Failed to add airport information.");
            }

            addAirportStmt.close();
        } else if (action.equals("editAirport")) {
        	String oldAirportID = request.getParameter("oldAirportID");
            String newAirportID = request.getParameter("newAirportID");

            String editAirportQuery = "UPDATE Airport SET ID = ? WHERE ID = ?";
            PreparedStatement editAirportStmt = con.prepareStatement(editAirportQuery);

            editAirportStmt.setString(1, newAirportID);
            editAirportStmt.setString(2, oldAirportID);

            int rows = editAirportStmt.executeUpdate();

            if (rows > 0) {
                out.println("Airport information edited successfully!");
            } else {
                out.println("Failed to edit airport information.");
            }

            editAirportStmt.close();
        } else if (action.equals("deleteAirport")) {
        	String airportID = request.getParameter("airportID");

            String deleteAirportQuery = "DELETE FROM Airport WHERE ID = ?";
            PreparedStatement deleteAirportStmt = con.prepareStatement(deleteAirportQuery);

            deleteAirportStmt.setString(1, airportID);

            int rows = deleteAirportStmt.executeUpdate();

            if (rows > 0) {
                out.println("Airport information deleted successfully!");
            } else {
                out.println("Failed to delete airport information.");
            }

            deleteAirportStmt.close();
        } else if (action.equals("addFlight")) {
        	String flightNumber = request.getParameter("flightNumber");
            String arrivalTime = request.getParameter("arrivalTime");
            String departureTime = request.getParameter("departureTime");
            String departureAirport = request.getParameter("departureAirport");
            String destinationAirport = request.getParameter("destinationAirport");
            String airlineID = request.getParameter("airlineID");

            String addFlightQuery = "INSERT INTO FlightOperates (FlightNumber, ArrivalTime, DepartureTime, DepartureAirport, DestinationAirport, AirlineID) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement addFlightStmt = con.prepareStatement(addFlightQuery);

            addFlightStmt.setString(1, flightNumber);
            addFlightStmt.setString(2, arrivalTime);
            addFlightStmt.setString(3, departureTime);
            addFlightStmt.setString(4, departureAirport);
            addFlightStmt.setString(5, destinationAirport);
            addFlightStmt.setString(6, airlineID);

            int rows = addFlightStmt.executeUpdate();
        } else if (action.equals("editFlight")) {
        	String flightNumber = request.getParameter("flightNumber");
            String arrivalTime = request.getParameter("arrivalTime");
            String departureTime = request.getParameter("departureTime");
            String departureAirport = request.getParameter("departureAirport");
            String destinationAirport = request.getParameter("destinationAirport");
            String airlineID = request.getParameter("airlineID");

            String editFlightQuery = "UPDATE FlightOperates SET ArrivalTime = ?, DepartureTime = ?, DepartureAirport = ?, DestinationAirport = ?, AirlineID = ? WHERE FlightNumber = ?";
            PreparedStatement editFlightStmt = con.prepareStatement(editFlightQuery);

            editFlightStmt.setString(1, arrivalTime);
            editFlightStmt.setString(2, departureTime);
            editFlightStmt.setString(3, departureAirport);
            editFlightStmt.setString(4, destinationAirport);
            editFlightStmt.setString(5, airlineID);
            editFlightStmt.setString(6, flightNumber);

            int rows = editFlightStmt.executeUpdate();

            if (rows > 0) {
                out.println("Flight information updated successfully!");
            } else {
                out.println("Failed to update flight information.");
            }

            editFlightStmt.close();
        } else if (action.equals("deleteFlight")) {
        	String flightNumber = request.getParameter("flightNumber");

            String deleteFlightQuery = "DELETE FROM FlightOperates WHERE FlightNumber = ?";
            PreparedStatement deleteFlightStmt = con.prepareStatement(deleteFlightQuery);

            deleteFlightStmt.setString(1, flightNumber);

            int rows = deleteFlightStmt.executeUpdate();

            if (rows > 0) {
                out.println("Flight information deleted successfully!");
            } else {
                out.println("Failed to delete flight information.");
            }

            deleteFlightStmt.close();
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>