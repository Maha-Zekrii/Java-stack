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
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
       <th scope="col">action</th> 
      
      
    </tr>
  </thead>
  <tbody>
    
     <c:forEach var="onetravel" items="${travels}">
      <tr>
      <td><c:out value="${onetravel.id}"></c:out></td>
      <td><a href="/travels/${onetravel.id}"><c:out value="${onetravel.expense}"></c:out></a></td>
      <td><c:out value="${onetravel.vendor}"></c:out></td>
      <td>$<c:out value="${onetravel.amount}"></c:out></td>
      <td><span><a href="/travels/${onetravel.id}/edit">edit</a></span>   <span> <form action="/travels/${onetravel.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form></span></td>
    </tr>       
    </c:forEach>
    
  
  </tbody>
</table>


<h1>Save Travels</h1>
<form:form action="/travels" method="post" modelAttribute="travel">
    <p class="col-3 d-flex">
        <form:label path="expense">Expense:</form:label>
        <form:input  path="expense"/>        
        <form:errors path="expense"/>
    </p>
    <p class="col-3 d-flex">
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
     <p class="col-3 d-flex">
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:textarea  path="description"/>
    </p>   
  
    <p class="col-3 d-flex">
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" min="0" path="amount"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>