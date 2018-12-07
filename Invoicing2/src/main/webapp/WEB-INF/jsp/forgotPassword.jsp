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
@import url(${pageContext.request.contextPath}/css/one_patterns.css);
</style>
<script type="text/javascript">
	function validate() {
		var email = document.getElementById("email");
		
		var valid = true;
		if (email.value.length <= 0) {
			alert("Please enter Email Address.");
			valid = false;
		

		return valid;
	}
	}
</script>


</head>

<body >

	<div class="outer">
		<div class="middle">
	<div class="logo-container">
		<img class="ebulk-icon" src="${pageContext.request.contextPath}/images/ebullkplus-blue-grey.png" height="100" width="200"  >
		</div>			
			<div class="login-container">
			<h1>eBulk - Invoicing Solution</h1>
				<form id="forgotPassword" action="${pageContext.request.contextPath}/forgotPassword" method="post">
					<c:if test="${showMessage==true}">
							  <div class="alert alert-danger" role="alert">
                      <span  class="glyphicon glyphicon-remove-sign alert-icon hidden-xs" aria-hidden="true"></span>
                      ${message}
                      </div>
						</c:if>


					<h2 class="h4">Get a verification link</h2>
					<p>Ebulk will send a verification link to</p>
					<label for="username" class="sr-only">Email address</label>
					<div class="input-group">
						<div class="input-icon">
							<span class="fas fa-envelope"></span>
						</div>
						<input type="email" name="email" id="email"
							placeholder="Email address">
					</div>

					<div class="btn-container">
						<button 
							class="btn-submit btn btn-primary">Send</button>
						<div class="clearfix"></div>

					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						
						 <hr>
              <div class="logos">
                <div class="capita-logo">
                  <img src="${pageContext.request.contextPath}/images/capita-logo.png" height="20px">
                </div>
             
                <div class="clearfix"></div>
              </div>
				</form>
			</div>

</div>
	



		<hr>

	</div>
	






	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>