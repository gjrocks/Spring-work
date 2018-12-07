<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta http-equiv="Cache-Control" content="no-cache"/>
	<meta http-equiv="Expires" content="-1"/>
<title>First Web Application</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
<div class="form-horizontal">
<div class="col-sm-offset-2 col-sm-10">
    <div class="panel">
    <p>Welcome ${userBean.name}</p>
    
</div>
</div>
</div>

 

   
    <div class="row">
       <div class="col-md-6">  Name : ${userBean.name}</div>
       
        <div class="col-md-6"> Email : ${userBean.email}</div>
        
         <div class="col-md-6"> User Active : ${userBean.active}</div>
       
        </div>
    <form>
      <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>  <%--CSRF hidden field--%>
    </form>
    

</div>
</body>
 
 
</html>