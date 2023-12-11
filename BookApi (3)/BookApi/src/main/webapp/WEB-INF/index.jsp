<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

    
<!DOCTYPE html>
<html>
<head>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>book</title>
</head>
<body>

<div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title"><c:out value="${book.title}"/></h5>
    <p class="card-text">Description: <c:out value="${book.description}"/></p>
    <p class="card-text">Language: <c:out value="${book.language}"/></p>
    <p class="card-text">Number of Pages: <c:out value="${book.numberOfPages}"/></p>
       <p class="card-text">Created at: <c:out value="${book.createdAt}"/></p>
    
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>

</body>
</html>