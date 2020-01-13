<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.pagingCurrentPageContainer {
	display: inline;
	border: 1px solid #a90a08;
	margin: 0px 0px;
	font-weight: bold;
	color: #a90a08;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Current Invoices</title>

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

@import
	url(${pageContext.request.contextPath}/css/jquery.ui.datepicker.css);
</style>

<script>
	$(function() {
		var currentDate = document.getElementById("currentPeriodStart");
		$('#toDate').datetimepicker({
			format : 'DD/MM/YYYY',

		});

		$('#toSentDate').datetimepicker({
			format : 'DD/MM/YYYY',

		});

		$('#fromSentDate').datetimepicker({
			format : 'DD/MM/YYYY',

		});
		$('#fromDate').datetimepicker({
			format : 'DD/MM/YYYY'
		});
		$('#sentDateAdd').datetimepicker({
			format : 'DD/MM/YYYY'
		});
	});
</script>
<script type="text/javascript">
	function resetform() {
		document.getElementById("searchForm").reset();
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<form:form modelAttribute="currentProposalsBean" id="searchForm">
	<form:hidden path="page" />
		<div class="row">

			<div class="col-md-12 bottom-spacing">
				<div class="font-bold margin-left">Current Invoices</div>
				<div class="panel panel-default fixed-panel">

					<div class="panel-body fixed-panel">

						<div class="col-md-12 order-md-1">


							<c:if test="${showError==true}">
								<div class="row">
									<div class="alert alert-danger" role="alert">
										<span
											class="glyphicon glyphicon-remove-sign alert-icon hidden-xs"
											aria-hidden="true"></span> ${message}
									</div>
								</div>
							</c:if>

							<div class="form-row">
								<div class="col-md-2 ">
									<form:label for="clientSearch" class="panel-label"
										path="clientSearch">Proposal Bundle Num</form:label>
									<form:input type="text" class="form-control " id="proposalNum"
										path="proposalNum"></form:input>
								</div>
								
								<div class="col-md-2 ">
									<form:label for="clientSearch" class="panel-label"
										path="clientSearch">Client</form:label>
									<form:input type="text" class="form-control " id="clientSearch"
										path="clientSearch"></form:input>
								</div>
								<div class="col-md-2">
									<form:label for="contractSearch" class="panel-label"
										path="contractSearch">Contract</form:label>
									<form:input type="text" class="form-control"
										id="contractSearch" path="contractSearch"></form:input>

								</div>

								<div class="col-md-2 ">
									<form:label for="invoiceStatus" class="panel-label"
										path="invoiceStatus">Invoice Status</form:label>
									<form:select class="form-control" id="invoiceStatus"
										path="invoiceStatus">
										<form:options items="${currentProposalsBean.invoiceStatusMap}" />
									</form:select>



								</div>
								<div class="col-md-2">
									<form:label for="sapNumber" class="panel-label"
										path="sapNumber">Sap File Number</form:label>
									<form:input type="text" class="form-control" id="sapNumber"
										path="sapNumber"></form:input>

								</div>

							</div>
							<div class="clearfix"></div>

							<div class="form-row">
								<div class="col-md-2 ">
									<form:label for="invoiceNumSearch" class="panel-label"
										path="invoiceNumSearch">Invoice
											Number</form:label>
									<form:input type="text" class="form-control"
										id="invoiceNumSearch" path="invoiceNumSearch"></form:input>

								</div>
								<div class="col-md-10">
									<label for="invoiceNumberRange" class="panel-label">Invoice
										Number Range<label>
								</div>
								<div class="form-group">
									<div class="col-md-2">
										<div class="row">

											<form:label for="invoiceNumFromSearch"
												path="invoiceNumFromSearch" class="col-md-3 panel-label ">From</form:label>
											<div class="col-md-9">
												<form:input type="text" class="form-control"
													id="invoiceNumFromSearch" path="invoiceNumFromSearch"></form:input>
											</div>

										</div>
									</div>
									<div class="col-md-2">
										<div class="row">
											<form:label for="invoiceNumToSearch"
												path="invoiceNumToSearch"
												class="col-md-2  panel-label text-right">To</form:label>
											<div class="col-md-10">
												<form:input type="text" class="form-control"
													id="invoiceNumToSearch" path="invoiceNumToSearch"></form:input>
											</div>
										</div>
									</div>
									<div class="col-md-6 spacing"></div>
								</div>
							</div>

							<div class="form-row">
								<label for="displayLabel"
									class="col-md-12 panel-label text-lighter">Search for
									an invoice number or range of invoice numbers you cannot search
									for both.</label>
							</div>

							<div class="form-row">
								<label for="dateRange" class="col-md-4 panel-label">Invoice
									Date Range</label>
							</div>

							<div class="form-row">
								<label for="sentMethod" class="col-md-2 panel-label">Sent
									Method</label>
							</div>
							<div class="form-row">
								<label for="paymentMethod" class="col-md-6 panel-label">Payment
									Method</label>
							</div>
							<div class="form-row ">

								<div class="col-md-2">
									<div class="row">
										<form:label for="fromDate" class="col-md-2 panel-label"
											path="fromDate">From
												</form:label>
										<div class="col-md-10">
											<div class="input-group date" id="fromDate">
												<span class="input-group-addon"><span
													class="glyphicon glyphicon-calendar"></span> </span>
												<form:input type="text" class="form-control" id="fromDate"
													path="fromDate"></form:input>

											</div>
										</div>
									</div>
								</div>
								<div class="col-md-2">
									<div class="row">
										<form:label for="toDate" class="col-md-2 panel-label"
											path="toDate">To
												</form:label>
										<div class="col-md-10 ">
											<div class="input-group date" id="toDate">
												<span class="input-group-addon"><span
													class="glyphicon glyphicon-calendar"></span> </span>
												<form:input type="text" class="form-control" id="toDate"
													path="toDate"></form:input>

											</div>

										</div>
									</div>
								</div>
								<div class="col-md-2 ">

									<form:input type="text" class="form-control " id="sendMethod"
										path="sendMethod"></form:input>
								</div>


								<div class="col-md-2 ">

									<form:input type="text" class="form-control "
										id="paymentMethod" path="paymentMethod"></form:input>
								</div>



							</div>
							<div class="form-row">
								<div class="clearfix"></div>
							</div>
							<div class="form-row">

								<label for="dateRange" class="col-md-4 panel-label">Sent
									Date Range</label>

							</div>
							<div class="form-row">

								<label for="dateRange" class="col-md-2 panel-label">Sort
									By</label>

							</div>
							<div class="form-row">

								<label for="dateRange" class="col-md-6 panel-label">Display
									Size</label>

							</div>
							<div class="form-row">
								<div class="form-group">
									<div class="col-md-2">
										<div class="row">
											<form:label for="fromSentDate" class="col-md-2 panel-label"
												path="fromSentDate">From
												</form:label>
											<div class="col-md-10 ">
												<div class="input-group date" id="fromSentDate">
													<span class="input-group-addon"><span
														class="glyphicon glyphicon-calendar"></span> </span>
													<form:input type="text" class="form-control"
														id="fromSentDate" path="fromSentDate"></form:input>

												</div>

											</div>
										</div>
									</div>
									<div class="col-md-2">
										<div class="row">
											<form:label for="toSentDate" class="col-md-2 panel-label"
												path="toSentDate">To
												</form:label>
											<div class="col-md-10 ">
												<div class="input-group date" id="toSentDate">
													<span class="input-group-addon"><span
														class="glyphicon glyphicon-calendar"></span> </span>
													<form:input type="text" class="form-control"
														id="toSentDate" path="toSentDate"></form:input>

												</div>

											</div>
										</div>
									</div>
									<div class="col-md-2 ">
										<form:select class="form-control" id="sortBy" path="sortBy">
											<form:options items="${currentProposalsBean.sortByMap}" />
										</form:select>

									</div>
									<div class="col-md-2">



										<form:select path="displaySize" class="form-control">
											<form:option value="20" label="20" />
											<form:option value="30" label="30" />
											<form:option value="40" label="40" />

										</form:select>

									</div>
								</div>



							</div>


							<div class="row">
								<div class="btn-container ">

									<div class="col-md-1 col-md-offset-10">
										<button class="btn btn-link" onclick="resetform();"
											formaction="${pageContext.request.contextPath}/resetSearch"
											name="clear">CLEAR</button>
									</div>
									<div class="col-md-1 ">
										<button class=" btn-submit btn btn-primary " name="search"
											formaction="${pageContext.request.contextPath}/searchCurrentProposals?page=${currentProposalsBean.page}">Search</button>
									</div>
								</div>

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<c:if test="${showSearchResults==true}">

				<div class="row ">

					<div class="centre-display">
						<div class="btn-container col-md-9">
							<div class="row bottom-spacing">
								<div class="col-md-2">
									<button class="btn btn-link font-medium">Send Invoice</button>
								</div>
								<div class="col-md-2">
									<button class="btn btn-link font-medium">SAP Extract</button>
								</div>
								<div class="col-md-2">
									<button class="btn btn-link font-medium" 
									formaction="${pageContext.request.contextPath}/generateExcelReport">
									Export To
										Excel</button>
								</div>
								<div class="col-md-2">
									<div class="dropdown-container">
										<button class="btn btn-link font-medium" type="button"
											id="menu1" data-toggle="dropdown">
											Download <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" aria-labelledby="dropdown1">


											<li><button class="btn btn-link font-medium padding"
													formaction="${pageContext.request.contextPath}/downloadInvoicePdf">Invoice
													PDF</button></li>


											<li><button class="btn btn-link font-medium padding"
													formaction="${pageContext.request.contextPath}/downloadInvoiceBackingPdf">Backing
													PDF</button></li>

											<li><button class="btn btn-link font-medium padding"
													formaction="${pageContext.request.contextPath}/downloadInvoiceBackingcsv">Backing
													CSV</button></li>

											<li class="divider"></li>
											<li><button class="btn btn-link font-medium padding"
													formaction="${pageContext.request.contextPath}/generateInvoiceFolders">Download
													All</button></li>

										</ul>
									</div>
								</div>
								<div class="col-md-2">
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
						<div class="col-md-3">
							<div class="row">
								<form:form method="post" modelAttribute="proposalResultsBean"
									action="/addSentDate">

									<div class="col-md-9 zero-padding">
										<div class="input-group date zero-padding" id="sentDateAdd">
											<span class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span> </span>
											<form:input type="text" class="form-control" id="sentDateAdd"
												placeholder="Add Sent Date" path="sentDate"></form:input>


										</div>
									</div>
									<div class="col-md-3 zero-padding">
										<button class="btn-display btn-primary ">Add</button>


									</div>

								</form:form>
							</div>
						</div>

					</div>

					<div class="row">
						<div class="centre-display">
							<table class="table table-break-all" id="demo">
								<thead>
									<tr>
										<th><input type="checkbox" id="select-all"  name="chk[]" /></th>
										<th class="font-medium">Invoice Number</th>
										<th class="font-medium">Client</th>
										<th class="font-medium">Contract</th>
										<th class="font-medium">Invoice Date</th>
										<th class="font-medium">Invoice Status</th>
										<th class="font-medium">Payment Method</th>
										<th class="font-medium">Send Method</th>
										<th class="font-medium">Sent Date</th>
										<th class="font-medium">SAP</th>

									</tr>
								</thead>

								<tbody>
									<c:forEach items="${proposalResultsList}" var="invoiceResults"
										varStatus="num">

										<tr>


											<td><input type="checkbox"
												value="${invoiceResults.invoiceNum}" name="id" id="id"
												class="allcheckbox"
												></td>

											<td class="text-center-align">

												<button class="btn btn-link font-medium" type="submit"
													formaction="${pageContext.request.contextPath}/showInvoiceSummary/${invoiceResults.invoiceNum}">
													<c:out value="${invoiceResults.invoiceNum}"></c:out>
													<i class="fas fa-external-link-alt"></i>
												</button>
											</td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.clientName}" ></c:out></td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.contractName}"></c:out></td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.invoiceDate}"></c:out></td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.invoiceStatus}"></c:out></td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.paymentMethod}"></c:out></td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.sendMethod}"></c:out></td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.sentDate}"></c:out></td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.sap}"></c:out></td>

										</tr>
									</c:forEach>

								</tbody>



								<tfoot>
									<tr>
										<td colspan="10">

											<div style="float: right; padding: 5px 0px"><%@ include
													file="tilePaging.jsp"%></div> <span
											style="float: left; padding: 5px 0px"><c:out
													value="${requestScope.pagingBean.showingResults}" /></span>

										</td>
									</tr>
								</tfoot>
							</table>


						</div>


					</div>
				</div>

			</c:if>
		</div>
	</form:form>
	<%@ include file="footer.jsp"%>


	<script>
	
	$("#select-all").change(function(){
		   $(".allcheckbox").prop("checked", $(this).prop("checked"))
		  })
		  $(".allcheckbox").change(function(){
		      if($(this).prop("checked") == false){
		          $("#select-all").prop("checked", false)
		      }
		      if($(".allcheckbox:checked").length == $(".allcheckbox").length){
		          $("#select-all").prop("checked", true)
		      }
		  })
	
	function checkAll(ele) {
	     var checkboxes = document.getElementsByTagName('input');
	     if (ele.checked) {
	         for (var i = 0; i < checkboxes.length; i++) {
	             if (checkboxes[i].type == 'checkbox') {
	                 checkboxes[i].checked = true;
	             }
	         }
	     } else {
	         for (var i = 0; i < checkboxes.length; i++) {
	            
	             if (checkboxes[i].type == 'checkbox') {
	                 checkboxes[i].checked = false;
	             }
	         }
	     }
	 }
  function uncheckMain(ele){
	  alert(ele.checked);
	  if(!ele.checked){
		  alert("here");
		  var mainCheckbox = document.getElementsById('selectAll');
		  alert(mainCheckbox);
		  if(mainCheckbox.checked){
			  mainCheckbox.checked=false;
		  }		  
	  }	  
	  
  }
   


  
    
    </script>


</body>
</html>