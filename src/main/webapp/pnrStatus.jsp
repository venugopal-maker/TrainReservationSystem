<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PNR Status</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

<div class="card p-4">

<h3>Check PNR Status</h3>

<form action="ViewBookingServlet" method="get">

<div class="mb-3">
<label>Enter PNR Number</label>

<input type="text"
name="pnr"
class="form-control"
required>
</div>

<button type="submit"
class="btn btn-primary">
Search
</button>

<a href="dashboard.jsp"
class="btn btn-secondary">
Back
</a>

</form>

</div>

</div>

</body>
</html>