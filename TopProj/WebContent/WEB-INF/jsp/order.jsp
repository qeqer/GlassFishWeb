<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>

<a href = "show?id=${cur_place.getShow().getShow_id()}">
	<div class = "mybutton">
		Back to Show
	</div>
</a>

<div class = "clearer">&nbsp;</div>

<div class = "myart">Place Booking</div>
<div class = "clearer">&nbsp;</div>

<table>
	<tr>
		<th>Show ID</th>
		<th>Row</th>
		<th>Num</th>
		<th>Theater</th>
		<th>Hall</th>
	</tr>
	<tr>
		<td><a>${cur_place.getShow().getShow_id()}</a></td>
		<td><a>${cur_place.getPlace().getRow_num()}</a></td>
		<td><a>${cur_place.getPlace().getNum()}</a></td>
		<td><a href = "theater?id=${cur_place.getPlace().getHall().getTheater().getTheater_id()}">
		${cur_place.getPlace().getHall().getTheater().getName()}</a></td>
		<td><a>${cur_place.getPlace().getHall().getNum()}</a></td>
	</tr>
</table>

<div class = "clearer"></div>

<form method="GET" action="book">
	<input name="place_id" type="hidden" value="${cur_place.getPlace().getPlace_id()}"> <br>
	<input class="mybutton2" type="submit" value="Book"/>
</form>


<%@ include file="/WEB-INF/jsp/footer.jsp" %>