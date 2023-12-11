<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JAVA</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<body>
   <!-- 		Display Create Book Form -->
		
		<h1>Edit Book</h1>
		<form:form action="/books/${book.id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put">
		
			<div class="container">
				<form:errors style="color: red" path="*" />
			</div>
			<p>
				<form:label path="title">Title</form:label>
				<form:input path="title" />
			</p>
			<p>
				<form:label path="author">author</form:label>
				<form:input path="author" />
			</p>
			<p>
				<form:label path="pages">Pages</form:label>
				<form:input type="number" path="pages" />
			</p>
			<input type="submit" value="Edit" />
		</form:form>
</body>
</html>