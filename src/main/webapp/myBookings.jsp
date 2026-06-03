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
<title>My Bookings</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container mt-5">

<h2>My Bookings</h2>

<table class="table table-bordered table-striped">

<tr>
<th>PNR</th>
<th>Passenger</th>
<th>Train</th>
<th>Source</th>
<th>Destination</th>
<th>Date</th>
<th>Fare</th>
<th>Action</th>
</tr>

<%
if(bookings != null){

for(Booking booking : bookings){
%>

<tr>
    <td><%= booking.getPnr() %></td>
    <td><%= booking.getPassengerName() %></td>
    <td><%= booking.getTrainName() %></td>
    <td><%= booking.getSource() %></td>
    <td><%= booking.getDestination() %></td>
    <td><%= booking.getJourneyDate() %></td>
    <td>Rs. <%= booking.getFare() %></td>

    <td>
        <a href="ViewBookingServlet?pnr=<%= booking.getPnr() %>"
           class="btn btn-info btn-sm">
           View Details
        </a>

        <a href="CancelTicketServlet?pnr=<%= booking.getPnr() %>"
           class="btn btn-danger btn-sm"
           onclick="return confirm('Are you sure to cancel ticket?')">
           Cancel Ticket
        </a>
    </td>
</tr>

<%
}
}
%>

</table>

<a href="dashboard.jsp"
class="btn btn-secondary">
Back
</a>

</div>

</body>
</html>