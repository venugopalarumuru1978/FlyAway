<%@page import="com.models.Flights"%>
<%@page import="java.util.List"%>
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
String source = request.getParameter("ddlSource");
String dest = request.getParameter("ddlDest");

FlightsDAO  fDao = new FlightsDAO();
List<String>  airportNames = fDao.getAirportNames();
List<Flights> fList = fDao.SearchFlights(source, dest);		
%>
<div class="container-fluid">
   <img src="pics/Flyaway.png"  width="100%" height="200" />
   <jsp:include page="MemberLinks.jsp"/>
   <br />
   
   <div class="card">
  		<div class="card-body">
  		<form method="POST" action="BookingFun.jsp">
  			<div class="row">
  				<div class="col-lg-3"></div>
  				<div class="col-lg-2">
  					<label>Source</label>
  					<select name="ddlSource" class="form-select">
  						<option value="-1">Select Source</option>
  						<%
  							for(String aname : airportNames)
  							{
  						%>	
  							<option value='<%=aname %>'><%=aname %></option>
  						<%
  							}
  						%>
  					</select>
  				</div>
  				<div class="col-lg-2">
  				  	<label>Destination</label>
  					<select name="ddlDest" class="form-select">
  						<option value="-2">Select Destination</option>
  						<%
  							for(String aname : airportNames)
  							{
  						%>	
  							<option value='<%=aname %>'><%=aname %></option>
  						<%
  							}
  						%>
  					</select>
  				</div>
  				<div class="col-lg-2">
  				<br />
  					<input type="submit" value="Search Flights" class="btn btn-primary" />
  				</div>
  				<div class="col-lg-3"></div>
  			</div>
  			</form>
  	</div>
  			<br />
   <div class="card">
  		<div class="card-body">
  			<div class="row">
  				<div class="col-lg-12">
  					<table  class="table table-warning">
  						<thead>
  						<tr>
  							<th>Source</th>
  							<th>Destination</th>
  							<th>Airlines</th>
  							<th>Ticket Price</th>
  							<th>Booking</th>
  						</tr>
  						</thead>
  						
  						<tbody>
  							<%
  								for(Flights fly : fList)
  								{
  							%>
  								<tr>
  								<td><%=fly.getSource() %> </td>
  								<td><%=fly.getDestination() %> </td>
  								<td><%=fly.getAircode() %> </td>
  								<td><%=fly.getTktprice() %> </td>
  								<td><a href="BookTkt.jsp?fid=<%=fly.getFid() %>"><b>Book Ticket</b></a> </td>
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
</div>
</body>
</html>