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
<title>Proposals</title>


<meta id="_csrf" name="_csrf" content='<c:out value="${_csrf.token}"></c:out>'/>
<meta id="_csrf_header" name="_csrf_header" content='<c:out value="${_csrf.headerName}"></c:out>'/>
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
			

		});

		$('#toSentDate').datetimepicker({
			format : 'DD/MM/YYYY',

		});

		$('#fromSentDate').datetimepicker({
			format : 'DD/MM/YYYY',

		});
		$('#fromDate').datetimepicker({
		
		});
		$('#sentDateAdd').datetimepicker({
			format : 'DD/MM/YYYY'
		});
		
		
		 $("#modal-btn-si").on("click", function(){
			// handleModalResponse(true);
			    $("#mi-modal").modal('hide');
			  });
			  
			 // $("#modal-btn-no").on("click", function(){
				//  handleModalResponse(false);
			//    $("#mi-modal").modal('hide');
			//  });
		
	});
</script>
<script type="text/javascript">
	function resetform() {
		document.getElementById("searchForm").reset();
	}
	
	function assignPlease(va){
		//assignName
		alert(va);
		
	var name=$('#assignName'+va).val();
	alert(name);
	var token = $('#_csrf').attr('content');
	var header = $('#_csrf_header').attr('content');
	alert(token);
	alert(header);
	
	var datain = {}
	datain["bundleID"] = va;
	datain["name"] = name;
	
   
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/assign",
        data: JSON.stringify(datain),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {

           alert("success :" + data.code)
            console.log("SUCCESS : ", data);
            //$("#btn-search").prop("disabled", false);
           $("#mi-modal").modal({show:true});

        },
        error: function (e) {

        	alert('error' + e);
          
            console.log("ERROR : ", e);
          

        }
    });
	
	
		return false;
	}
	
	function releasePlease(val){
		alert(val);
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<form:form modelAttribute="currentProposalsBean" id="searchForm">
	<form:hidden path="page" />
		<div class="row">

			<div class="col-md-12 bottom-spacing">
				<div class="font-bold margin-left">Proposals</div>
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
										path="clientSearch">Proposal Bundle Num :</form:label></div>
										<div class="col-md-2 ">
									<form:input type="text" class="form-control " id="proposalNum"
										path="proposalNum"></form:input>
								</div>
								<form:input type="hidden" class="form-control"
										id="contractSearch" path="contractSearch"></form:input>
										<form:input type="hidden" class="form-control " id="clientSearch"
										path="clientSearch"></form:input>
										<form:input type="hidden" class="form-control " id="invoiceStatus"
										path="invoiceStatus"></form:input>
										
										<form:input type="hidden" class="form-control" id="sapNumber"
										path="sapNumber"></form:input>



								<form:input type="hidden" class="form-control"
									id="invoiceNumSearch" path="invoiceNumSearch"></form:input>

								<form:input type="hidden" class="form-control"
									id="invoiceNumFromSearch" path="invoiceNumFromSearch"></form:input>

								<form:input type="hidden" class="form-control"
									id="invoiceNumToSearch" path="invoiceNumToSearch"></form:input>

							</div>
							<div class="clearfix"></div>

						
		

							<div class="form-row">
								<label for="displayLabel"
									class="col-md-12 panel-label text-lighter"></label>
							</div>

							<div class="form-row ">

								<div class="col-md-2">


									<form:label for="fromDate" class="panel-label"
										path="fromDate">From:
												</form:label>
								</div>
								<div class="col-md-2">
									<div class="input-group date" id="fromDate">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-calendar"></span> </span>
										<form:input type="text" class="form-control" id="fromDate"
											path="fromDate"></form:input>

									</div>
								</div>
							</div>
							<div class="form-row ">
								<div class="col-md-2">

									<form:label for="toDate" class="col-md-2 panel-label"
										path="toDate">To:
												</form:label>
								</div>
								<div class="col-md-2 ">
									<div class="input-group date" id="toDate">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-calendar"></span> </span>
										<form:input type="text" class="form-control" id="toDate"
											path="toDate"></form:input>

									</div>

								</div>

							</div>
								<form:input type="hidden" class="form-control " id="sendMethod"
										path="sendMethod"></form:input>
										
										<form:input type="hidden" class="form-control "
										id="paymentMethod" path="paymentMethod"></form:input>
							



							
							<div class="form-row">
								<div class="clearfix"></div>
							</div>
							<div class="form-row">
								<label for="displayLabel"
									class="col-md-12 panel-label text-lighter"></label>
							</div>
							
							<div class="form-row">

								<label for="dateRange" class="col-md-2 panel-label">Sort
									By</label>
									
									<div class="col-md-2">
										<form:select class="form-control" id="sortBy" path="sortBy">
											<form:options items="${currentProposalsBean.sortByMap}" />
										</form:select>

									</div>

							</div>
							<div class="form-row">

								<label for="dateRange" class="col-md-2 panel-label">Display
									Size</label>
									<div class="col-md-2">



										<form:select path="displaySize" class="form-control">
											<form:option value="20" label="20" />
											<form:option value="30" label="30" />
											<form:option value="40" label="40" />

										</form:select>

									</div>

							</div>
							<form:input type="hidden" class="form-control"
														id="fromSentDate" path="fromSentDate"></form:input>
														
														<form:input type="hidden" class="form-control"
														id="toSentDate" path="toSentDate"></form:input>
														
														<form:input type="hidden" class="form-control"
														id="fromSentDate" path="fromSentDate"></form:input>
														
							<div class="form-row">
								<div class="form-group">
									<div class="col-md-2">
										<div class="row">
											<form:label for="fromSentDate" class="col-md-2 panel-label"
												path="fromSentDate">
												</form:label>
										<%-- 	<div class="col-md-10 ">
												<div class="input-group date" id="fromSentDate">
													<span class="input-group-addon"><span
														class="glyphicon glyphicon-calendar"></span> </span>
													<form:input type="text" class="form-control"
														id="fromSentDate" path="fromSentDate"></form:input>

												</div>

											</div> --%>
										</div>
									</div>
									<div class="col-md-2">
										<div class="row">
											<form:label for="toSentDate" class="col-md-2 panel-label"
												path="toSentDate">  
												</form:label>
										<%-- 	<div class="col-md-10 ">
												<div class="input-group date" id="toSentDate">
													<span class="input-group-addon"><span
														class="glyphicon glyphicon-calendar"></span> </span>
													<form:input type="text" class="form-control"
														id="toSentDate" path="toSentDate"></form:input>

												</div>

											</div> --%>
										</div>
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

					<div class="row">
						<div >
							<table class="table table-break-all" id="demo">
								<thead>
									<tr>
										<th><input type="checkbox" id="select-all"  name="chk[]" /></th>
										<th class="font-medium">Proposal bundle Number</th>
										<th class="font-medium">Proposal Quote Number</th>
										<th class="font-medium">Country</th>
										<th class="font-medium">Created Date</th>
										<th class="font-medium">Proposal Status</th>
										<th class="font-medium">Message</th>
										<th class="font-medium">Assign To</th>
										<th class="font-medium">Release</th>
										<!-- <th class="font-medium">Assign Date</th> -->
										<!-- <th class="font-medium">Close</th> -->

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
													<c:out value="${invoiceResults.agreementNumber}"></c:out>
													<i class="fas fa-external-link-alt"></i>
												</button>
											</td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.quoteNumber}" ></c:out></td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.countryCode}"></c:out></td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.createdAt}"></c:out></td>
											<td class="text-center-align"><c:out
													value="${invoiceResults.trackingStatus}"></c:out></td>
											<td class="text-left-align"><c:out
													value="${invoiceResults.errorText}"></c:out></td>

											<td class="text-center-align"><input type="text"
												name="assignName" size="10"
												id="assignName<c:out value="${invoiceResults.agreementNumber}"></c:out>" />
												<button class="btn btn-link font-medium"
													onclick="assignPlease('<c:out value="${invoiceResults.agreementNumber}"></c:out>');return false;">Assign</button>
											</td>
											<td class="text-center-align"><button
													class="btn btn-link font-medium"
													onclick="releasePlease('<c:out value="${invoiceResults.agreementNumber}"></c:out>');return false;">Close</button></td>
											<%-- <td class="text-center-align"><td class="text-center-align"><button class=" btn-default btn btn-primary " name="assignme" onclick="releasePlease('<c:out value="${invoiceResults.agreementNumber}"></c:out>');" 
											>Close</button></td> --%>

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
			<div class="modal" id="mi-modal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Assignment Complete</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">


								<h4 class="modal-title" id="myModalLabel">Assigned</h4>

								<div class="modal-footer">
									<button type="button"  id="modal-btn-si">Yes</button>
									<!-- <button type="button" id="modal-btn-no">No</button> -->
								</div>
							</div>

							<!-- Modal footer -->
							<!-- <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div> -->

						</div>
					</div>
				</div>
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