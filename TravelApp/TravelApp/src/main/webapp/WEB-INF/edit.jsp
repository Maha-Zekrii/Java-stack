<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>book</title>
</head>
<body>
<!-- additional tags to add -->
    
<h1>Edit Expense</h1>
<form:form action="/travels/${travel.id}/edit" method="post" modelAttribute="travel">
    <input type="hidden" name="_method" value="put">
    <p class="col-3 d-flex">
        <form:label path="expense">Expense</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </p>
    <p class="col-3 d-flex">
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:textarea path="vendor"/>
    </p>
    <p class="col-3 d-flex">
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
  
    <p class="col-3 d-flex">
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" min="0" path="amount"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
