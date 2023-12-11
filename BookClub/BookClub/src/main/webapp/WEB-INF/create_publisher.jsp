<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<body>
	<div class="container">
		<h1>Create Publisher</h1>
		<hr />

		<form:form action="/publishers" method="post"
			modelAttribute="publisher">
			<form:errors style="color:red;" path="*" />
			<div>
				<form:label path="name">Publisher Name:</form:label>
				<form:input path="name" />
			</div>
			<div>
				<form:label path="location">Publisher Location:</form:label>
				<form:input path="location" />
			</div>
			<button>Submit</button>

		</form:form>
	</div>
</body>
</html>