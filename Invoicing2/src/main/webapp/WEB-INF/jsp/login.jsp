<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">



<title>Log in with your account</title>
<link rel="stylesheet" media="screen"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css">

<!-- fonts -->
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Khula:300,400,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
	integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
	crossorigin="anonymous">

<style type="text/css" media="screen">
@import url(css/one_patterns.css);
</style>
<script type="text/javascript">
	function validate() {
		var username = document.getElementById("username");
		var password = document.getElementById("password");
		var valid = true;
		if (username.value.length <= 0) {
			alert("Please enter User name");
			valid = false;
		} else if (password.value.length <= 0) {
			alert("Please enter Password");
			valid = false;
		}

		return valid;
	}
</script>


</head>

<body id="LoginForm">

	<div class="outer">
	
					
						
		<div class="middle">

					<div class="logo-container">
		<img class="ebulk-icon" src="images/jd.png">
		</div>				
							
			<div class="login-container">
			
				<h1>FinanceConnect - insight Solution</h1>
				<form id="Login"  method="post"
					onsubmit="return validate();">

					
						<c:url value="/login" var="loginUrl" />
							<c:url value="/forgotPassword" var="forgotPasswordUrl" />

						<c:if test="${showMessage==true}">
						   <div class="alert alert-danger" role="alert">
                      <span  class="glyphicon glyphicon-remove-sign alert-icon hidden-xs" aria-hidden="true"></span>
                      ${message}
                    </div>
						
							
						</c:if>
						
						<c:if test="${showSuccessMessage==true}">
						   <div class="alert alert-success" role="alert">
                      <span  class="glyphicon alert-icon hidden-xs" aria-hidden="true"></span>
                      ${message}
                    </div>
						
							
						</c:if>

						<label for="username" class="sr-only">Username</label>
						<div class="input-group">
							<div class="input-icon">
								<span class="fas fa-user"></span>
							</div>
							<input type="text" name="username" id="username"
								placeholder="Username">
						</div>
						<label for="username" class="sr-only">Password</label>
						<div class="input-group">
							<div class="input-icon">
								<span class="fas fa-key"></span>
							</div>
							<input type="password" name="password" id="password"
								placeholder="Password">
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

				
					<div class="btn-container">
						<%-- <a href="<c:out value="${forgotPasswordUrl}"/>" class="std-color"
							>Forgotten details</a> --%>

						<button type="submit" class="btn-submit btn btn-primary" action="${loginUrl}">Log
							in</button>

						
						 <div class="clearfix"></div>
							
            
					</div>
					 <hr>
              <div class="logos">
                <div class="capita-logo">
                  <img src="images/jd.png" height="20px">
                </div>
             
                <div class="clearfix"></div>
              </div>
				
				</form>
				
			</div>
			
			 

</div>
	
	

	</div>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
