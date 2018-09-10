<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Invoice</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
   

    <link href="${pageContext.request.contextPath}/css/gj.css" rel="stylesheet">
     <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

  </head>
  <body>
   

    
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
     
    <script>
   
    $( function() {
    	
    	$('#example').DataTable();
    	
    	
    	 $("#modal-btn-si").on("click", function(){
    		 handleModalResponse(true);
    		    $("#mi-modal").modal('hide');
    		  });
    		  
    		  $("#modal-btn-no").on("click", function(){
    			  handleModalResponse(false);
    		    $("#mi-modal").modal('hide');
    		  });
    	
    	
  $('#getallusers').on('click', function(event) {
           
	  getUsers();
           });
    
    //  var dataSet=${data};
    
    	/*  $('#example').DataTable( {
    	        "data": dataSet,
    	        "columns": [
    	            { "data": "fname" },
    	            { "data": "lname" },
    	            { "data": "address" },
    	            { "data": "userid" },
    	            { "data": "mobileNumber" },
    	            { "data": "email" }
    	        ]
    	    } ); */
    } );
    
    function handleModalResponse(confirm){
    	  if(confirm){
    	 		  //submitForm('delForm');
    	 		 document.forms['delForm'].submit();
    	  }
    	}
    
    function showTable(dataSet){
    	$('#example').DataTable( {
	        "data": dataSet,
	        "columns": [
	            { "data": "fname" },
	            { "data": "lname" },
	            { "data": "address" },
	            { "data": "userid" },
	            { "data": "mobileNumber" },
	            { "data": "email" }
	        ]
	    } );
    	
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
    
    function showAlert(userName){
    	  $("#usern").val(userName);
    	  $("#mi-modal").modal('show');
    		return false;
    }
    </script>
    
<div class="container-fluid">
 
<div class="row" id="row1">
<!--   <div class="col-md-2" id="col1"><img src="logo..gif"></div> -->
  <div class="col-md-12" id="col2"><div id="menus">
 <nav>
  <ul>
    
    <li><a href="#home">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/user/allUsers">Users</a></li>
    <li><a href="${pageContext.request.contextPath}/user/addUser">Register-User</a></li>
    <li><a href="#contact">Contact-Us</a></li>

  </ul>
 </nav>

 </div></div>
  <!--  <div class="col-md-3" id="col3">.col-mid-3</div> -->
</div>
<hr></div>
All Users 
<hr></hr>


<div class="container">
    	<div class="row">
			<div class="col-md-10">
<!-- <table id="example" class="display"></table> -->
<form method="POST" action="deleteUser" name="delForm">
<input type="hidden" name="usern" id="usern"/>
<input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/>
</form>
<table id="example" class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>User Name</th>
                <th>Email</th>
                 <th>Date of Birth</th> 
                <th>User creation date</th>
                <th>Enabled</th>
            </tr>
        </thead>
        <tbody>
      
   
        <c:forEach var="user" items="${users}">	 
            <tr>
								<td>${user.username}<a
									href="${pageContext.request.contextPath}/user/addUser?usern=${user.username}">[edit]</a>
									&nbsp;<a
									href="javascript:void(0);"
									onclick="showAlert('${user.username}');return false">[delete]</a>
								</td>
								<td>${user.email}</td>
                <td>${user.dob}</td>
                <td>${user.dateCreated}</td>
                <td>${user.enabled}</td>
                <%-- <td>${person.userid}</td> --%>
              
            </tr>
            </c:forEach>
            </tbody>
            </table>
</div>
</div>
</div>

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="mi-modal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Please confirm deletion of the User account</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="modal-btn-si">Yes</button>
        <button type="button" class="btn btn-primary" id="modal-btn-no">No</button>
      </div>
    </div>
  </div>
</div>


  </body>
</html>