<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<container>
<form action="/login" method="post">
  <div class="mb-3">
    <label for="number"  class="form-label">Pick any number from 5 to 25</label>
    <input type="number" name="number" class="form-control" id="number" min=5 max=25 >
  </div>
   <div class="mb-3">
    <label for="city"  class="form-label">Enter the name of any city</label>
    <input type="text" name="city" class="form-control" id="city">
  </div>
  <div class="mb-3">
    <label for="person"  class="form-label">Enter the name of any Person</label>
    <input type="text" name="person" class="form-control" id="person">
  </div>
   <div class="mb-3">
    <label for="profession" class="form-label">Enter the name of any Profession or hobby</label>
    <input type="text"  name="profession" class="form-control" id="profession">
  </div>
   <div class="mb-3 ml-6 mr-6">
    <label for="living"  class="form-label">Enter the name of any living things</label>
    <input type="text" name="living" class="form-control" id="living">
  </div>
  <div class="mb-3">
    <label for="word"  class="form-label">Say something nice to someone</label>
   <textarea class="form-control" name="word" placeholder="Leave a comment here" id="word"></textarea>
  </div>
      <label class="form-label">Send and show a friend</label>
  
  <button type="submit" class="btn btn-primary">Send</button>
</form>
   </container>
 

</body>
</html>