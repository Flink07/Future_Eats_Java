<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>

<link rel="stylesheet" type="text/css" href="/css/custom.css"/>
<!-- For any Bootstrap that uses JS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

		<div class="">
			<div>
				<h1><c:out value="${restaurant.name}"/></h1>
				<h2>(added by <c:out value="${restaurant.user.userName}"/>)</h2>
			</div>
		</div>
		<div>
			<h3>Food Type: <c:out value="${restaurant.type}"/></h3>
			<h3>This Restaurant is in: <c:out value="${restaurant.address}"/></h3>
			<hr>
		</div>
		<div>
				<h3><c:out value="${restaurant.description}"/></h3>
				<hr>
		</div>
		<div>
		
		<h5>Existing Recommendation: <c:out value="${restaurant.recommendation}"/> </h5>
		<hr>
		</div>
		<div class="flex"> 
			<!--  <p>"${loggedInUser.id}" +++++++++++ "${restaurant.user.id}</p> -->
		<c:if test="${loggedInUser.id == restaurant.user.id}">
			<a class="btn btn-ouline-warning" href="/restaurants/edit/${restaurant.id}">Edit</a>
			<a class="btn btn-ouline-warning" href="/restaurants/delete/${restaurant.id}">Delete</a>
		</c:if>
		<div>
				<a href="/" class="btn btn-ouline-primary" >Back to Restaurants!</a>
		</div>
	</div>
</body>
</html>