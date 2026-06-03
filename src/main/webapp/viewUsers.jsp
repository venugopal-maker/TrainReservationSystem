<%@ page import="java.util.ArrayList"%>
<%@ page import="com.trainreservation.model.User"%>

<%
ArrayList<User> users =
(ArrayList<User>)request.getAttribute("users");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Users</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">
</head>

<body>

<div class="container mt-5">

<h2>Registered Users</h2>

<table class="table table-bordered table-striped">

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Role</th>
</tr>

<%
if(users != null){

for(User user : users){
%>

<tr>
<td><%= user.getId() %></td>
<td><%= user.getName() %></td>
<td><%= user.getEmail() %></td>
<td><%= user.getMobile() %></td>
<td><%= user.getRole() %></td>
</tr>

<%
}
}
%>

</table>

<a href="stationMasterDashboard.jsp"
class="btn btn-secondary">
Back
</a>

</div>

</body>
</html>