<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<title>Captcha Demo</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body bgcolor="cyan">
	<h1 style="text-align: center">Login Page</h1>
	
	<br>${msg}
	<form:form method="post" commandName="userCmd">
		<div class="login">
			<table border="1" align="center">
				<tr>

					<td colspan="2">Captcha msg::${message}</td>
				</tr>
				<tr>
					<th colspan="2" align="center"><a href="register_page.htm">Register Here</a></th>
				</tr>
				<tr>
					<td>UserName:</td>
					<td><form:input path="user" /> <form:errors path="user"
							cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="pwd" /> <form:errors path="pwd"
							cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Image</td>

					<td align="left"><a href="javascript:;"
						title="change captcha text"
						onclick="document.getElementById('captcha_id').src = 'stickyImg.jpg?' + Math.random();  return false">
							<img src="stickyImg">
					</a></td>

					<!-- <td><img id="captcha_id" name="imgCaptcha" src="stickyImg.jpg"></td> -->
					<td><a href="login_page.htm">Refrsh Captcha</a></td>
				</tr>
				<tr>
					<td>Enter above Image text</td>
					<td><form:input path="captcha" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="login" /><br></td>
				</tr>
			</table>
		</div>
	</form:form>



	<%-- <form:form method="post" commandName="userCmd">
		
			<table border="1">
				
				<tr>
					<th><a href="register_page.htm">Register Here</a></th>
				</tr>
				<tr>
					<td>UserName:</td><td><form:input path="user" />
						<form:errors path="user" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Password:</td><td><form:password path="pwd" />
						<form:errors path="pwd" cssStyle="color:red" />
					</td>
				</tr>
				
				<tr>
					<td><input type="submit" value="login" /><br></td>
				</tr>
			</table>
		
	</form:form> --%>







	<br>
	<a href="welcome.htm">Home</a>