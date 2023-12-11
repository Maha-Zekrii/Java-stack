<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a course</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<body>
<h1>Start a new Song!!!</h1>
		<form:form action="/songs/new" method="post" modelAttribute="song">
			<div class="container">
				
			
			<div class="form-group">
				<form:label path="title" >Song Title</form:label>
				<form:input type= "text" path="title" class="form-control" />
				<form:errors style="color: red" path="title" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="genre" >Genre</form:label>
				<form:input type="text" path="genre" class="form-control" />
				<form:errors style="color: red" path="genre" class="form-control" />
				
			</div>
			<div class="form-group">
				<form:label path="lyrics" >Add your Lyrics</form:label>
				<form:textarea path="lyrics" class="form-control" />
				<form:errors style="color: red" path="lyrics" class="form-control" />
				
			</div>
			
			
			<input type="submit" value="Submit" class="btn btn-primary" />
			</div>
		</form:form>
		<a href="/home">Cancel</a>
</body>
</html>