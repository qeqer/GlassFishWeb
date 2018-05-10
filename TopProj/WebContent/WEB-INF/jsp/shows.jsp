<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>
<div class = "myart">Shows</div>
<br>





<form method="GET" action="shows">
	<input name="sc" type="text" placeholder="Scenario Name"> <br>
	<input name="th" type="text" placeholder="Theater Name"> <br>
	<input class="mybutton2" type="submit" value="Search"/>
</form>


<table>
	<tr>
		<th>Show</th>
		<th>Duration</th>
		<th>Date</th>
		<th>Theater</th>
	</tr>

	<c:forEach items = "${res}" varStatus = "i" var = "rr">
		<tr>
			<td><a href = "show?id=${rr.show_id}">${rr.sc_name}</a></td>
			<td><a>${rr.duration}</a></td>
			<td><a>${rr.dat}</a></td>
			<td><a href = "theater?id=${rr.theater_id}">${rr.theater_name}</a></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>