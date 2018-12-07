<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<script>

$( function() {
	
	
	var editMode='${editMode}';
	if(editMode){
		$('#uname').prop("readonly",true);
	}
    function getUsers() {
        var request = $.ajax({
            url: 'getuser',
            type: 'POST',
           // data: JSON.stringify(client),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            dataType: 'json'
          });

          request.done(function(msg) {
           
               console.log("msg :" +msg);
              // var obj = jQuery.parseJSON( msg );
             //  $('#openresult').show();
             //alert(obj);
            
               showTable(msg);
             
          });

          request.fail(function(jqXHR, textStatus) {
            alert( "Request failed: " + textStatus );
          });
        
       
    }
//  $( "#dob" ).datepicker();
$('#getallusers').on('click', function(event) {
       
  getUsers();
       });
	
	 $("#modal-btn-si").on("click", function(){
		 handleModalResponse(true);
		    $("#mi-modal").modal('hide');
		  });
		  
		  $("#modal-btn-no").on("click", function(){
			  handleModalResponse(false);
		    $("#mi-modal").modal('hide');
		  });
	
	

} );

function showAlert(userName){
	
	
	  $("#usern").val(userName);
	
	  $("#mi-modal").modal({show:true});
		// $("#myModal").modal({show:true});
	  
	  //alert('ganeshdddasasasd');
		return false;
}

function handleModalResponse(confirm){
	  if(confirm){
	 		  //submitForm('delForm');
	 		 document.forms['delForm'].submit();
	  }
	}

</script>

<script>
	$(function() {
		
		$('#dob').datetimepicker({
			format : 'DD/MM/YYYY',
			
		});
		
	});
</script>


<title>Users</title>
</head>

<body>

	
			
				<%@ include file="header.jsp"%>
				
				
<div class="row" id="row2">
  <div class="col-md-2" id="col1"></div>
  
  <div class="col-md-4" id="col2">
    <c:choose>
     <c:when test="${editMode==true}">
  			 <div class="font-bold">Edit User</div>
  	</c:when>
  	<c:otherwise>
  	<div class="font-bold">Add New User</div>
  	</c:otherwise>		 
  </c:choose>
  
  
 
				<form:form method="POST"  modelAttribute="userDetails">
  <c:if test="${showError==true}">
									<div class="row">
										<div class="alert alert-danger" role="alert">
											<span
												class="glyphicon glyphicon-remove-sign alert-icon hidden-xs"
												aria-hidden="true"></span> ${message}
										</div>
									</div>
								</c:if>
  <div class="form-group">
    <label for="uname">User id</label>
    <form:input type="text" class="form-control" id="uname" name="uname" path="uname" placeholder="User name.."/>
    <form:errors path="uname" cssClass="validation-error"></form:errors>
  </div>
  <div class="form-group">
    <label for="uname">Password</label>
    <form:input type="password" class="form-control" id="password" name="password" path="password" placeholder="password.."/>
   <form:errors path="password" cssClass="validation-error"></form:errors>
  </div>
  
 <div class="form-group">
    <label for="uname">Re-type Password</label>
    <form:input type="password" class="form-control" id="password1" name="password1" path="password1" placeholder="re-type password.."/>
   <form:errors path="password1" cssClass="validation-error"></form:errors>
  </div>
  
   <div class="form-group">
    <label for="email">Email address</label>
    <form:input type="email" class="form-control" id="email" name="email" path="email"  placeholder="Email.."/>
  <form:errors path="email" cssClass="validation-error"></form:errors>
  </div>
  
  <div class="form-group">
												<form:label for="dob" class="Date of birth"
													path="dob">To
												</form:label>
												
													<div class="input-group date" id="dob">
														<span class="input-group-addon"><span
															class="glyphicon glyphicon-calendar"></span> </span>
														<form:input type="text" class="form-control" id="dob"
															path="dob" placeholder="Date of birth"></form:input>

													</div>

												
											</div>
  
  <c:if test="${editMode==true}">
   <div class="form-group">
    <label for="">Status:</label>
  <form:select class="form-control" id="enabled" path="enabled">
    <form:option value="enabled" label="">Enabled</form:option>
    <form:option value="disabled" label="">Disabled</form:option>
    
  </form:select>
   </div>
 </c:if>



<%-- <input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/> --%>
    <c:choose>
     <c:when test="${editMode==true}">
     <button  class="btn btn-primary" id="updateusers" formaction="${pageContext.request.contextPath}/user/updateUser">Save User</button>
     </c:when>
     <c:otherwise>
     
    <button  class="btn btn-primary" id="addusers" formaction="${pageContext.request.contextPath}/user/saveUser">Save User</button>
    </c:otherwise>
    </c:choose>
  </form:form>  
  
<%@ include file="footer.jsp"%>
				
</div>
</div>		





</body>
</html>