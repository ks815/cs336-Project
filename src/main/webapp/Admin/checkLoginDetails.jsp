<%@ page import ="java.sql.*" %>
<%
	String userid = request.getParameter("username");
	String pwd = request.getParameter("password");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userpass","root",
"kevin");
	Statement st = con.createStatement();
	ResultSet rs;
	rs = st.executeQuery("select * from users where username='" + userid + "' and password='" + pwd
+ "'");
	if (rs.next()) {
		session.setAttribute("user", userid); // the username will be stored in the session
		out.println("welcome " + userid);
		out.println("<a href='logout.jsp'>Log out</a>");
		response.sendRedirect("success.jsp");
} else {
	out.println("Invalid password <a href='login.jsp'>try again</a>");
}
%>