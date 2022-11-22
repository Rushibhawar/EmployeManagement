<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Management</title>

	<!-- CSS -->
	<link rel="stylesheet" href="css/style.css">
	
	<!--Google Fonts -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;1,400&display=swap" rel="stylesheet">

	<!-- Javascript -->
	<script type="text/javascript" src="javascript/script.js"></script>
	
</head>
<body>
	<%
		session.setMaxInactiveInterval(15);
	%>
	<form action="SaveServlet" method="post">
		<div class="employee-header">
				<h1>Employee Details</h1>
		</div>
		<div class="emp-card-holder">
			<div class="emp-card">
				<div class="search-and-add"> 
					<input type="search" placeholder="Search" id="search-box" onkeyup="searchFunction()">
					<button type="button" id="add-btn" onclick="displayPopup()"><a>Add</a></button>
				</div>
				
				<!-- Add model -->
				<div class="modal">
					<div class="add-modal">
						<div class="modal-content">
							<div class="black-modal">
								<div class="add-heading"><h2>Add Employee</h2></div>
								
								<!-- Select employee id -->
								<div class="employee-id">
									<label for="emp-id">Employee ID</label>
									<select name="empid" id="emp-id" onchange="getSelectedeid(this)">
										<option ><%=session.getAttribute("employee_id") %></option>
										<%@ include file="loadid.jsp" %>
									</select>
								</div>
								
								
								<!-- Employee name -->
								<div class="emp-name">
									<span>Employee Name</span> <input type="text" class="employee-name" name="employeename" value="<%=session.getAttribute("employee_name") %>" readonly="readonly">
								</div>
								
								<!-- Year of experience -->
								<div class="yoe">
									<span>Year of Experience</span> <input type="text" class="year-of-experience" name="yearofexperience" placeholder="Enter experience">
								</div>
								
								<!-- Designation -->
								<div class="emp-designation">
									<span>Designation</span> <input type="text" class="designation" name="designation" placeholder="Enter designation">
								</div>
								
								<!-- save and cancel buttons -->
								<div class="save-cancel-btn">
									<button type="submit" id="save-btn">Save</button>
									<button type="button" id="cancel-btn" onclick="closeModal()">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="emp-details" id="details">
					<div class="emp-grid-container" id="details-container">
					  <div class="grid-heading">Eid</div>
					  <div class="grid-heading">EName</div>
					  <div class="grid-heading">DOJ</div>  
					  <div class="grid-heading">YOE</div>
					  <div class="grid-heading">Designation</div>
					  
					  <%
					 	
					  	query = "SELECT * FROM empdetails";
						pstmt = con.prepareStatement(query);
						set = pstmt.executeQuery();
						
						while (set.next()) {
							%>
								<div><%=set.getInt("eid") %></div>
								<div><%=set.getString("ename") %></div>
								<div><%=set.getDate("doj") %></div>
								<div><%=set.getInt("yoe") %></div>
								<div><%=set.getString("designation") %></div>
							<%
						}
					  %>
					  
					</div>
				</div>
			</div>
		</div>
	</form>
	
	
<script type="text/javascript">
	var Msg ='<%=session.getAttribute("getAlert")%>';
		if (Msg == "Yes") {
			alert("Employee added successfully");
		}
		
		
		        
</script>									
	
</body>
</html>