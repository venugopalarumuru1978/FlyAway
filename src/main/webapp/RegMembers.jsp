<%@page import="com.models.Members"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flyaway - Registered Members</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: #008080">
<%
MemberDAO mDao = new MemberDAO();
List<Members> mList = mDao.ShowAll();
%>
<div class="container-fluid">
   <img src="pics/Flyaway.png"  width="100%" height="200" />
   <jsp:include page="AdminLinks.html"/>
   <br />
   	<div class="card">
   	<div class="card-header"><b>Registered Members</b></div>
   	<div class="card-body">
   		<table class="table table-warning">
   			<thead>
   			<tr>
				<th>Member Name</th>
				<th>Member Phone</th>
				<th>Member Email</th>
				<th>Member Location</th>   			
   			</tr>
   			</thead>
   			<tbody>
   				<%
   					for(Members m : mList)
   					{

   				%>
   				<tr>
   				<td><%=m.getCusname() %> </td>
   				<td><%=m.getPhone() %> </td>
   				<td><%=m.getEmail() %> </td>
   				<td><%=m.getLocation() %> </td>
   				</tr>
   				<%
   					}
   				%>
   			</tbody>
   </table>
   </div>
   </div>
   
</div>
</body>
</html>