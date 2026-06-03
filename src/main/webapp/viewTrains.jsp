<%@ page import="java.util.ArrayList"%>
<%@ page import="com.trainreservation.model.Train"%>

<%
ArrayList<Train> trains =
(ArrayList<Train>)request.getAttribute("trains");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Trains</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">
</head>

<body>

<div class="container mt-5">

<h2>All Trains</h2>

<table class="table table-bordered table-striped">

<tr>
<th>ID</th>
<th>Train No</th>
<th>Train Name</th>
<th>Source</th>
<th>Destination</th>
<th>Departure</th>
<th>Arrival</th>
<th>Fare</th>
</tr>

<%
if(trains != null){

for(Train train : trains){
%>

<tr>
<td><%= train.getTrainId() %></td>
<td><%= train.getTrainNo() %></td>
<td><%= train.getTrainName() %></td>
<td><%= train.getSource() %></td>
<td><%= train.getDestination() %></td>
<td><%= train.getDepartureTime() %></td>
<td><%= train.getArrivalTime() %></td>
<td>Rs.  <%= train.getFare() %></td>

<td>

<a href="EditTrainServlet?id=<%= train.getTrainId() %>"
class="btn btn-warning btn-sm">
Edit
</a>

<a href="DeleteTrainServlet?id=<%= train.getTrainId() %>"
class="btn btn-danger btn-sm"
onclick="return confirm('Delete this train?')">
Delete
</a>

</td>
</tr>

<%
}
}
%>

</table>

<a href="manageTrains.jsp"
class="btn btn-secondary">
Back
</a>

</div>

</body>
</html>