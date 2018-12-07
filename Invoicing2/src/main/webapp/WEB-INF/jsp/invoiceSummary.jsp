<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

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
<title>Invoice Summary</title>

</head>
<body>

	<%@ include file="header.jsp"%>

	<form:form name="displaySummaryForm" method="POST"
		modelAttribute="invoiceSummaryBean">
	<div class="container">	
			<div class="row">
				<div class="col-md-12 bottom-spacing">
					<div class="font-bold margin-left">Invoice Summary</div>
					<div class="panel panel-default fixed-panel">

						<div class="panel-body fixed-panel">

							<div class="col-md-12 order-md-1">



								<div class="row">
									<div class="col-md-4 font-bold ">
										<label for="invoiceNumber" class=" font-bold">Invoice#</label>
										<c:out value="${invoiceSummaryBean.invoiceNumber}"></c:out>

									</div>
									<div class="col-md-2 col-md-offset-6 font-bold">
										<c:out value="${invoiceSummaryBean.invoiceStatus}"></c:out>
									</div>
								</div>
								<div class="row ">
									<div class="col-md-4 font-bold ">
										<label for="clientName" class="font-bold">Client:</label>
										<c:out value="${invoiceSummaryBean.clientName}"></c:out>

									</div>
									<div class="col-md-2 col-md-offset-6">
										<label for="isManual" class="font-bold-medium">Manual:</label>
										<c:out value="${invoiceSummaryBean.isManual}"></c:out>
									</div>
								</div>
								<div class="row bottom-spacing ">
									<div class="col-md-4 ">
										 <label for="contractName" class="font-bold-medium">Contract:</label>
											<c:out value="${invoiceSummaryBean.contractName}"></c:out>
										
									</div>

								</div>

								<div class="row top-buffer">
									<div class="col-md-4">
										<div class="row">
											<div class="col-md-4">
												<label for="invoiceDate" class="font-bold-medium">Invoice
													Date:</label>
													<c:out value="${invoiceSummaryBean.invoiceDate}"></c:out>
												
											</div>
											<div class="col-md-4">
												<label for="sentDate" class="font-bold-medium">Sent
													Date:</label>
													<c:out value="${invoiceSummaryBean.sentDate}"></c:out>
											
											</div>
											<div class="col-md-4">
												<label for="sendMethod" class="font-bold-medium">Send
													method:</label>
												<c:out value="${invoiceSummaryBean.sendMethod}"></c:out>
											</div>
										</div>
									</div>

									<div class="col-md-6 col-md-offset-2">
									
									
										<div class="row">
											<div class="col-md-2">
												<button class="btn btn-link font-medium">Regenerate</button>
											</div>
											
											<div class="col-md-2">
												<button class="btn btn-link font-medium">Re-Send</button>
											</div>
												<div class="col-md-3">
												<div class="dropdown-container">
													<button class="btn btn-link font-medium" type="button"
														id="menu1" data-toggle="dropdown">
														Download <span class="caret"></span>
													</button>
													<ul class="dropdown-menu" aria-labelledby="dropdown1">
														<li><a href="#">Invoice PDF</a></li>
														<li><a href="#">Backing PDF</a></li>
														<li><a href="#">Backing CSV</a></li>
														<li class="divider"></li>
														<li><a href="#">Download All</a></li>
													</ul>
												</div>
											</div>
								
											
											<div class="col-md-3">
												<div class="dropdown-container font-medium">
													<button class="btn btn-link" type="button" id="dropdown2"
														data-toggle="dropdown">
														Status Change <span class="caret"></span>
													</button>
													<ul class="dropdown-menu" aria-labelledby="menu1">
														<li><a href="#">Pending</a></li>
														<li><a href="#">Authorised</a></li>
														<li><a href="#">Cancelled</a></li>
														<li><a href="#">Sent</a></li>
														<li><a href="#">Regenerated</a></li>
													</ul>
												</div>
											</div>
											</div>
				
</div>

						</div>
					</div>
				</div>
			</div>
