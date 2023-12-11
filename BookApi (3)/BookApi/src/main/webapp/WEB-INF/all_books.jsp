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

<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">title</th>
      <th scope="col">description</th>
      <th scope="col">language</th>
      <th scope="col">number of pages</th>
    </tr>
  </thead>
  <tbody>
    
     <c:forEach var="onebook" items="${books}">
      <tr>
      <td><c:out value="${onebook.id}"></c:out></td>
      <td><a href="/api/books/${onebook.id}"><c:out value="${onebook.title}"></c:out></a></td>
      <td><c:out value="${onebook.description}"></c:out></td>
      <td><c:out value="${onebook.language}"></c:out></td>
      <td><c:out value="${onebook.numberOfPages}"></c:out></td>
    </tr>       
    </c:forEach>
    
  
  </tbody>
</table>

</body>
</html>