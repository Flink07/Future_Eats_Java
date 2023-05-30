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
<link rel="stylesheet" type="text/css" href="/css/dashstyle.css">
<!-- For any Bootstrap that uses JS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
		<div class="container filter">
			<div class="flex justify-around" >
				<div>
					<h1>Welcome <c:out value="${loggedInUser.userName}"/>!</h1>
					<h3>Restaurants You should Visit Soon: </h3>
				</div>
				<div>
					<a href ="/users/logout" class="btn btn-danger">logout</a>
				</div>
			</div>
			<div>
				<table class="table">
				<thead >
					<tr>
						<th>Restaurant Name</th>
						<th>Food Type</th>
						<th>Address or City</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="restaurant" items="${allRestaurants}">
						<tr>
							<td><a  href="/restaurants/display/${restaurant.id}"><c:out value="${restaurant.name}"/></a></td>
							<td><c:out value="${restaurant.type}"/></td>
							<td><c:out value="${restaurant.address}"/></td>
							<td>
							<c:if test="${loggedInUser.id == restaurant.user.id}">
								
								<a class="btn btn-ouline-warning" href="/restaurants/delete/${restaurant.id}">Delete</a>
							</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href ="/restaurants/create" class="btn btn-success">Add A Future Restaurant To Visit</a>
			</div>
		</div>
		
		

</body>
</html>