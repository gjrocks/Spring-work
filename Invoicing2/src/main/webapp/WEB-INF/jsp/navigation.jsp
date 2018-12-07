<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
$(document).ready(function () {
	$('.nav a').filter(function(){return this.href==location.href}).parent().addClass('active').siblings().removeClass('active')
	$('.nav a').click(function(){
		$(this).parent().addClass('active').siblings().removeClass('active')	
	})         
});

</script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
	integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
	crossorigin="anonymous">
<style type="text/css" media="screen">


@import url(${pageContext.request.contextPath}/css/bootstrap.min.css);

@import url(${pageContext.request.contextPath}/css/fonts.css);

@import url(${pageContext.request.contextPath}/css/one_patterns.css);
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	
</script>
</head>
<body>
	<form id="logout" action="${pageContext.request.contextPath}/logout" method='POST'>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div class=" justify-content-center">



			<nav class="navbar  navbar-default"> <!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand"><div class="font-bold">eBulk</div></a>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#headernavbar"
					aria-expanded="false">
					<span class="sr-only">Current Invoices</span>
				</button>

			</div>
			<div class="collapse navbar-collapse" id="headernavbar">
				<ul class="nav navbar-nav ">
					<li  ><a href="${pageContext.request.contextPath}/currentInvoices"><div class="font-medium ">
								Current Invoices
							</div> </a></li>
					<li><a href="#"><div
								class="font-medium">Historic Invoices</div></a></li>
					<li><a href="#"><div class="font-medium ">Create
								Invoices</div></a></li>
					<li><a href="#"><div class="font-medium ">Next
								Invoice Run</div></a></li>
					<li><a href="#"><div class="font-medium">Client
								Management</div></a></li>
					<li>
					
					
					
					
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown "><a href="#" class="dropdown-toggle no-margin"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">
						<div class="user-img-container">
   <span class="fas fa-user-circle"></span>
   <div class="block-text">${username}</div>
   
</div>
						
						</a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/user/addUser">Add New User</a></li>
							<li><a href="${pageContext.request.contextPath}/user/allUsers">View users</a></li>

							<li><a href="${pageContext.request.contextPath}/showInvoiceRunDates">Edit Invoice Run Dates</a></li>
							<div class="dropdown-divider"></div>
							<li><a href="javascript:{}"
								onclick="document.getElementById('logout').submit();">Log Out 
									<span class="glyphicon glyphicon-log-out"></span>
							</a>
						</ul></li>
				</ul>

			</div>
			<!-- /.navbar-collapse --> </nav>
		</div>

	</form>
	

</body>
</html>