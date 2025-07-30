<%@page import="com.models.Flights"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.FlightsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: #008080">
<%
FlightsDAO  fDaoObj = new FlightsDAO();
List<Flights> flyList = fDaoObj.ShowAll();	
%>
<div class="container-fluid">
   <img src="pics/Flyaway.png"  width="100%" height="200" />
   <jsp:include page="AdminLinks.html"/>
   <br />
   <div class="row">
   <div class="col-lg-12">
   		<a href="AddFlights.jsp" class="btn btn-warning">Add New Flight</a>
   </div>
   </div>

   <div class="row">
   <div class="col-lg-12">
   		<div class="card">
   			<div class="card-header">
   			<b>Flights Information</b>
   			</div>
   			<div class="card-body">
   				<table class="table  table-warning">
   					<thead>
   					<tr>
   						<th>Flight ID</th>
   						<th>Flight Name</th>
   						<th>Airlines Code</th>
   						<th>Strats From</th>
   						<th>Ends To</th>
   						<th>Ticket Price</th>
   						<th>Available Seats</th>
   					</tr>
   					</thead>
   					<tbody>
   					<%
   						for(Flights fly : flyList)
   						{
   					%>
   					<tr>
   					<td><%=fly.getFid() %></td>
   					<td><%=fly.getFname() %></td>
   					<td><%=fly.getAircode() %></td>
   					<td><%=fly.getSource() %></td>
   					<td><%=fly.getDestination() %></td>
   					<td><%=fly.getTktprice() %></td>
   					<td><%=fly.getSeats() %></td>
   					</tr>
   					<%
   						}
   					%>
   					</tbody>
   				</table>
   			</div>
   		</div>
   </div>
   </div>
</div>
</body>
</html>