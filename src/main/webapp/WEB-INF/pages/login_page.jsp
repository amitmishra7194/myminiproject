<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Project</title>
<style>
* {
	padding: 0;
	margin: 0
}

#main {
	width: 1200px;
	margin: 10px auto;
}

#header {
	float: left;
	width: 1200px
}

#sheader {
	float: left
}

#logo {
	width: 800px;
	float: left
}

#qlink {
	height: 80px;
	float: left;
	width: 400px;
}

#qlink ul li {
	display: inline-block;
	height: 80px;
	line-height: 60px;
	padding:10px;
	text-align: center;
}

#qlink ul li:hover {
	color: #56a318;
}

#qlink ul li a {
	color: #000;
	text-decoration: none;
	font-size: 19px;
	border-bottom: 2px solid #bec4ba;
}

#qlink ul li a:hover {
	color: #56a318;
	font-size: 19px;
	border-bottom: 2px solid #56a318;
}

#menu {
	float: left;
	height: 50px;
	width: 1200px;
	background: #353535;
	border-top: 5px solid #56a318;
	margin-top: 10px
}

#menu ul li {
	display: inline-block;
	height: 50px;
	line-height: 50px;
	width: 100px;
	text-align: center;
}

#menu ul li:hover {
	background: #56a318
}

#menu ul li a {
	color: #fff;
	text-decoration: none;
	font-size: 19px
}

#container {
float:left
	
}

#footer {
	float: left;
	height: 100px;
	line-height:100px;
	color:#fff;
	text-align:center;
	width: 1200px;
	background: #353535;
	border-bottom: 5px solid #56a318;
}

.login {
width:1200px;
	margin: 30px auto ;
}

table {
	border-collapse: collapse;
	font-family: Trebuchet MS;
	width: 800px;
	margin: 0px auto;
}

input[type=text] {
	height: 40px;
	width: 450px;
	padding-left: 10px;
	border-radius:4px;
	border:1px solid #bec4ba;
}

input[type=password] {
	height: 40px;
	width: 450px;
	padding-left: 10px;
	border-radius:4px;
	border:1px solid #bec4ba;
}

.btn {
	border: none;
	font-size: 24px;
	margin: 20px auto;
	text-align: center;
	color: #fff;
	display: block;
	text-decoration: none;
	width: 300px;
	height: 50px;
	line-height: 40px;
	background: #353535;
	text-transform:capitalize;
	border-radius:4px;
}

td {
	font-weight: bold;
	padding:5px
}

.btn:hover {
	border: 2px solid #56a318;
	background:#56a318;
	color: #fff
}
caption{height:50px;background:#f4d4dc;border-radius:5px;line-height:50px}
</style>
</head>
<body>
	<div id="main">
		<div id="header">
			<div id="sheader">
				<div id="logo">
					<img src="spring-by-pivotal.png" height="80px">
					<!-- <img src="amit.jpg" height="100px"> -->
				</div>
				<div id="qlink">
					<ul>
						<li><a href="welcome2.htm">Home</a></li>
						<li><a 	href="about_us.htm"> About Us</a></li>
						<li><a href="contact_us.htm">Contact Us</a></li>
					</ul>
				</div>
				${msg}
			</div>
			<div id="menu">
				<ul>
					<li><a href="welcome2.htm">Home</a></li>
					<li><a href="login_page.htm">Login</a></li>
					<li><a href="register_page.htm">Register</a></li>
				</ul>
               
			</div>
		</div>
		<div id="container">

<div class="login">
			<table>
			<caption>Captcha msg::${message}</caption>
				<form:form method="post" commandName="userCmd">
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td align="right">Username</td>
						<td><form:input path="user" /> <form:errors path="user" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td align="right">Password</td>
						<td><form:password path="pwd" /> <form:errors path="pwd"
							cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td align="right">Captcha Image</td>

						<td align="left"><a href="javascript:;"
						title="change captcha text"
						onclick="document.getElementById('captcha_id').src = 'stickyImg.jpg?' + Math.random();  return false">
							<img src="stickyImg">
					</a><a href="login_page.htm">Refrsh Captcha</a></td>
					<td></td>

					</tr>
					<tr>
						<td align="right">Enter above Image text</td>
						<td><form:input path="captcha" /></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit" value="login"
							class="btn" /><br></td>
					</tr>
					</form:form>
			</table>
			</div>
		</div>
		<div id="footer">Copyright &copy; 1999-2017 by Amit Mishra. All Rights Reserved.</div>
	</div>

</body>
</html>