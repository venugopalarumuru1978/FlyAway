<%@page import="com.models.Airports"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.AirportsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airports</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: #008080">
   <div class="container-fluid">
   <img src="pics/Flyaway.png"  width="100%" height="200" />
   <jsp:include page="AdminLinks.html"/>
   <br />
    <div class="row">
   	<div class="col-lg-1"></div>
   	<div class="col-lg-10">
   	<div class="card">
   		<div class="card-header"><b>New Airports</b></div>
   		<div class="card-body">
   			<form method="POST" action="AddAirports">
   			<div class="row">   			
   				<div class="col-lg-3">
   					<label>Airport Code</label>
   					<input type="text"  name="txtApCode" class="form-control" required/>
   				</div>
   				<div class="col-lg-3">
   					<label>Airport Name</label>
   					<input type="text"  name="txtApName" class="form-control" required/>
   				</div>
   				
   				<div class="col-lg-3">
   					<label>Airport City</label>
   					<input type="text"  name="txtApCity" class="form-control" required/>
   				</div>
   				
   				<div class="col-lg-3">
   					<label>Airport Country</label>
   					<input type="text"  name="txtApCtry" class="form-control" required/>
   				</div>
   				
   			</div>
   			<br />
   			<div class="row">
   				<div class="col-lg-12" style="text-align:center">
   					<input type="submit"  value="Add Airport"  class="btn btn-success" />
   				</div>
   			</div>   			
   		</form>
   		</div>   		
   	</div>
   	</div>
   	<div class="col-lg-1"></div>
   </div>
   <%
   		AirportsDAO  apDao = new AirportsDAO();
   		List<Airports>  apList = apDao.ShowAll();
   %>
   <br />
   <div class="row">
   	<div class="col-lg-1"></div>
   	<div class="col-lg-10">
   		<div class="card">
   			<div class="card-header">
   				<b>Airports Informations</b>   				
   			</div>
   			<div class="card-body">
   				<table class="table table-dark">
   					<thead>
   						<tr>
   						<th>Airport Code</th>
   						<th>Airport Name</th>
   						<th>Airport City</th>
   						<th>Airport Country</th>
   						</tr>
   					</thead>
   					
   					<tbody>
   					<%
   					for(Airports apObj : apList)
   					{
   					%>
   					<tr>
	   					<td>
	   						<%=apObj.getAp_code() %>
	   					</td>
	   					<td>
	   						<%=apObj.getAp_name() %>
	   					</td>
	   					<td>
	   						<%=apObj.getCity() %>
	   					</td>
	   					<td>
	   						<%=apObj.getCountry() %>
	   					</td>   					
   					</tr>
   					<%
   					}
   					%>
   					</tbody>
   				</table>
   			</div>
   		</div>
   	</div>
   	<div class="col-lg-1"></div>
   </div>
</div>
</body>
</html>