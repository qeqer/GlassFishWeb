<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>

<a href = "shows?id=${cur_place.getShow().getShow_id()}">
	<div class = "mybutton">
		Back to Show
	</div>
</a>

<br>

<div class = "myart">${bookres}</div>


<%@ include file="/WEB-INF/jsp/footer.jsp" %>