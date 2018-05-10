<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>

<div class = "myart">Stars</div>

<br>




<form method="POST" action="stars">
	<input name="name" type="text" placeholder="Name"> <br>
	<input name="last_name" type="text" placeholder="Last Name"> <br>
	<input class="button" type="submit" value="Search"/>
</form>


<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Last Name</th>
		<th>Bio</th>
	</tr>

	<c:forEach items = "${workers}" varStatus = "i" var = "temp">
		<tr>
			<td><a href = "star?id=${temp.worker_id}">${temp.worker_id}</a></td>
			<td><a>${temp.last_name}</a></td>
			<td><a>${temp.name}</a></td>
			<td><a>${temp.bio}</a></td>
	</c:forEach>
</table>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>