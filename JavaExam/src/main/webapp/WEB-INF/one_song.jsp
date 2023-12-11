<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a Task</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<body>
<div class="card" style="width: 18rem;">
  
  <div class="card-body">
    <h5 class="card-title">${song.title}</h5>
     <h5 class="card-title">(Started by ${song.user.userName})</h5>
    <p class="card-text">Genre: ${song.genre}</p>
     <p class="card-text">Lyrics: ${song.lyrics}</p>
    <a href="/songs/${song.id}/edit" class="btn btn-primary">Contribute</a>
  </div>
</div>
</body>
</html>