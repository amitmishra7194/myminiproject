<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1 style="color: red; text-align: center">Update The Customer
	Details</h1>

<form:form method="post" commandName="custCmd">
     Employee Id::<form:input path="cid" disabled="true"/>
	<br>                                      
	 Employee Name::<form:input path="cname" />
	<br>                                 
	 Employee Age::<form:input path="cage" />
	<br>                                     
	 Address<form:input path="address" />
	<br>                                                                            
	 City<form:input path="city" />
	<br>                                           
	 State<form:input path="state" />
	<br>                                             
	 Pincode<form:input path="pincode" />
	<br>
	<input type="submit" value="Edit" />
</form:form>
<br>
<h3 style="color:red">
${result}
</h3>
<br>
<a href='list_custs.htm'>listCustomers</a>