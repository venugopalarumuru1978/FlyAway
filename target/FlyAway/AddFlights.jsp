<%@page import="java.util.Map"%>
<%@page import="com.DAO.FlightsDAO"%>
<%@page import="com.models.Flights"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Flight Information</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: #008080">
<%
	FlightsDAO  fDaoObj = new FlightsDAO();
	List<Flights> flyList = fDaoObj.ShowAll();	
	List<String>  airportNames = fDaoObj.getAirportNames();	
	Map<Integer, String>  mapAirLines = fDaoObj.getAirlines();
%>
<div class="container-fluid">
   <img src="pics/Flyaway.png"  width="100%" height="200" />
   <jsp:include page="AdminLinks.html"/>
   <br />
   <div class="row">
   	<div class="col-lg-12">
   		<div class="card">
   		<div class="card-header"><b>New Flight Information</b></div>
   		<div class="card-body">
   		<form method="POST"  action="AddFlight">
   			<div class="row">
	   			<div class="col-lg-4">
	   				<label>Flight Code</label>
	   				<input type="text"  name="txtFCode" class="form-control" required />
	   			</div>

	   			<div class="col-lg-4">
	   				<label>Flight Name</label>
	   				<input type="text"  name="txtFName" class="form-control" required />
	   			</div>

	   			<div class="col-lg-4">
	   				<label>Airlines Name</label>
	   				<select name="ddlAirlines" class="form-control">
	   				<option  value="-1">Select Airlines</option>
	   				<%
	   				for(Map.Entry<Integer, String>  aname : mapAirLines.entrySet())
	   				{
	   				%>
	   					<option value='<%=aname.getKey() %>'><%=aname.getValue() %></option>
	   				<%
	   				}
	   				%>
	   				</select>
	   			</div>	   			
   			</div>
   			<div class="row">
   				<div class="col-lg-6">
	   				<label>Starts From</label>
	   				<select name="ddlSource" class="form-control">
	   				<option value="-2">Start Airport</option>
	   				<%
	   					for(String airname:airportNames)
	   					{
	   				%>	 
	   					<option value='<%=airname %>'><%=airname %></option>
	   				<%
	   					}
	   				%>  					
	   				</select>
	   				</div>
	   				<div class="col-lg-6">
	   				<label>Ends To</label>
	   				<select name="ddlDest" class="form-control">
	   				<option value="-3">Destination Airport</option>
	   				<%
	   					for(String airname:airportNames)
	   					{
	   				%>	 
	   					<option value='<%=airname %>'><%=airname %></option>
	   				<%
	   					}
	   				%>  					
	   				</select>
	   			</div>
	   			
   			</div>
   			<div class="row">
   				<div class="col-lg-4">
   					<label>Ticket Price</label>
   					<input type="text"  name="txtPrice"  class="form-control" required />
   				</div>

   				<div class="col-lg-4">
   					<label>Seating Capacity</label>
   					<input type="text"  name="txtSeat"  class="form-control" required />
   				</div>
   				
   				<div class="col-lg-4">
   					<br />
   					<input type="submit"  value="Add Flight"  class="btn btn-success" />
   				</div>   				
   			</div>
   			</form>
   		</div>
   		</div>
   	</div>
   </div>
</div>
</body>
</html>