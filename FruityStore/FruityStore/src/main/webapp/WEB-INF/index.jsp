<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Fruit store</h1>
<table class="table">
  <thead>
    <tr>
      
      <th scope="col">Name</th>
      <th scope="col">Price</th>
     
    </tr>
  </thead>
  <tbody>
    <c:forEach var="onefruit" items="${fruits}">
    <tr>      
      <td><c:out value="${onefruit.getName()}"></c:out></td>
      <td><c:out value="${onefruit.getPrice()}"></c:out></td>      
    </tr>
    </c:forEach>
    
   
   
  </tbody>
</table>

</body>
</html>