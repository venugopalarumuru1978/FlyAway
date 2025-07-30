<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AirLines</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body style="background-color: #008080">
   <div class="container-fluid">
   <img src="pics/Flyaway.png"  width="100%" height="200" />
   <jsp:include page="AdminLinks.html"/>
   <br />
   	<div class="row">
   	<div class="col-lg-3"></div>
   	<div class="col-lg-6">
   		<div class="card">
   			<div class="card-body">
   			<form method="POST" action="AddAirlines">
   			<label>Airlines Name </label>
   			<input type="text"  name="txtAirname" class="form-control" required />
   			<br />
   			<input type="submit" value="Add Airlines" class="btn btn-success">
   			</form>
   			</div>
   		</div>
   	</div>
   	<div class="col-lg-3"></div>
   	</div>
   	<br />
   	<div class="row">
   	<div class="col-lg-3"></div>
   	<div class="col-lg-6">
   	<div class="card">
   	<div class="card-header">
   		<b>Airlines Information</b>
   	</div>
   	<div class="card-body">
   		<jsp:include page="ShowAirlines.jsp"/>
   	</div>
   	</div>
   	</div>
   	<div class="col-lg-3"></div>
   	</div>
   </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>