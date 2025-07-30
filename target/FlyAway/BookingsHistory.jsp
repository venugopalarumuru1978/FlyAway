<%@page import="java.util.List"%>
<%@page import="com.models.BookingHistory"%>
<%@page import="com.DAO.BookingsDAO"%>
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
	int cid = (int)session.getAttribute("cid");
	BookingsDAO  bDAO = new BookingsDAO();
	List<BookingHistory>  bhList = bDAO.HistoryBasedOnMemberID(cid); 
%>
<div class="container-fluid">
   <img src="pics/Flyaway.png"  width="100%" height="200" />
   <jsp:include page="MemberLinks.jsp"/>
   <br />
   	<div class="row">
		<div class="col-lg-12">
			<div class="card">
				<div class="card-header">
					<b>Booking History</b>		
				</div>
				<div class="card-body">
					<table class="table table-warning">
						<thead>
						<tr>
							<th>Travel Date</th>
							<th>Customer Name</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Source</th>
							<th>Destination</th>
							<th>Airlines</th>							
							<th>Amount</th>
						</tr>
						</thead>
						<tbody>
							<%
								for(BookingHistory  bh : bhList)
								{
							%>
								<tr>
									<td><%=bh.getBdate() %> </td>
									<td><%=bh.getCname() %> </td>
									<td><%=bh.getPhone() %> </td>
									<td><%=bh.getEmail() %> </td>
									<td><%=bh.getSource() %> </td>
									<td><%=bh.getDest() %> </td>
									<td><%=bh.getAirname() %> </td>
									<td><%=bh.getAmt() %> </td>
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