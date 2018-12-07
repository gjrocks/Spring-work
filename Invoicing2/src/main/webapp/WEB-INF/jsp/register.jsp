<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Registration Form | www.beingjavaguys.com</title>
</head>
<body>
	<center>
		<br /> <br /> <br />
		<h1>Enter Login Details Here</h1>
		<br />
		<div style="text-align: center; padding: 30px;border: 1px solid green;width: 250px;">
			<form method="post" action="register">
<input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/>
				<table>
					<tr>
						<td>User Name:</td>
						<td><input type="text" name="username" />
						</td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" />
						</td>
					</tr>
					<tr>
						<td>Role:</td>
						<td><input type="radio" name="authority" value="ROLE_USER" />USER
						<input type="radio" name="authority" value="USER_ADMIN" />ADMIN
						</td>
					</tr>
					
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Register" />
						</td>

					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>