<%@ page import="java.sql.Connection,com.helper.ConnectionProvider,com.entities.Employee,
java.sql.PreparedStatement,java.sql.ResultSet"%>

<%
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection con = ConnectionProvider.createConnection();
	String query = "SELECT eid FROM empdetails";
	PreparedStatement pstmt = con.prepareStatement(query);
	ResultSet set = pstmt.executeQuery();
	
	while (set.next()) {
		%>
			<option value="<%=set.getInt("eid") %>"><%=set.getInt("eid") %></option>
		<%
	}

	
%>
