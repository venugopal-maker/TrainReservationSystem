<%@ page import="com.trainreservation.model.User"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);

User user = (User)session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<nav class="navbar navbar-dark bg-primary">
<div class="container">

<span class="navbar-brand">
 Train Reservation System
</span>

<a href="changePassword.jsp"
class="btn btn-danger m-2">
Change Password
</a>


<a href="logout.jsp" class="btn btn-light">
Logout
</a>

</div>
</nav>

<div class="container mt-5">

<h2>Welcome, <%= user.getName() %></h2>

<div class="card p-4 mt-3">

<h4>User Dashboard</h4>




<a href="SearchTrainServlet" class="btn btn-success m-2">
Search Trains
</a>


<a href="MyBookingsServlet"class="btn btn-warning m-2">
My Bookings
</a>


<a href="pnrStatus.jsp"
class="btn btn-info m-2">
PNR Status
</a>


</div>

</div>

</body>
</html>