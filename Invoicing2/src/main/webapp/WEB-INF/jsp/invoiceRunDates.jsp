<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>



<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
	integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
	crossorigin="anonymous">
<style type="text/css" media="screen">
@import url(${pageContext.request.contextPath}/css/bootstrap.min.css);

@import url(${pageContext.request.contextPath}/css/one_patterns.css);

@import url(${pageContext.request.contextPath}/css/fonts.css);

@import url(${pageContext.request.contextPath}/css/jquery-ui.css);

@import url(${pageContext.request.contextPath}/css/jquery.ui.datepicker.css);
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice Run Dates</title>
<script type="text/javascript">


</script>
<script>
	$(function() {
		

		$('#invoicePeriodStartDate').datetimepicker({
			format : 'DD/MM/YYYY',
		

		});
		$('#invoicePeriodEndDate').datetimepicker({
			format : 'DD/MM/YYYY',
			
		});

	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">

			<div class="row">
				<div class="col-md-12 bottom-spacing">
					<div class="font-bold margin-left">Edit Invoice Run Dates</div>
					<div class="panel panel-default fixed-panel">
						<div class="panel-body fixed-panel">
							<div class="col-md-12 order-md-1">
							
							
								<c:if test="${showErrorMessage==true}">
									<div class="row">
										<div class="alert alert-danger " role="alert">
											<span
												class="glyphicon  alert-icon hidden-xs"
												aria-hidden="true"></span> ${errorMessage}
										</div>
									</div>
								</c:if>
							
								<c:if test="${showMessage==true}">
									<div class="row">
										<div class="alert alert-success " role="alert">
											<span
												class="glyphicon  alert-icon hidden-xs"
												aria-hidden="true"></span> ${message}
										</div>
									</div>
								</c:if>
								<div class="row">
										<form:form method="post" modelAttribute="invoiceRunDatesWrapper"
			id="searchForm">
									<div class="col-md-2 ">
										<label for="invoiceRunDates" class="  panel-label">Invoice
											Run Dates</label>
									</div>
									<div class="col-md-6">
										<div class="dropdown-container">
											<button class=" font-medium" type="button" id="menu1"
												data-toggle="dropdown">
												Select Invoice Run Dates <span class="caret"></span>
											</button>
											<ul class="dropdown-menu" aria-labelledby="dropdown1">
												<c:forEach items="${invoiceRunDatesWrapper.invoiceRunDatesList}"
													var="invoiceRunDates" varStatus="position">
													 <form:hidden path="invoiceRunDatesList[${position.index}].invoicePeriodStartDate" />
													 <form:hidden path="invoiceRunDatesList[${position.index}].invoicePeriodEndDate" />
													 <form:hidden path="invoiceRunDatesList[${position.index}].invoiceRunPeriod" />
													 <form:hidden path="invoiceRunDatesList[${position.index}].periodNum" />
													
													<li><button class="btn btn-link button-dropdown" formaction="${pageContext.request.contextPath}/getPeriod/${invoiceRunDates.periodNum}">${invoiceRunDates.invoiceRunPeriod}</button></li>
												</c:forEach>
											</ul>
										</div>
									</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<form:form method="post" modelAttribute="invoiceRunDatesBean"
			id="displayForm" onsubmit="return confirm('Are you sure you want to modify invoice dates?');">
			 <form:hidden path="periodNum" />
			<form:hidden path="prevInvoicePeriodStartDate" />
			  <form:hidden path="prevInvoicePeriodEndDate" />
			<c:if test="${showSelectedDates==true}">

				<div class="row ">
					<div class="col-md-12 bottom-spacing">

						<div class="panel panel-default fixed-panel">

							<div class="panel-body fixed-panel">

								<div class="col-md-12 order-md-1">
									<div class="row bottom-spacing">
										<div class="form-row">
											<div class="form-group">
												<div class="col-md-4">
													<div class="row">
														<form:label for="invoicePeriodStartDate"
															class="col-md-3  panel-label"
															path="invoicePeriodStartDate">Start Date
																</form:label>
														<div class="col-md-6">
															<div class="input-group date" id="invoicePeriodStartDate">
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span> </span>
																<form:input type="text" class="form-control" disabled="true"
																	id="invoicePeriodStartDate"
																	path="invoicePeriodStartDate"></form:input>

															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="form-row">
											<div class="form-group">
												<div class="col-md-4">
													<div class="row">
														<form:label for="invoicePeriodEndDate"
															class="col-md-3   panel-label"
															path="invoicePeriodEndDate">End Date
																	</form:label>
														<div class="col-md-6">
															<div class="input-group date" id="invoicePeriodEndDate">
																<span class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span> </span>
																<form:input type="text" class="form-control"
																	id="invoicePeriodEndDate" path="invoicePeriodEndDate"></form:input>

															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="btn-container ">
											<div class="col-md-1 col-md-offset-10 ">
												<button class=" btn-submit btn btn-primary " type="submit"
													name="search" formaction="${pageContext.request.contextPath}/modifyDates" >Save</button>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</form:form>
	</div>
	<%@ include file="footer.jsp"%>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</body>
</html>