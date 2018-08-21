<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
<a href="person/allPersons">All Persons</a>
<a href="person/addPerson">Add Person</a>
<!-- <a href="logout">Logout</a> -->
<a href="#" onclick="document.getElementById('logoutform').submit();">Logout</a>
<form:form action="${pageContext.request.contextPath}/performlogout" method="POST" id="logoutform">
    <!-- <input type="submit" value="Logout" /> -->
</form:form>
<hr />
