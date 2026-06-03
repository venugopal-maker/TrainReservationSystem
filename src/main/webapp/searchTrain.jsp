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






<%@ page import="java.util.ArrayList" %>
<%@ page import="com.trainreservation.model.Train" %>

<%
ArrayList<Train> trains =
(ArrayList<Train>) request.getAttribute("trains");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Available Trains</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-5">

<h2 class="text-center mb-4">
Available Trains
</h2>

<table class="table table-bordered table-striped">

<thead class="table-dark">

<tr>
<th>Train No</th>
<th>Train Name</th>
<th>Source</th>
<th>Destination</th>
<th>Departure</th>
<th>Arrival</th>
<th>Fare</th>
<th>Action</th>
</tr>

</thead>

<tbody>

<%
if(trains != null){

for(Train train : trains){
%>

<tr>

<td><%= train.getTrainNo() %></td>

<td><%= train.getTrainName() %></td>

<td><%= train.getSource() %></td>

<td><%= train.getDestination() %></td>

<td><%= train.getDepartureTime() %></td>

<td><%= train.getArrivalTime() %></td>

<td>&#8377; <%= train.getFare() %></td>

<td>
<a href="bookTicket.jsp?id=<%= train.getTrainId() %>&source=<%= train.getSource() %>&destination=<%= train.getDestination() %>&trainName=<%= train.getTrainName() %>&fare=<%= train.getFare() %>"
class="btn btn-success">
Book Ticket
</a>
</td>

</tr>

<%
}
}
%>

</tbody>

</table>


<a href="dashboard.jsp" class="btn btn-secondary mb-3">
Back
</a>

</div>

</body>
</html>