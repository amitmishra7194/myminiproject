<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%-- <c:choose>
	<c:when test="${!empty listEmployeeDTO}">
		<h1 style="color: red">Employee Details</h1> &nbsp;&nbsp;&nbsp;
		<h3 style="color:maroon;">
		${result} 
		</h3>
		<table border="1" width="100%" height="100%">
			<tr bgcolor="cyan">
				<th>Eid</th>
				<th>Ename</th>
				<th>AGE</th>
				<th>Address</th>
				<th>Department</th>
				<th>City</th>
				<th>State</th>
				<th>Pincode</th>
				<th>Modify</th>
				<th>RemoveEmployee</th>
			</tr>

			<c:forEach var="listEmployeeDTO1" items="${listEmployeeDTO}">
				<tr>
					<td>${listEmployeeDTO1.eid}</td>
					<td>${listEmployeeDTO1.ename}</td>
					<td>${listEmployeeDTO1.age}</td>
					<td>${listEmployeeDTO1.address}</td>
					<td>${listEmployeeDTO1.department}</td>
					<td>${listEmployeeDTO1.city}</td>
					<td>${listEmployeeDTO1.state}</td>
					<td>${listEmployeeDTO1.pincode}</td>
                    <td><a href="edit_emp.htm?eid=${listEmployeeDTO1.eid}">Edit</a></td>
                    <td><a href="delete_emp.htm?eid=${listEmployeeDTO1.eid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>

	<c:otherwise>
		<h1 style="color: red">
			<b> No records found</b>
		</h1>
	</c:otherwise>
</c:choose>
<h3><a href="insert_emps.htm">InsertNewEmployee</a>&nbsp;&nbsp;&nbsp;<a href="home_page.htm">Home</a></h3>

 --%>










<!-- UI View -->

<!-- <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1"> -->

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table {
	border: 1px solid #edeaea;
	border-collapse: collapse;
	font-family: lucida;
	width: 90%;
	margin: 0px auto;
}

table tr:nth-child(odd) {
	background: #edeaea;
}

tr {
	height: 40px;
	line-height: 40px;
	text-transform: capitalize;
	text-align: center
}

.update {
	height: 50px;
	padding: 5px 20px;
	border-radius: 5px;
	color: #fff;
	background: #07508c;
	text-align: center;
	text-decoration: none
}

.update:hover {
	text-decoration: underline;
	color: #fff
}

.delete:hover {
	text-decoration: underline;
	color: #fff
}

tr:hover {
	color: #c61003;
	cursor: pointer;
}

.delete {
	height: 35px;
	padding: 5px 20px;
	border-radius: 5px;
	color: #fff;
	background: #c61003;
	text-align: center;
	text-decoration: none
}

.btn1 {
	font-size: 20px;
	margin: 20px auto;
	text-align: center;
	color: #fff;
	display: block;
	text-decoration: none;
	width: 300px;
	height: 40px;
	line-height: 40px;
	background: #5a8e07;
}

.btn1:hover {
	outline: 2px solid #5a8e07;
	background: #fff;
	color: #5a8e07;
	text-decoration: none;
}

#menu {
	height: 50px;
	max-width: 100%;
	background: #113d84
}

#menu ul li {
	display: inline-block;
	height: 50px;
	line-height: 50px;
	width: auto;
	margin-left: 10px;
	padding: 0px 10px 0px 10px;
	text-align: center
}

#menu ul li:hover {
	background: red;
	text-decoration: none;
	color: #fff
}

#menu ul li a {
	color: #fff;
	text-decoration: none;
	font-size: 19px
}
</style>
<script>
	function editRow(index){
		alert("selected index :"+index);
	};
	</script>
</head>
<body>

	<div id="menu">
		<ul>
			<li><a href="home_page.htm">Home</a></li>
			<li><a href="insert_emps.htm">InsertNewEmployee</a></li>
			<li><a href="searchEmp.htm">SearchEmployee</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<li><a href="upload.htm">Upload Photo</a>
		</ul>
	</div>
	<c:choose>
		<c:when test="${!empty listEmployeeDTO}">
			<div class="alert alert-success alert-dismissable">
				<!--     <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a> -->
				<center>
					<strong>${insert_result}</strong>
				</center>
				<h3 style="color: maroon;">${result}</h3>
			</div>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>


	<c:choose>
		<c:when test="${!empty listEmployeeDTO}">

			<table>
				<caption>
					<h1
						style="color: #113d84; text-align: left; width: 320px; float: left">All
						Employee Details</h1>
				</caption>
				<tr
					style="background: #3a3a3a; color: white; height: 40px; line-height: 40px; text-transform: capitalize; font-size: 18px">
					<th width="120" style="text-align: center">Eid</th>
					<th align="left">Ename</th>
					<th align="left">Age</th>
					<th align="left">Address</th>
					<th align="left">Department</th>
					<th align="left">city</th>
					<th align="left">state</th>
					<th align="left">Pincode</th>
					<th colspan=2>Action</th>
				</tr>
				<c:forEach var="dto" items="${listEmployeeDTO}" varStatus="loop">
					<tr id="row${loop.index}">

						<td onclick="alert(${loop.index})">${dto.eid}</td>
						<td align="left">${dto.ename}</td>
						<td align="left">${dto.age}</td>
						<td align="left">${dto.address}</td>
						<td align="left"><img
							src="http://i.stack.imgur.com/nGbfO.png" width="9" height="12">
							${dto.department}</td>
						<td align="left">${dto.city}</td>
						<td align="left">${dto.state}</td>
						<td align="left">${dto.pincode}</td>
						<td width="120px"><a
							href="javascript:editRow(${loop.index});" class="update">update</a></td>
						<%-- <td width="120px"><a href="edit_emp.htm?eid=${dto.eid}" class="update">update</a></td> --%>
						<td width="120px"><a href="delete_emp.htm?eid=${dto.eid}"
							class="delete">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red">
				<b> No records found</b>
			</h1>
		</c:otherwise>
	</c:choose>
	<a href="insert_emps.htm" class="btn1">Register New Employee </a>


	<hr>
	<p style="text-align: center">
		Designed By : <b>Amit Mishra</b>
	</p>
	
	
	</body>
	</html>