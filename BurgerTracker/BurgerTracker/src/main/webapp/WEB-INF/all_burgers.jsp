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
      <th scope="col">id</th>
      <th scope="col">name</th>
      <th scope="col">Restaurant name</th>
      <th scope="col">rating</th>
      
    </tr>
  </thead>
  <tbody>
    
     <c:forEach var="oneburger" items="${burgers}">
      <tr>
      <td><c:out value="${oneburger.id}"></c:out></td>
      <td><c:out value="${oneburger.name}"></c:out></td>
      <td><c:out value="${oneburger.restaurantname}"></c:out></td>
      <td><c:out value="${oneburger.rating}"></c:out></td>
    </tr>       
    </c:forEach>
    
  
  </tbody>
</table>


<h1>New Book</h1>
<form:form action="/burgers" method="post" modelAttribute="burger">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="restaurantname">Restaurant name</form:label>
        <form:errors path="restaurantname"/>
        <form:input path="restaurantname"/>
    </p>
  
    <p>
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>     
        <form:input type="number" min="0" max="5" path="rating"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>