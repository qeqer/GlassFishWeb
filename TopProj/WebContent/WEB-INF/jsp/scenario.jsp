<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>

<a href = "scenarios?sc_name=${s.source_name}&sc_author=${s.author}">
	<div class = "mybutton">
		Back to Scenarios
	</div>
</a>

<br>

<div class = "myart">Show Info</div>


<table>
	<tr>
		<th>Scenario ID</th>
		<th>Scenario Name</th>
		<th>Scenario Author</th>
	</tr>
	<tr>
		<td><a>${s.scenario_id}</a></td>
		<td><a>${s.source_name}</a></td>
		<td><a>${s.author}</a></td>
	</tr>
</table>

<div class = "myart">Shows with this Scenario</div>

<table>
	<tr>
		<th>Show ID</th>
	</tr>

	<c:forEach items = "${ss}" varStatus = "i" var = "sh1">
		<tr>
			<td><a href = "show?id=${sh1.show_id}">${sh1.show_id}</a></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>