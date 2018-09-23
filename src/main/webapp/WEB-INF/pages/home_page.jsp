<%@page isELIgnored="false"%>
<head>

<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript"
	src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body bgcolor="cyan">

	<a class="btn btn-default" href="list_emps.htm" role="button">getEmployeeList</a>
	
		<!-- Standard button -->
<a type="button" class="btn btn-default" href="list_custs.htm" >Get_Customer_List</a>

<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
<a type="button" class="btn btn-primary" href="list_studs.htm">Get_Student_list</a>

<!-- Indicates a successful or positive action -->
<a type="button" class="btn btn-success" href="searchEmp.htm">Search_Employee</a>

<!-- Contextual button for informational alert messages -->
<a type="button" class="btn btn-info" href="searchStud.htm">Search_Student</a>

<!-- Indicates caution should be taken with this action -->
<a type="button" class="btn btn-warning" href="searchCust.htm">Search_Customer</a>

<!-- Indicates a dangerous or potentially negative action -->
<a type="button" class="btn btn-danger" href="upload.htm">Uplode File</a>

<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
<a type="button" class="btn btn-link" href="filedownload.htm">Download File</a>

<a class="btn btn-success" href="welcome.htm">Logout</a>

	<h3 style="color: maroon">&nbsp;${wMsg}</h3>

	<h1 style="color: red; text-align: center">Welcome To The
		Website...</h1>

	<h4>
		<a href="list_emps.htm">getEmployeeList</a>&nbsp;&nbsp; <a
			href="list_custs.htm">getCustomerList</a>&nbsp;&nbsp; <a
			href="list_studs.htm">getStudentList</a>&nbsp;&nbsp; <a
			href="searchEmp.htm">searchEmployee</a>&nbsp;&nbsp; <a
			href="searchStud.htm">searchStudent</a>&nbsp;&nbsp; <a
			href="searchCust.htm">searchCustomer</a>&nbsp;&nbsp; <a
			href="upload.htm">Upload File Here</a>&nbsp;&nbsp; <a
			href="filedownload.htm">Download File Here</a>&nbsp;&nbsp; <br>
		<br> <a href="welcome.htm">Logout</a>
	</h4>
	<!-- <br><a href="welcome.htm">Welcome Page</a> -->
</body>