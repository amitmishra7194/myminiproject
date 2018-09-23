<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<div id="logo">
					<img src="aboutus.png" height="80px">
					<!-- <img src="amit.jpg" height="100px"> -->
				</div>
					<ul>
						<li><a href="welcome2.htm">Home</a></li>
						<li><a href="login_page.htm">LoginPage</a></li>
						<li><a href="contact_us2.htm">Contact Us</a></li>
					</ul>
				</div>
				</div>
				
			<div id="menu">
				<ul>
					<li><a href="welcome.htm">Home</a></li>
					<li><a href="contact_us2.htm">ContactUs</a></li>
					<li><a href="login_page.htm">LoginPage</a></li>
				</ul>

			</div>
		</div>
		<div id="container">

<div class="login">
			<table>

				
		</div>
		</table>
		</div>
		<div id="footer">Copyright &copy; 1999-2017 by Amit Mishra. All Rights Reserved.</div>
	</div>

</body>
</html>