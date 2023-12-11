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
<h1>Expense details</h1>

<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Expense Name:<c:out value="${travel.expense}"></c:out> </h5>
    <p class="card-text">Expense Description: <c:out value="${travel.description}"></c:out></p>
    <p class="card-text">Expense Vendor: <c:out value="${travel.vendor}"></c:out></p>
    <p class="card-text">Expense Amount: <c:out value="${travel.amount}"></c:out></p>
   
    <a href="/travels" class="btn btn-primary">Go back</a>
  </div>
</div>

</body>
</html>