<%@page import="java.util.List"%>
<%@page import="com.DAO.FlightsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flyaway - Members</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: #008080">
<%
	FlightsDAO  fDaoObj = new FlightsDAO();
	List<String>  airportNames = fDaoObj.getAirportNames();
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
  						</tr>
  						</thead>  						
  					</table>
  				</div>  				
  			</div>  			
   		</div>
   </div>  			
   		</div>
   </div>
</div>
</body>
</html>