<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container mt-5">

<div class="card p-4">

<h3>Change Password</h3>

<form action="ChangePasswordServlet" method="post">

<div class="mb-3">
<label>Old Password</label>
<input type="password"
name="oldPassword"
class="form-control"
required>
</div>

<div class="mb-3">
<label>New Password</label>
<input type="password"
name="newPassword"
class="form-control"
required>
</div>

<button type="submit"
class="btn btn-primary">
Change Password
</button>

<a href="dashboard.jsp"
class="btn btn-secondary">
Back
</a>

</form>

</div>

</div>

</body>
</html>