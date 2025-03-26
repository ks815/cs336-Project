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
	response.sendRedirect("login.jsp");
	

%>