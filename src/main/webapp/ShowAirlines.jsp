<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.models.Airlines"%>
<%@page import="com.DAO.AirLinesDAO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%
AirLinesDAO aDao = new AirLinesDAO();
List<Airlines> airList =  aDao.ShowAll();

%>

<table  class="table table-dark">
<thead>
<tr>
<th>AirLine Code</th>
<th>AirLine Name</th>
</tr>
</thead>
<tbody>
<%
for(Airlines aObj : airList)
{
%>
<tr>
<td>
<%=aObj.getAidId() %></td>
<td>
<%=aObj.getAirName() %>
</td>
</tr>
<%
}
%>
</tbody>
</table>
</body>
</html>