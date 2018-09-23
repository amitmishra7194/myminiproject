<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<h1 style="color: red">Search Employee</h1>


<form action="searchEmp.htm" method="post">
	<table border="1">
		<tr>
			<td>EID::</td>
			<td><input type="text" name="eid"></td>
		</tr>
		<tr>
		<td>ENAME::</td>
		<td><input type="text" name="ename"></td></tr>
		<tr>
		<td> AGE::</td>
		<td><input type="text" name="age"></td></tr>
		<tr><td> ADDRESS::</td><td>
		<input type="text" name="address"></td></tr>
		<tr>
		<td> Department::</td>
		<td>
		<input type="text" name="department"></td></tr>
		<tr><td> CITY::</td><td>
		<input type="text" name="city"></td></tr>
		<tr><td>STATE::</td><td>
		<input type="text" name="state"></td></tr>
		<tr><td> PINCODE::</td><td>
		<input type="text" name="pincode"></td></tr>
	    <tr><td align="center">
		<input type="submit" value="Search"></td></tr>
	</table>
</form>
<br>
<a href='list_emps.htm'>listEmployees</a>

<!-- Spring Supplied tags -->
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%> --%>

<%-- <form:form commandName="empCmd" method="post"> --%>
<%-- EID::<f:input path="eid"/><br> --%>
<%-- ENAME::<f:input path="ename"/><br> --%>
<%-- AGE::<f:input path="age"/><br> --%>
<%-- ADDRESS::<f:input path="address"/><br> --%>
<%-- Department::<f:input path="department"/><br> --%>
<%-- CITY::<f:input path="city"/><br> --%>
<%-- STATE::<f:input path="state"/><br> --%>
<%-- PINCODE::<f:input path="pincode"/><br> --%>
<!-- <!-- <input type="submit" value="Search"> -->
<%-- </form:form> --%>