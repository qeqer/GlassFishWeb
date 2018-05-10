<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>

<div class = "myart"> 
	Your Bookings
</div>

<div class = "clearer">&nbsp;</div>


<table>
	<tr>
		<th>ID</th>
		<th>Show ID</th>
		<th>Date</th>
		<th>Theater</th>
		<th>Hall Num</th>
		<th>Row</th>
		<th>Num</th>
	</tr>

	<c:forEach items = "${bookingsList}" varStatus = "i" var = "test">
		<tr>
			<td><a>${test.getId()}</a></td>
			<td><a>${test.getPlace().getShow().getShow_id()}</a></td>
			<td><a>${test.getPlace().getShow().getDat()}</a></td>
			<td><a>${test.getPlace().getShow().getHall().getTheater().getName()}</a></td>
			<td><a>${test.getPlace().getShow().getHall().getNum()}</a></td>
			<td><a>${test.getPlace().getPlace().getRow_num()}</a></td>
			<td><a>${test.getPlace().getPlace().getNum()}</a></td>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>