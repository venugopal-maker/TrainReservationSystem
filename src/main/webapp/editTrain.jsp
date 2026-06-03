<%@ page import="com.trainreservation.model.Train"%>

<%
Train train =
(Train)request.getAttribute("train");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Train</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container mt-5">

<h2>Edit Train</h2>

<form action="UpdateTrainServlet" method="post">

<input type="hidden"
name="trainId"
value="<%= train.getTrainId() %>">

<input type="text"
name="trainNo"
value="<%= train.getTrainNo() %>"
class="form-control mb-2">

<input type="text"
name="trainName"
value="<%= train.getTrainName() %>"
class="form-control mb-2">

<input type="text"
name="source"
value="<%= train.getSource() %>"
class="form-control mb-2">

<input type="text"
name="destination"
value="<%= train.getDestination() %>"
class="form-control mb-2">

<input type="text"
name="departureTime"
value="<%= train.getDepartureTime() %>"
class="form-control mb-2">

<input type="text"
name="arrivalTime"
value="<%= train.getArrivalTime() %>"
class="form-control mb-2">

<input type="number"
step="0.01"
name="fare"
value="<%= train.getFare() %>"
class="form-control mb-2">

<button class="btn btn-success">
Update Train
</button>

<a href="ViewTrainsServlet"
class="btn btn-secondary">
Back
</a>

</form>

</div>

</body>
</html>