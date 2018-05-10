<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>

<a href = "stars">
	<div class = "mybutton">
		Stars
	</div>
</a>

<div class = "clearer">&nbsp;</div>

<div class = "myart">Artist Info</div>

<table>
	<tr>
		<th>Artist ID</th>
		<th>Name</th>
		<th>Last Name</th>
		<th>Info</th>
	</tr>
	<tr>
		<td><a>${star.worker_id}</a></td>
		<td><a>${star.name}</a></td>
		<td><a>${star.last_name}</a></td>
		<td><a>${star.bio}</a></td>
	</tr>
</table>

<h3> Roles in shows </h3>
<table>
	<tr>
		<th>Show ID</th>
		<th>Role</th>
	</tr>

	<c:forEach items = "${temp}" varStatus = "i" var = "s">
		<tr>
			<td><a href = "show?id=${s.show_id.getShow_id()}">${s.show_id.getShow_id()}</a></td>
			<td><a>${s.role}</a></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>