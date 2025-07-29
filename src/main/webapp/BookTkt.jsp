<%@page import="com.models.Flights"%>
<%@page import="com.DAO.FlightsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Process</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body style="background-color: #008080">
<%
	String fid = request.getParameter("fid");
	FlightsDAO fDao = new FlightsDAO();
	Flights flight = fDao.SearchFlightsBasedOnID(fid);
%>
<div class="container-fluid">
   <img src="pics/Flyaway.png"  width="100%" height="200" />
   <jsp:include page="MemberLinks.jsp"/>
   <br />
      <div class="card">
  		<div class="card-body">
  			<div class="row">
  				<div class="col-lg-4"></div>
  				<div class="col-lg-4">
  					<table class="table table-warning">
  						<tr>
  							<th>Airlines</th>
  							<td><%=flight.getFname() %> </td>  						
  						</tr>

  						<tr>
	  						<th>Source</th>
  							<td><%=flight.getSource() %> </td>  						
  						</tr>

  						<tr>
	  						<th>Destination</th>
  							<td><%=flight.getDestination() %> </td>  						
  						</tr>

  						<tr>
	  						<th>Ticket Amount</th>
  							<td><%=flight.getTktprice() %> </td>  						
  						</tr>
  					</table>
  					<p style="text-align:center">
  						<a href="Bookings?fid=<%=flight.getFid() %>" class="btn btn-info"><b>Click Here To Complete Booking</b></a>
  					</p>
  					
  					<p style="color:red;">
  						<b>Rs. <%=flight.getTktprice() %> amount will be deducted from your Card.</b>
  					</p>
  				</div>
  				<div class="col-lg-4"></div>
  			</div>
   		</div>
   </div>
</div>
</body>
</html>