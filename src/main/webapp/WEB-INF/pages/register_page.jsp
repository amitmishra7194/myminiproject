<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body bgcolor="cyan">

<h1 style="color:red;text-align:center">Welcome To The Website...</h1>

<h4>
<a href="about_us.htm">AboutUs</a> &nbsp;&nbsp;
<a href="contact_us.htm">ContactUs</a>&nbsp;&nbsp;
<a href="login_page.htm">LoginPage</a>&nbsp;&nbsp;
</h4>


<h5 style="color: red">Fill The User
	Details</h5>

<form:form method="post" commandName="userCmd">
    <table border="1">
    <tr><td>
     userId::</td><td><form:input path="userId" />
	</td>
	</tr>                                      
	<tr><td>
	 Name::</td><td><form:input path="name" />
	 </td><tr>
	 <tr><td>                             
	 Age::</td><td><form:input path="age" />
	</td></tr>
	<tr><td>                                
	 Email::</td><td><form:input path="email" />
	</td></tr>
	<tr><td>                                                                            
	 City::</td><td><form:input path="city" />
	</td></tr>
	<tr><td>                                       
	 State::</td><td><form:input path="state" />
	</td></tr>
	<tr><td>                                             
	 Mobile::</td><td><form:input path="mobile" />
	</td></tr>
	<tr><td>
	 Password::</td><td><form:input path="password" />
	</td></tr>
	<tr><td colspan="2" align="center">
	<input type="submit" value="Register" />
	</td></tr>
	</table>
</form:form>
<br>
<h3 style="color:red">
${result}
</h3>
<br>
</body>