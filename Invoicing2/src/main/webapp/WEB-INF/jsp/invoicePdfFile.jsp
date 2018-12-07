<%@ taglib uri="http://pd4ml.com/tlds/pd4ml/2.5" 		prefix="pd4ml" %><%
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core"          	prefix="c" %><%
%><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 		prefix="fmt"%><%
%><%@ taglib uri="http://java.sun.com/jsp/jstl/functions"         prefix="fn"%><%
%><%@page contentType="text/html; charset=ISO8859_1"%><%
%><c:set var="title" scope="request"><c:out value="${fn:replace(continuousUpdateForm.title,' ','-')}"/>-<fmt:formatDate value="${continuousUpdateForm.newDate}" pattern="ddMMyyyyhhmmss"/>.pdf</c:set><%
%><pd4ml:transform	
	pageFormat="LETTER"
	inline="false"
	screenWidth="2000"
	fileName="${title}"	
	pageInsets="30,30,30,30,points"		
	enableImageSplit="false"
	authorName="crb cheqs">

<pd4ml:permissions password="empty" rights="2052" strongEncryption="true"/>
<html>
	<head>
		<title><c:out value="${title}"/></title>		
		<style type="text/css" media="screen">
			@import url(<c:out value="${applicationScope.staticResourcePath}"/>resources/css/standard.css);
			body {font-size:10px; color:#000;}
			table.form_table {margin:0px; width:100%;border-collapse: collapse; }
			table.form_table td {padding: 4px 10px 4px 0px;}	
			table.form_table th {  
			    font-weight: bold;			    
			    padding: 5px 5px 5px 0px;
			    text-align: left;  			    
			}	
			table.form_table td.foot {  
			    font-weight: bold;	
			    padding: 5px 0px;	
			    border-top: 1px solid #666;	    			    			    
			}												
		</style>		
	</head>
	<body style="border:0px solid #000;">	
	<p class="strong" style="font-size:16px;margin-bottom:10px;"><c:out value="${reportForm.title}"/></p>
	<c:if test="${not empty continuousUpdateForm.config.dateFrom and not empty continuousUpdateForm.config.dateTo}">
	<p>Date Range: <fmt:formatDate value="${continuousUpdateForm.config.dateFrom}" pattern="dd/MM/yyyy"/> - <fmt:formatDate value="${continuousUpdateForm.config.dateTo}" pattern="dd/MM/yyyy"/></p>	
	</c:if>
	
	<div width="100%" style="margin-top:10px;">
                   									  		
	<table class="form_table" style="border-bottom: 1px solid #666;">
		<thead>
		<tr>
			<c:forEach items="${continuousUpdateForm.fieldMap}" var="field">
			<th style="border-bottom: 1px solid #666;border-top: 1px solid #666;">							
			<c:out value="${field.value}"/>					  																											
			</th>									
			</c:forEach>		
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${pagingBean.results}" var="rec">
		<tr>		
		
				<c:forEach items="${continuousUpdateForm.fieldMap}" var="field">
				<td>		
					<c:choose>																	
					  <c:when test="${fn:containsIgnoreCase(field.key,'tupdateServiceRunDate')}">
						<fmt:formatDate value="${rec[field.key]}" pattern="dd/MM/yyyy"/>
					  </c:when>
					  <c:when test="${fn:containsIgnoreCase(field.key,'dob')}">
						<fmt:formatDate value="${rec[field.key]}" pattern="dd/MM/yyyy"/>
					  </c:when>					  
					  <c:otherwise>
					  	<c:out value="${rec[field.key]}"/>
					  </c:otherwise>
					</c:choose>																												
				</td>					
				
				</c:forEach>		
								
		</tr>
		</c:forEach>
		<c:if test="${empty pagingBean.results}">
		<tr>
		<td colspan="<c:out value="${fn:length(continuousUpdateForm.fieldMap)}"/>">No results were found</td>
		</tr>
		</c:if>
		</tbody>
		<tfoot>
			<tr>
			<td class="foot" colspan="<c:out value="${fn:length(continuousUpdateForm.fieldMap)}"/>">
				<div style="float:right;"><c:out value="${pagingBean.showingResults}"/></div>							
			</td>
			</tr>
		</tfoot>			
	</table>	
	
	
	</div>

	</body>
</html>
</pd4ml:transform>