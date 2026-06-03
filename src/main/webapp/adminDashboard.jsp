<%@ page import="com.trainreservation.model.User"%>

<%
User user=(User)session.getAttribute("user");

if(user==null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

<div class="card p-4">

<h2>Station Master Dashboard</h2>

<p>Welcome Admin</p>

<a href="ViewUsersServlet"
class="btn btn-primary m-2">
View Users
</a>

<a href="ViewAllBookingsServlet"
class="btn btn-success m-2">
View Bookings
</a>

<a href="SearchTrainServlet"
class="btn btn-warning m-2">
Manage Trains
</a>

<a href="logout.jsp"
class="btn btn-danger m-2">
Logout
</a>

</div>

</div>

</body>
</html>