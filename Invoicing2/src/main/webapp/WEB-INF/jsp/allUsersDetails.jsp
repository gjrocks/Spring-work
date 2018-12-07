<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<meta http-equiv="content-type" content="text/html; charset=utf-8" />



<%-- <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/one_patterns.css"
	rel="stylesheet"> --%>
<%-- <link href="${pageContext.request.contextPath}/css/gj.css"
	rel="stylesheet"> --%>
<script
	src="${pageContext.request.contextPath}/js/tablefilter/tablefilter.js"></script>
<!--  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
<script>
  window.Promise || document.write('<script src="https://unpkg.com/es6-promise@3.2.1/dist/es6-promise.min.js"><\/script>');
</script>
<script type="text/javascript">
$(document).ready(function () {
	$('.nav a').filter(function(){return this.href==location.href}).parent().addClass('active').siblings().removeClass('active')
	$('.nav a').click(function(){
		$(this).parent().addClass('active').siblings().removeClass('active')	
	})         
});

</script>
<script>

$( function() {
	
	
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




<title>Users</title>
</head>

<body>

	
			
				<%@ include file="header.jsp"%>
				
				<div class="modal" id="mi-modal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Modal Heading</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">


								<h4 class="modal-title" id="myModalLabel">Please confirm
									deletion of the User account</h4>

								<div class="modal-footer">
									<button type="button"  id="modal-btn-si">Yes</button>
									<button type="button" id="modal-btn-no">No</button>
								</div>
							</div>

							<!-- Modal footer -->
							<!-- <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div> -->

						</div>
					</div>
				</div>

				<form method="POST" action="deleteUser" name="delForm">
					<input type="hidden" name="usern" id="usern" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
				<div class="row" id="row2">
  <div class="col-md-1" id="col1"></div>
  
  <div class="col-md-8" id="col2">
   <div class="font-bold">View Users</div>
<c:if test="${showError==true}">
									<div class="row">
									
										<div class="alert alert-danger" role="alert">
											<span
												class="glyphicon glyphicon-remove-sign alert-icon hidden-xs"
												aria-hidden="true"></span> ${message}
										</div>
										</div>
									
								</c:if>
								
								</div>
								</div>
								

				<div id="showTable" class="panel">
					<table id="demo" width="100%">
						<thead>
							<tr>
								<th>User Name</th>
								<th>Email</th>
								<th>Date of Birth</th>
								<th>User creation date</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									<td>${user.uname}
									<c:if test="${user.displayStatus!='Deleted'}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
										href="${pageContext.request.contextPath}/user/addUser?usern=${user.uname}">[edit]</a>
										
										
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);"
										onclick="showAlert('${user.uname}');return false">[delete]</a>
										</c:if>
									</td>
									<td>${user.email}</td>
									<td>${user.dobDisplay}</td>
									<td>${user.createdDate}</td>
									<td>${user.displayStatus}</td>
									<%-- <td>${person.userid}</td> --%>

								</tr>
							</c:forEach>
						</tbody>
					</table>

<%@ include file="footer.jsp"%>

				</div>
			

	

	<script>
	 var filtersConfig = {
        base_path: '${pageContext.request.contextPath}/js/tablefilter/',
        /* paging: {
          results_per_page: ['Records: ', [10, 25, 50, 100]]
        }, */
        /* state: {
          types: ['local_storage'],
          filters: true,
          page_number: true,
          page_length: true,
          sort: true
        }, */
        alternate_rows: true,
        btn_reset: true,
       /*  rows_counter: true, */
        loader: {
          html: '<div id="lblMsg"></div>',
          css_class: 'myLoader'
        },
        status_bar: {
          target_id: 'lblMsg',
          css_class: 'myStatus'
        },
        col_0: 'hidden',
       /*  col_1: 'select',
        col_2: 'select', */
        col_types: [
            'number', 'string', 'string',
            'date', 'string', 'string',
            'string', 'date', 'number'
        ],
		extensions:[{
            name: 'sort'
        }]
    };
    var tf = new TableFilter('demo', filtersConfig);
	//tf.emitter.on(['initialized'], initSelectionListeners);

    tf.init();
	
	var selectedRows = [];

    var selectedCss = 'selected';

    // Initialize checkboxes listeners
    function initSelectionListeners(tf){
      var headerCheckbox = tf.getHeaderElement(0).querySelector('input');
      var checkboxes = getBodyCheckboxes(tf.dom());

      // Add event listener to checkbox in table head
      headerCheckbox.addEventListener('change', toggleAll.bind(tf));

      // Add event listener to all checkboxes in table body
     /*  [].forEach.call(checkboxes, function(checkbox){
        checkbox.addEventListener('change', changeHandler);
      }); */
    }

    // Toggle all checkboxes in valid rows
    function toggleAll(evt){
      var tf = this;
      var headerCheckbox = evt.target;
      var isChecked = headerCheckbox.checked;
      var checkboxes = getBodyCheckboxes(tf.dom());
      var filteredRows = tf.getValidRows();

      [].forEach.call(checkboxes, function(checkbox){
        var row = getRowElement(checkbox);
        var rowIndex = row.rowIndex;
        if(isChecked){
          if(filteredRows.indexOf(rowIndex) !== -1){
            checkbox.checked = true;
            selectRow1(selectedRows, checkbox.value, selectedCss);
          }
        } else {
          checkbox.checked = false;
          deselectRow1(selectedRows, checkbox.value, selectedCss)
        }
      });
    }

    // Checkbox change event handler
    function changeHandler(evt){
      var checkbox = evt.target;
      var row = getRowElement(checkbox);
      var isChecked = checkbox.checked;

      if(isChecked){
        selectRow(selectedRows, row, selectedCss);
      } else {
        deselectRow(selectedRows, row, selectedCss);
      }
    }

    function changeHandler1(evt,obj){
        var checkbox = evt;
      //  var row = getRowElement(checkbox);
        var isChecked = checkbox.checked;

        if(isChecked){
          selectRow1(selectedRows, obj, selectedCss);
        } else {
          deselectRow1(selectedRows, obj, selectedCss);
        }
      }
    // Select row
    function selectRow(selectedRows, row, cssClass){
      row.classList.add(cssClass);
      storeRowIndex(selectedRows, row.rowIndex);
    }

    function selectRow1(selectedRows, obj, cssClass){
        //row.classList.add(cssClass);
      // selectedRows.push(obj);
  	  storeRowIndex(selectedRows, obj);
      // console.log(row);
      }
    // Deselect row
    function deselectRow(selectedRows, row, cssClass){
      row.classList.remove(cssClass);
      removeRowIndex(selectedRows, row.rowIndex);
    }
    function deselectRow1(selectedRows, obj, cssClass){
        //row.classList.remove(cssClass);
       // selectedRows.splice(selectedRows.indexOf(obj), 1);
    	removeRowIndex(selectedRows, obj);
      }
    // Store selected row index
    function storeRowIndex(selectedRows, rowIndex){
      if(selectedRows.indexOf(rowIndex) === -1){
        selectedRows.push(rowIndex);
      }
    }

    // Remove row index previously selected
    function removeRowIndex(selectedRows, rowIndex){
      selectedRows.splice(selectedRows.indexOf(rowIndex), 1);
    }

    // Get all checkboxes in table body
    function getBodyCheckboxes(table){
      var tBody = table.tBodies[0];
      return tBody.getElementsByTagName('input');
    }

    // Get the parent row element
    function getRowElement(element){
      while(element !== null){
        if(element.nodeName === 'TR'){
          return element;
        }
        element = element.parentNode;
      }
      return null;
    }

  

</script>



</body>
</html>