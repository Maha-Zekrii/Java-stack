<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Manager Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<body>
	<div class="container">
		<div class="d-flex"><h1>Hello ${user.userName} !</h1> <a href="/logout" class="btn btn-info">logout</a></div>
		<h2>All Songs Lab</h2>
		
	

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Title</th>
					<th>Genre</th>
					<th># of contribution</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs }" var="song">

					<tr>
						<td><a href="/songs/${song.id}">${song.title}</a></td>
						<td>${song.genre }</td>
						<td>${song.contribution }</td>					|
                       
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<a href="/songs/new" class="btn btn-primary">New Song</a>
		
		
</body>
</html>