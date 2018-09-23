<%@ page isELIgnored="false" language="java"
 	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
 <h1 style="color: red; text-align: center">Update The Employee	Details</h1> 

<form:form method="post" commandName="studCmd">
     Student Id::<form:input path="sid" disabled="true"/>
	<br>                                      
	 Student Name::<form:input path="sname" /> 
 	<br>                                  
 	 Student Age::<form:input path="sage" /> 
	<br>                                     
 	 Address<form:input path="address" /> 
	<br>                                      
	 Course<form:input path="course" /> 
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
 <a href='list_studs.htm'>listStudents</a> 



                      
                      <!-- UI View -->
                      
                      
<%-- <%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

                      
<style>

 table{border-collapse:collapse;font-family: Trebuchet MS;width:auto;margin:0px auto;}

 input[type=text]{
 height:40px;width:450px;padding-left:10px
 } 
 .btn{border:none;
 font-size:20px;margin:20px auto;text-align:center;color:#fff;display:block;text-decoration:none;width:450px;height:40px;line-height:40px;background:#5a8e07;
 }
 td{font-weight:bold} 
 .btn:hover{border:2px solid #5a8e07;background:#fff;color:#5a8e07} 
 #menu{  
 height:50px;max-width:100%;background:#113d84}
 #menu ul li{display:inline-block;height:50px;line-height:50px;width:auto;margin-left:10px;padding:0px 10px 0px 10px;text-align:center}
 #menu ul li:hover{background:red;text-decoration:none;color:#fff} 

 #menu ul li a{color:#fff;text-decoration:none;font-size:19px}

</style>
<div id="menu">
<ul><li><a href="list_studs.htm" >Home</a></li></ul>
</div>
<table cellpadding=7px>
<caption><h1 style="color:#113d84;text-align:center;border-bottom:2px solid #113d84;width:450px">Edit Student Details </h1>
<form:form method="POST" commandName="studCmd">
</caption>
<tr><td>Student Number ::</td><td><form:input path="sid" readonly="true"/></td></tr>
<tr><td>Student Name  ::</td><td><form:input path="sname"/></td></tr>
<tr><td>Student Age  ::</td><td><form:input path="sage"/></td></tr>
<tr><td>student Address ::</td><td><form:input path="address"/></td></tr>
<tr><td>student Course ::</td><td><form:input path="course"/></td></tr>
<tr><td>student City ::</td><td><form:input path="city"/></td></tr>
<tr><td>student State ::</td><td><form:input path="state"/></td></tr>
<tr><td>student PinCode ::</td><td><form:input path="pincode"/></td></tr>
<tr><td colspan="2"><input type="Submit" class="btn" value="Update details"/></td></tr>
</form:form>
</table>

<br>
<h3 style="color:red">
 ${result}
</h3> 
<br>
<p style="text-align:center">Designed By : <b>Amit Mishra</b></p> --%>
                      