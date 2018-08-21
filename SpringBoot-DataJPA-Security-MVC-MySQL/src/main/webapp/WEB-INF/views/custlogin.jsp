<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name='f' action="login" method='POST'>
      <table>
         <tr>
            <td>GJ User:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>GJ Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
      
      <input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/>
  </form>
</body>
</html>