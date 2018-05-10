<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>

<a href = "shows?sc=&th=">
	<div class = "mybutton">
		Shows
	</div>
</a>
<div class = "clearer">&nbsp;</div>
<div class = "myart">Show Info</div>
<div class = "clearer">&nbsp;</div>


<table>
	<tr>
		<th>Show ID</th>
		<th>Scenario Name</th>
		<th>Duration</th>
		<th>Date</th>
		<th>Theater</th>
	</tr>
	<tr>
		<td><a>${s.show_id}</a></td>
		<td><a href = "scenario?id=${s.scenario_id}">${s.sc_name}</a></td>
		<td><a>${s.duration}</a></td>
		<td><a>${s.dat}</a></td>
		<td><a href = "theater?id=${s.theater_id}">${s.theater_name}</a></td>
	</tr>
</table>

<div class = "myart"> Roles in shows
</div>
<table>
	<tr>
		<th>Artist Last Name</th>
		<th>Artist Name</th>
		<th>Role</th>
	</tr>

	<c:forEach items = "${wis}" varStatus = "i" var = "w">
		<tr>
			<td><a href = "star?id=${w.worker_id.getWorker_id()}">${w.worker_id.getLast_name()}</a></td>
			<td><a>${w.worker_id.getName()}</a></td>
			<td><a>${w.role}</a></td>
		</tr>
	</c:forEach>
</table>

<div class = "myart"> Places on show
</div>

<table>
	<tr>
		<th>Row</th>
		<th>Num</th>
		<th>Type</th>
		<th>Price</th>
	</tr>
	
	<c:forEach items = "${pfsList}" varStatus = "i" var = "pfs">
		<tr onclick="window.location.href='order?id='+${pfs.id}">
			<td>${pfs.place.row_num}</td>
			<td>${pfs.place.num}</td>
			<td>${pfs.place.type}</td>
			<td>${pfs.price}</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>







