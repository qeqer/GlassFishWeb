<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>
<div class = "myart">Registration</div>
<div class = "clearer">&nbsp;</div>
${result}

<form method="POST" action="register">
	<div class = "clearer">&nbsp;</div>
	<input name="last_name" type="text" placeholder="Yout Last Name"> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="name" type="text" placeholder="Yout Name"> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="password" type="text" placeholder="Password"> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="Register"/>
</form>


<%@ include file="/WEB-INF/jsp/footer.jsp" %>