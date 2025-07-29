<%@page import="com.models.Members"%>
<%@page import="com.DAO.MemberDAO"%>
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
	int cid = (Integer)session.getAttribute("cid");
	MemberDAO mDao = new MemberDAO();
	Members  memObj = mDao.SearchMember(cid);
%>
<div class="container-fluid">
   <img src="pics/Flyaway.png"  width="100%" height="200" />
   <jsp:include page="MemberLinks.jsp"/>
   <br />
   <div class="card">
   	<div class="card-body">
   		<table class="table table-warning">
   			<thead>
   			<tr>
				<th>Member Name</th>
				<th>Member Phone</th>
				<th>Member Email</th>
				<th>Account Password</th>
				<th>Member Location</th>   			
   			</tr>
   			</thead>
   			<tbody>
   			<tr>
   			<td><%=memObj.getCusname() %></td>
   			<td><%=memObj.getPhone() %></td>
   			<td><%=memObj.getEmail() %></td>
   			<td><%=memObj.getPswd() %></td>
   			<td><%=memObj.getLocation() %></td>
   			</tr>
   			</tbody>
   		</table>
   	</div>
   </div>
</div>
</body>
</html>