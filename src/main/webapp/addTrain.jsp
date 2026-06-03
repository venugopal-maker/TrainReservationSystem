<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Train</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">
</head>
<body>

<div class="container mt-5">

<h2>Add New Train</h2>

<form action="AddTrainServlet" method="post">

<input type="text"
name="trainNo"
class="form-control mb-3"
placeholder="Train Number"
required>

<input type="text"
name="trainName"
class="form-control mb-3"
placeholder="Train Name"
required>

<input type="text"
name="source"
class="form-control mb-3"
placeholder="Source"
required>

<input type="text"
name="destination"
class="form-control mb-3"
placeholder="Destination"
required>

<input type="text"
name="departure"
class="form-control mb-3"
placeholder="Departure Time"
required>

<input type="text"
name="arrival"
class="form-control mb-3"
placeholder="Arrival Time"
required>

<input type="number"
name="fare"
class="form-control mb-3"
placeholder="Fare"
required>

<button class="btn btn-success">
Add Train
</button>

</form>

<a href="manageTrains.jsp"
class="btn btn-secondary mt-3">
Back
</a>

</div>

</body>
</html>