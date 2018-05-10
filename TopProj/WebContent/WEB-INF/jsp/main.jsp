<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>



<h1>
	Entertainment. For All. Eeeeeeeah.
</h1>
<h2>
	Here u'll find theaters and all about them.
</h2>

<div class = "myart"> 
	${loginf}
</div>

<div class = "clearer">&nbsp;</div>

<a href="theaters"> 
	<div class="mybutton">
	All Theaters
	</div>
</a>

<a href="shows?sc=&th="> 
	<div class="mybutton">
	All Show
	</div>
</a>

<a href="scenarios?sc_name=&sc_author="> 
	<div class="mybutton">
	All Scenarios
	</div>
</a>

<a href="stars"> 
	<div class="mybutton">
	All Stars
	</div>
</a>

<div class = "clearer">&nbsp;</div>

<a href="register"> 
	<div class="mybutton">
		Register
	</div>
</a>

<a href="logout"> 
	<div class="mybutton">
		Log Out
	</div>
</a>

<a href="addpage"> 
	<div class="mybutton">
		Edit Some
	</div>
</a>

<a href="bookings"> 
	<div class="mybutton">
		Bookings
	</div>
</a>

<div class = "clearer">&nbsp;</div>



<form method="POST" action="main">
	<div class = "clearer">&nbsp;</div>
	<input name="client_id" type="text" value = "${logged.getClient_id()}" placeholder="Your ID"> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="password" type="text" value = "${logged.getPassword()}" placeholder="Password"> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="LogIN"/>
</form>







<%@ include file="/WEB-INF/jsp/footer.jsp" %>