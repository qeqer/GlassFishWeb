<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>

<a href = "theaters">
	<div class = "mybutton">
		Theaters
	</div>
</a>

<div class = "clearer">&nbsp;</div>

<div class = "myart">Theater Info</div>

<br><br>

<table>
	<tr>
		<th>Theater ID</th>
		<th>Name</th>
		<th>Address</th>
		<th>Info</th>
	</tr>
	<tr>
		<td><a>${theat.theater_id}</a></td>
		<td><a>${theat.name}</a></td>
		<td><a>${theat.address}</a></td>
		<td><a>${theat.bio}</a></td>
	</tr>
</table>

<table>
	<tr>
		<th>Show</th>
		<th>Duration</th>
		<th>Date</th>
	</tr>

	<c:forEach items = "${lst}" varStatus = "i" var = "s">
		<tr>
			<td><a href = "show?id=${s.show_id}">${s.sc_name}</a></td>
			<td><a>${s.duration}</a></td>
			<td><a>${s.dat}</a></td>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>