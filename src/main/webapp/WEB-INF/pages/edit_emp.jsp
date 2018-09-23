<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1 style="color: red; text-align: center">Update The Employee
	Details</h1>

<form:form method="post" commandName="empCmd">
    <table border="1"><tr><td>
  
     Employee Id::</td><td><form:input path="eid" disabled="true"/></td></tr>
	<tr><td>                                    
	 Employee Name::</td><td><form:input path="ename" /><form:errors cssStyle="color:red" path="ename"/></td></tr>
	<tr><td>                                 
	 Employee Age::</td><td><form:input path="age" /><form:errors path="age"/></td></tr>
	<tr><td>                                     
	 Address::</td><td><form:input path="address" /></td></tr>
	<tr><td>                                      
	 Department::</td><td><form:input path="department" /></td></tr>
	<tr><td>                                      
	 City::</td><td><form:input path="city" /></td></tr>
	<tr><td>                                           
	 State::</td><td><form:input path="state" /></td></tr>
	<tr><td>                                             
	 Pincode::</td><td><form:input path="pincode" /></td></tr>
	<tr><td colspan="2" align="center">
	<input type="submit" value="Edit" /></td></tr>
	</table>
</form:form>
<br>
<h3 style="color:red">
${result}
</h3>
<br>
<a href='list_emps.htm'>listStudents</a>