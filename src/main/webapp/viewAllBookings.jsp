<%@ page import="java.util.ArrayList"%>
<%@ page import="com.trainreservation.model.Booking"%>

<%
ArrayList<Booking> bookings =
(ArrayList<Booking>)request.getAttribute("bookings");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Bookings</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

<h2>All Bookings</h2>

<table class="table table-bordered">

<tr>
<th>PNR</th>
<th>Passenger</th>
<th>Train</th>
<th>Date</th>
<th>Fare</th>
</tr>

<%
if(bookings != null){

for(Booking booking : bookings){
%>

<tr>
<td><%= booking.getPnr() %></td>
<td><%= booking.getPassengerName() %></td>
<td><%= booking.getTrainName() %></td>
<td><%= booking.getJourneyDate() %></td>
<td>Rs. <%= booking.getFare() %></td>
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