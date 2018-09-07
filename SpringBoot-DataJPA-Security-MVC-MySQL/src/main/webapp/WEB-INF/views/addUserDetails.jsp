<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Gateway</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
   

    <link href="${pageContext.request.contextPath}/css/gj.css" rel="stylesheet">
     <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

<style>
  .error {
      color: #EF1313;
      font-style: italic;
  }
</style>
  </head>
  <body>
   

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
     <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.css" rel="stylesheet">
     <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
     
     
    <script>
   
    $( function() {
    	$('#dob').datepicker({
            format: "dd/mm/yyyy"
        });  
    	
    //  $( "#dob" ).datepicker();
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
    	
    	
    	/* accountN=$.trim(accountN);
    	var fullName = $('#fullName').val();
        var cust=$('#cust').val();
        
        var dlnum=$('#dl').val(); */
        /* var client =    {

                "fullName" : fullName,

                "accountId" :accountN,

                "bankId" :"obp-bankx-n",

                "customerNumber" : cust,
                "dob" : "1980-05-05",
                "drivingLicence" :dlnum

    } */
       // alert(chatMessage.text);
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
    </script>
    
<div class="container-fluid">
 
<div class="row" id="row1">
<!--   <div class="col-md-2" id="col1"><img src="logo..gif"></div> -->
  <div class="col-md-12" id="col2"><div id="menus">
 <nav>
  <ul>
    
     <li><a href="#home">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/user/allUsers">Users</a></li>
    <li><a href="user/addUser">Register-User</a></li>
    <li><a href="#contact">Contact-Us</a></li>

  </ul>
 </nav>

 </div></div>
  <!--  <div class="col-md-3" id="col3">.col-mid-3</div> -->
</div>
<hr>
 <label for="d">Add User</label>
<hr>

<div class="row" id="row2">
  <div class="col-md-2" id="col1"></div>
  <div class="col-md-4" id="col2"><!-- Standard button -->

<form method="POST" action="saveUser">
  <div class="form-group">
    <label for="uname">User id</label>
    <input type="text" class="form-control" id="uname" name="uname" placeholder="User name..">
  </div>
  <div class="form-group">
    <label for="uname">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="password..">
  </div>
  
 <div class="form-group">
    <label for="uname">Re-type Password</label>
    <input type="password" class="form-control" id="password1" name="password1" placeholder="re-type password..">
  </div>
  
   <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" class="form-control" id="email" name="email" placeholder="Email..">
  </div>
  
  <div class="form-group">
    <label for="dob">Date of birth</label>
    <input type="text" class="form-control" name="dob" id="dob" placeholder="Date of birth..">
   
</div>

<div class="radio">
  <label>
    <input type="radio" name="optionsRadios" id="optionsRadios1" value="ROLE_ADMIN" checked>
    Admin User
  </label>
</div>
<div class="radio">
  <label>
    <input type="radio" name="optionsRadios" id="optionsRadios2" value="ROLE_USER">
    Normal User
  </label>
</div>

<input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/>
<!-- 
String uname;
	String password;
	String email;
	Date dob;
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" name="exampleInputEmail1" placeholder="Email..">
  </div>

  <div class="form-group">
    <label for="mobileNumber">Mobile Number</label>
    <input type="text" class="form-control" id="mobileNumber" name="mobileNumber" placeholder="Mobile Number..">
  </div> -->

<!-- <div class="form-group">
    <label for="dob">DOB</label>
    <input type="text" class="form-control" name="dob" id="dob">
   
</div> -->

  



 <!--  <div class="form-group">
    <label for="dl">UK Driving Licence</label>
    <input type="text" class="form-control" id="dl" name="dl" placeholder="UK Driving Licence..">
  </div>
 -->
<!-- <div class="checkbox">
  <label>
    <input type="checkbox" value="">
    Option one is this and that&mdash;be sure to include why it's great
  </label>
</div>
<div class="checkbox disabled">
  <label>
    <input type="checkbox" value="" disabled>
    Option two is disabled
  </label>
</div>

<div class="radio">
  <label>
    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
    Option one is this and that&mdash;be sure to include why it's great
  </label>
</div>
<div class="radio">
  <label>
    <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
    Option two can be something else and selecting it will deselect option one
  </label>
</div>
<div class="radio disabled">
  <label>
    <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3" disabled>
    Option three is disabled
  </label>
</div> -->
 <!--  <div class="form-group">
    <label for="exampleInputFile">Bank Statement (in PDF)</label>
    <input type="file" id="exampleInputFile" name="file">
   
  </div> -->
<button type="submit" class="btn btn-prim" id="addusers">Add User</button>
  </form>  
</div>





</div>
  </body>
</html>