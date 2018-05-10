<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>

<div class = "myart">Scenarios</div>
<br>





<form method="GET" action="scenarios">
	<input name="sc_name" type="text" placeholder="Scenario Name"> <br>
	<input name="sc_author" type="text" placeholder="Scenario Author"> <br>
	<input class="mybutton2" type="submit" value="Search"/>
</form>


<table>
	<tr>
		<th>Scenario Name</th>
		<th>Scenario Author</th>
	</tr>

	<c:forEach items = "${sc_list}" varStatus = "i" var = "sc">
		<tr>
			<td><a href = "scenario?id=${sc.getScenario_id()}">${sc.getSource_name()}</a></td>
			<td><a>${sc.getAuthor()}</a></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>