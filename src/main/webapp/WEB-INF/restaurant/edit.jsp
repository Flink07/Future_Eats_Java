<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<div>
		<div class="flex">
			<h1>Edit Restaurant!</h1>
		</div>
		<form:form action="/restaurants/process/edit/${restaurant.id}" method="post" modelAttribute="restaurant">
			<input type="hidden" name="_method" value="put"/>
			<form:hidden path="user"/>
			<div class="form-group">
				<form:label path="name">Restaurant Name:</form:label>
				<form:input type="text" path="name" class="form-control" /> 
				<form:errors path="name"/>
			</div>
			<div class="form-group">
				<form:label path="type">Type:</form:label>
				<form:select path="type" class="form-control">
						<form:option value =" " path="type">
							
						</form:option> 
						<form:option value ="Mexican" path="type">
							Mexican
						</form:option>
						<form:option value ="Chinese" path="type">
							Chinese
						</form:option>
						<form:option value ="Sushi" path="type">
							Sushi
						</form:option>
						<form:option value ="Mediterranean" path="type">
							Mediterranean
						</form:option>
						<form:option value ="Thai" path="type">
							Thai
						</form:option>
						<form:option value ="Italian" path="type">
							Italian
						</form:option>
						<form:option value ="American BBQ" path="type">
							American BBQ
						</form:option>
						<form:option value ="Korean BBQ" path="type">
							Korean BBQ
						</form:option>
						<form:option value ="Brazilian BBQ" path="type">
							Brazilian BBQ
						</form:option>
						<form:option value ="Peruvian" path="type">
							Peruvian
						</form:option>
						<form:option value ="Tacos" path="type">
							Tacos
						</form:option>
						<form:option value ="Burgers" path="type">
							Burgers
						</form:option>
						<form:option value ="Other Asian" path="type">
							Other Asian
						</form:option>
						<form:option value ="Other Asian" path="type">
							Other
						</form:option>
				</form:select>
				<form:errors path="type"/>
			</div>
			<div class="form-group">
				<form:label path="address">Address or City:</form:label>
				<form:input type="text" path="address" class="form-control" /> 
				<form:errors path="address"/>
			</div>
			<div class="form-group">
				<form:label path="description"> Short Description:</form:label>
				<form:textarea  path="description" rows="4" cols="50" class="form-control"></form:textarea>
				<form:errors path="description"/>
			</div>
			<div class="form-group">
				<form:label path="recommendation">Any Recommendation:</form:label>
				<form:textarea  path="recommendation" rows="4" cols="50" class="form-control"></form:textarea>
				<form:errors path="recommendation"/>
			</div>
			<input type = "submit" value="Submit" class="btn btn-primary" />
			<a href="/" class="btn btn-ouline-warning">Cancel</a>
		</form:form>
	</div>
</body>
</html>