</div>
</div>


			<div class="row">
				<div class="col-md-12 bottom-spacing">

					<div class="panel panel-default fixed-panel">

						<div class="panel-body fixed-panel">

							<div class="col-md-12 order-md-1">



								<div class="row">
									<div class="col-md-2 font-bold">

										£
										<c:out value="${invoiceSummaryBean.totalGrossSummary}"></c:out>
										<label for="totalGrossSummary" class="font-bold">Gross Total </label>
										<hr class="hr-color">
										
										

									</div>
									<div class="col-md-2 col-md-offset-3 ">
										<label for="poNumber" class="font-bold-medium">Purchase
											Order#</label><br>
										<c:out value="${invoiceSummaryBean.poNumber}"></c:out>
									</div>

									<div class="col-md-2 col-md-offset-3">
										<label for="businessContact" class="font-bold-medium">Business
											Contact</label><br>
										<c:out value="${invoiceSummaryBean.businessContact}"></c:out>
									</div>



								</div>
								<div class="row">
									<div class="col-md-2 font-bold">

										£
										<c:out value="${invoiceSummaryBean.totalNetSummary}"></c:out>
										<label for="totalNetSummary" class="font-bold">Net Total </label><br>

£
										<c:out value="${invoiceSummaryBean.totalVatSummary}"></c:out>
										<label for="totalVatSummary" class="font-bold">VAT Total </label>


									</div>
									<div class="col-md-2 col-md-offset-3">
										<label for="sapClientCode" class="font-bold-medium">SAP/Account
											#</label><br>
										<c:out value="${invoiceSummaryBean.sapClientCode}"></c:out>
									</div>

									<div class="col-md-2 col-md-offset-3">
										<label for="address" class="font-bold-medium">Billing
											Entity Address</label><br>
										<c:out
											value="${invoiceSummaryBean.billingAddress.addressName}"></c:out><br>
										<c:out
											value="${invoiceSummaryBean.billingAddress.buildingName}"></c:out><br>
											<c:out
											value="${invoiceSummaryBean.billingAddress.streetName}"></c:out><br>
												<c:out
											value="${invoiceSummaryBean.billingAddress.town}"></c:out><br>
											<c:out
											value="${invoiceSummaryBean.billingAddress.county}"></c:out><br>
											<c:out
											value="${invoiceSummaryBean.billingAddress.country}"></c:out><br>
											<c:out
											value="${invoiceSummaryBean.billingAddress.postCode}"></c:out>	
									</div>
								</div>

								<div class="row">
									<div class="col-md-4 font-bold">
										
									</div>
								</div>

							</div>

						</div>
					</div>
				</div>
			</div>




			<div class="row">
					<div class="col-md-12 bottom-spacing">

					<div class="panel panel-default fixed-panel">

						<div class="panel-body fixed-panel">

							<div class="col-md-12 order-md-1">
				
					<table class="table table-break-all">
						<thead>
							<tr>
								<th class="font-medium">Product</th>
								<th class="font-medium">Item Net</th>
								<th class="font-medium">Item VAT</th>
								<th class="font-medium">Item Gross</th>
								<th class="font-medium">Quantity</th>
								<th class="font-medium">Total Net</th>
								<th class="font-medium">Total VAT</th>
								<th class="font-medium">Total Gross</th>
								<th class="font-medium">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${productList}" var="productList">
								<tr>
									<td class="text-center-align"><c:out
											value="${productList.productName}"></c:out></td>
									<td class="text-center-align"><c:out
											value="${productList.itemNet}"></c:out></td>
									<td class="text-center-align"><c:out
											value="${productList.itemVat}"></c:out></td>
									<td class="text-center-align"><c:out
											value="${productList.itemGross}"></c:out></td>
									<td class="text-center-align"><c:out
											value="${productList.quantity}"></c:out></td>
									<td class="text-center-align"><c:out
											value="${productList.totalNet}"></c:out></td>
									<td class="text-center-align"><c:out
											value="${productList.totalVat}"></c:out></td>
									<td class="text-center-align"><c:out
											value="${productList.totalGross}"></c:out></td>
									<td class="text-center-align ">
										<button class=" btn-link zero-padding">
											Edit<i class="fas fa-pen "></i>
										</button>

									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					</div>
					</div>
					</div>
					
				</div>
			</div>
		</div>
		
	</form:form>


<%@ include file="footer.jsp"%>









</body>
</html>