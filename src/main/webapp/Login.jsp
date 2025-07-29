<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - Flyaway</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: #008080">
<div class="container-fluid">
<img src="pics/Flyaway.png"  width="100%" height="200" />
<br /><br />
	<div class="row">
		<div class="col-lg-3"></div>
		<div class="col-lg-6">
			<div class="card">
				<div class="card-header">
				<div class="row">
					<div class="col-lg-6">
					<b>Login - Flyaway</b>
					</div>
					<div class="col-lg-6" style="text-align:right">
					New Member &nbsp;<a href="Members.jsp"><b>Register</b></a>					
					</div>
				</div>
					
				</div>
				<div class="card-body">
				<form method="POST"  action="Login">
					<label>Username</label>
					<input type="text"  name="txtUsername"  class="form-control" required />
					<br />
					<label>Password</label>
					<input type="password"  name="txtPswd"  class="form-control" required />
					<br />
					<input type="submit"  value="Login here"  class="btn btn-success" />
					&nbsp;&nbsp;&nbsp;
					<input type="reset"  value="Clear Form"  class="btn btn-danger" />
				</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>