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
<title>ninja</title>
</head>
<body>
<!-- additional tags to add -->
    
<h1>Add Ninja</h1>
<form:form action="/ninjas" method="post" modelAttribute="ninja">
    
    <p class="col-3 d-flex">
        <form:label path="dojo">dojo</form:label>
        <form:errors path="dojo"/>
        <form:select path="dojo">
        <c:forEach var="oneDojo" items="${dojos}">
            <!--- Each option VALUE is the id of the person --->
            <form:option value="${oneDojo.id}" path="dojo">
            <!--- This is what shows to the user as the option --->
                <c:out value="${oneDojo.name}"/>
            </form:option>
        </c:forEach>
    </form:select>
    </p>
    <p class="col-3 d-flex">
        <form:label path="firstname">firstname</form:label>
        <form:errors path="firstname"/>
        <form:input path="firstname"/>
    </p>
    <p class="col-3 d-flex">
        <form:label path="lastname">lastname</form:label>
        <form:errors path="lastname"/>
        <form:textarea path="lastname"/>
    </p>
  
    <p class="col-3 d-flex">
        <form:label path="age">age</form:label>
        <form:errors path="age"/>     
        <form:input type="number" min="10" path="age"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
