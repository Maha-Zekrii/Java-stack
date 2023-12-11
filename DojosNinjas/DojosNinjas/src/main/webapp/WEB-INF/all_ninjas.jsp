<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>book</title>
</head>
<body>

<table class="table">
  <thead>
    <tr>
      <th scope="col">firstname</th>
      <th scope="col">lastname</th>
      <th scope="col">age</th>
       <th scope="col">dojo</th>
     
      
      
    </tr>
  </thead>
  <tbody>
    
     <c:forEach var="oneninja" items="${ninjas}">
      <tr>      
      <td><c:out value="${oneninja.firstname}"></c:out></td>
      <td><c:out value="${oneninja.lastname}"></c:out></td>
      <td><c:out value="${oneninja.age}"></c:out></td>
      <td><c:out value="${oneninja.dojo.name}"></c:out></td>
    </tr>       
    </c:forEach>
    
  
  </tbody>
</table>
 
</body>
</html>