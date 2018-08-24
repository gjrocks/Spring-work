<!DOCTYPE html>
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
    	
    	  $('#login-form-link').click(function(e) {
    			$("#login-form").delay(100).fadeIn(100);
    	 		$("#register-form").fadeOut(100);
    			$('#register-form-link').removeClass('active');
    			$(this).addClass('active');
    			e.preventDefault();
    		});
    		$('#register-form-link').click(function(e) {
    			$("#register-form").delay(100).fadeIn(100);
    	 		$("#login-form").fadeOut(100);
    			$('#login-form-link').removeClass('active');
    			$(this).addClass('active');
    			e.preventDefault();
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
    <li><a href="person/allPersons">All people</a></li>
    <li><a href="#messages">Messages</a></li>
    <li><a href="#contact">Contact-Us</a></li>

  </ul>
 </nav>

 </div></div>
  <!--  <div class="col-md-3" id="col3">.col-mid-3</div> -->
</div>
<hr></div>
<div class="container">
    	<div class="row">
			<div class="col-md-5 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action="login" method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
									 <input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="#" tabindex="5" class="forgot-password">Forgot Password?</a>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>