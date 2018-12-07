<%@ page session="true" %>
<%-- <%@ taglib uri="http://jakarta.apache.org/struts/tags-html"        prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-html-el"             prefix="html-el" %>
<%@ taglib uri="http://struts.apache.org/tags-bean-el"             prefix="bean-el" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"        prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"       prefix="tiles" %>
 --%><%@ taglib uri="http://java.sun.com/jsp/jstl/core"                 prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"                  prefix="fmt"%>
<%-- <%@ taglib uri="jzentags"                prefix="jhtml" %> --%>
<%-- <%@ taglib uri="http://acegisecurity.org/authz"                    prefix="authz" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"            prefix="fn"%>

<c:if test="${requestScope.pagingBean != null && requestScope.pagingBean.totalNumResults > requestScope.pagingBean.numResultsPerPage}">




<c:if test="${requestScope.pagingBean.showStart}">	
<button class=" btn-link btn-anchor "  name="First Page"  formaction="${pageContext.request.contextPath}/searchCurrentInvoices?page=1" >First</button>

	
</c:if>
<c:if test="${!requestScope.pagingBean.showStart}">
	<span style="color:#ccc;float: left">First</span>
</c:if>  

<c:if test="${requestScope.pagingBean.isPrevious}">
	<button class="btn-link btn-anchor "  name="Previous Page"  formaction="${pageContext.request.contextPath}/searchCurrentInvoices?page=${requestScope.pagingBean.pageNo - 1}" >&laquo;Previous | </button>
</c:if>
<c:if test="${!requestScope.pagingBean.isPrevious}">
	<span style="color:#ccc;float: left;">&laquo; Previous | </span> 
</c:if>               

<span style="float: left;">

</span>
<span style="float: left;">
<c:forEach items="${requestScope.pagingBean.pages}" var="pageNo" varStatus="pageStatus">

 <c:choose>
  <c:when test="${pageNo == requestScope.pagingBean.pageNo || (requestScope.pagingBean.pageNo > requestScope.pagingBean.totalNumPages && requestScope.pagingBean.totalNumPages == pageNo)}">
  <span style="float: left;">   <label class="pageNum"><c:out value="${pageNo}"/> | </label></span>
  </c:when>
  <c:otherwise>
  
  	<button class="btn-link btn-anchor "  name=" Page"  formaction="${pageContext.request.contextPath}/searchCurrentInvoices?page=${pageNo}" ><c:out value="${pageNo}" /> | </button>
	
			</c:otherwise>
</c:choose>		

</c:forEach>
</span>



<c:if test="${requestScope.pagingBean.isNext}">
	<button class="btn-link btn-anchor "  name=" Next Page"  formaction="${pageContext.request.contextPath}/searchCurrentInvoices?page=${requestScope.pagingBean.pageNo + 1}" ><c:out value="${pageNo}" /> Next &raquo;</button>

</c:if>
<c:if test="${!requestScope.pagingBean.isNext}">
 <span style="color:#ccc;">Next &raquo;</span>
</c:if>
      
<c:if test="${requestScope.pagingBean.showEnd}">
<button class="btn-link btn-anchor "  name=" Last Page"  formaction="${pageContext.request.contextPath}/searchCurrentInvoices?page=${requestScope.pagingBean.totalNumPages}">Last</button>

</c:if>
<c:if test="${!requestScope.pagingBean.showEnd}">
 <span style="color:#ccc;">Last</span>
</c:if>

</c:if>
