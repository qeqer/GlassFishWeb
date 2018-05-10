<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>
<div class = "myart">Theaters</div>
<br>




<form method="POST" action="theaters">
	<input name="name" type="text" placeholder="Theater Name"> <br>
	<input class="mybutton2" type="submit" value="Search"/>
</form>


<table>
	<tr>
		<th>Name</th>
		<th>Address</th>
	</tr>

	<c:forEach items = "${theaters}" varStatus = "i" var = "theat">
		<tr>
			<td><a href = "theater?id=${theat.theater_id}">${theat.name}</a></td>
			<td><a>${theat.address}</a></td>
		</tr>
	</c:forEach>
</table>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>