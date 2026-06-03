<%@ page import="com.trainreservation.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

User user = (User) session.getAttribute("user");

if (user == null) {
    response.sendRedirect("login.jsp");
    return;
}

String trainId = request.getParameter("id");
String source = request.getParameter("source");
String destination = request.getParameter("destination");
String trainName = request.getParameter("trainName");
String fare = request.getParameter("fare");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Ticket</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body style="background:#f4f6f9;">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
            <h2>🚆 Train Ticket Booking</h2>
        </div>

        <div class="card-body">

            <div class="alert alert-info">
                <h4>Train Details</h4>
                <b>Train Name:</b> <%= trainName %><br>
                <b>Source:</b> <%= source %><br>
                <b>Destination:</b> <%= destination %><br>
                <b>Fare:</b> ₹ <%= fare %>
            </div>

            <form action="BookTicketServlet" method="post">
                <input type="hidden" name="trainId" value="<%= trainId %>">
                <input type="hidden" name="source" value="<%= source %>">
                <input type="hidden" name="destination" value="<%= destination %>">
                <input type="hidden" name="trainName" value="<%= trainName %>">
                <input type="hidden" name="fare" value="<%= fare %>">

                <div class="mb-3">
                    <label class="form-label">Journey Date</label>
                    <input type="date" name="journeyDate" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Number of Passengers</label>
                    <select name="passengerCount" class="form-control" onchange="generatePassengers()" required>
                        <option value="">Select</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>

                <div id="passengerContainer"></div>

                <div class="mb-3">
                    <label class="form-label">Coach Type</label>
                    <select name="coachType" class="form-control">
                        <option value="SL">Sleeper (SL)</option>
                        <option value="3A">AC 3 Tier</option>
                        <option value="2A">AC 2 Tier</option>
                        <option value="1A">AC First Class</option>
                    </select>
                </div>

             <%--    <div class="mb-3">
				    <label class="form-label">Berth Preference</label>
				    <select name="berth" class="form-control">
				        <option value="Lower">Lower</option>
				        <option value="Middle">Middle</option>
				        <option value="Upper">Upper</option>
				        <option value="Side Lower">Side Lower</option>
				        <option value="Side Upper">Side Upper</option>
				    </select>
				</div>--%>

                <button type="submit" class="btn btn-success">Confirm Booking</button>
                <a href="SearchTrainServlet" class="btn btn-secondary">Back</a>
            </form>

        </div>
    </div>
</div>

<script>
function generatePassengers() {
    var count = document.getElementsByName("passengerCount")[0].value;
    var container = document.getElementById("passengerContainer");

    container.innerHTML = "";

    for (var i = 1; i <= count; i++) {
        container.innerHTML +=
            "<div class='card p-3 mt-3'>" +
                "<h5>Passenger " + i + "</h5>" +

                "<label class='form-label'>Name</label>" +
                "<input type='text' name='passengerName" + i + "' class='form-control mb-2' required>" +

                "<label class='form-label'>Age</label>" +
                "<input type='number' name='age" + i + "' class='form-control mb-2' required>" +

                "<label class='form-label'>Gender</label>" +
                "<select name='gender" + i + "' class='form-control'>" +
                    "<option value='Male'>Male</option>" +
                    "<option value='Female'>Female</option>" +
                    "<option value='Other'>Other</option>" +
                "</select>" +
                
                "<label class='form-label'>Berth Preference</label>" +
                "<select name='berth" + i + "' class='form-control mb-2'>" +
                    "<option value='Lower'>Lower</option>" +
                    "<option value='Middle'>Middle</option>" +
                    "<option value='Upper'>Upper</option>" +
                    "<option value='Side Lower'>Side Lower</option>" +
                    "<option value='Side Upper'>Side Upper</option>" +
                "</select>" +
                
            "</div>";
    }
}
</script>

</body>
</html>