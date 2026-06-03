<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

<h2 class="text-center mb-4">User Registration</h2>

<form action="RegisterServlet" method="post">

<div class="mb-3">
<label>Name</label>
<input type="text" class="form-control" name="name" required>
</div>

<div class="mb-3">
<label>Email</label>
<input type="email" class="form-control" name="email" required>
</div>

<div class="mb-3">
<label>Password</label>
<input type="password" class="form-control" name="password" required>
</div>

<div class="mb-3">
<label>Mobile Number</label>
<input type="text" class="form-control" name="mobile" required>
</div>

<button type="submit" class="btn btn-primary">
Register
</button>

<a href="login.jsp" class="btn btn-success">
Login
</a>

</form>

</div>

</body>
</html>