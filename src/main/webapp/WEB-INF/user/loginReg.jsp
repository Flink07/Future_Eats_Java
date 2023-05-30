<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
    href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>

<link rel="stylesheet" type="text/css" href="/css/custom.css"/>
<!-- For any Bootstrap that uses JS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
 <link rel="stylesheet" href="/static/loginstyle.css">
<title>Login Registration</title>
</head>
<body>
    <div class="container">
    	<div>
    		<h1 class="">Future Eats</h1>
    		<h3 class="">Because Good Food Should Be Remembered</h3>
    	 </div>
        <div class="row">
            <div class="col">
                <h1>Register</h1>
                <form:form action="/users/process/register" method="post" modelAttribute="newUser" class="form">
                    <div class="form-group">
                        <label>User Name</label>
                        <form:input path="userName" class="form-control" />
                        <form:errors path="userName" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <form:input path="email" class="form-control" />
                        <form:errors path="email" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <form:input path="password" class="form-control" type="password"/>
                        <form:errors path="password" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <label>Confirm Password</label>
                        <form:input path="confirm" class="form-control" type="password" />
                        <form:errors path="confirm" class="text-danger" />
                    </div>
                    <input type="submit" value="Register User" class="btn btn-primary" />
                </form:form>
            </div>
            <div class="col">
            <h1>login</h1>
            <form:form action="/users/process/login" method="post" modelAttribute="loginUser" class="form">
                    <div class="form-group">
                        <label>Email</label>
                        <form:input path="email" class="form-control" />
                        <form:errors path="email" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <form:input path="password" class="form-control"  type="password"/>
                        <form:errors path="password" class="text-danger" />
                    </div>
                    <input type="submit" value="login" class="btn btn-primary" />
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>