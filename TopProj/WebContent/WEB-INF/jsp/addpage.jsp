<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<a href = "main">
	<div class = "mybutton">
		Main Page
	</div>
</a>
<div class = "clearer">&nbsp;</div>
<div class = "myart">Add New One</div>
<div class = "clearer">&nbsp;</div>
<div class = "myart">${status}</div>
<div class = "clearer">&nbsp;</div>

<form method="POST" action="addsc">
	<div class = "clearer">&nbsp;</div>
	<input name="source_name" type="text" placeholder="Scenario Name"> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="author" type="text" placeholder="Scenario Author"> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="Add Scenario"/>
</form>

<form method="POST" action="addth">
	<div class = "clearer">&nbsp;</div>
	<input name="address" type="text" placeholder="Address"> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="bio" type="text" placeholder="Info"> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="name" type="text" placeholder="Name"> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="Add Theater"/>
</form>

<form method="POST" action="addwo">
	<div class = "clearer">&nbsp;</div>
	<input name="name" type="text" placeholder="Name"> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="last_name" type="text" placeholder="Last Name"> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="bio" type="text" placeholder="Bio"> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="Add Worker"/>
</form>

<form method="POST" action="addws">
	<div class = "clearer">&nbsp;</div>
	<input name="show_id" type="text" placeholder="Show ID" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="worker_id" type="text" placeholder="Worker ID" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="role" type="text" placeholder="Role"> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="Add Worker Show"/>
</form>

<form method="POST" action="addwt">
	<div class = "clearer">&nbsp;</div>
	<input name="theater_id" type="text" placeholder="Theater ID"  required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="worker_id" type="text" placeholder="Worker ID"  required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="role" type="text" placeholder="Role"> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="Add Worker Theater"/>
</form>

<form method="POST" action="addsh">
	<div class = "clearer">&nbsp;</div>
	<input name="hall" type="text" placeholder="Hall ID" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="scenario" type="text" placeholder="Scenario ID" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="dat" type="date" placeholder="Date" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="duration" type="text" placeholder="Duration" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="Add Show"/>
</form>

<form method="POST" action="addpl">
	<div class = "clearer">&nbsp;</div>
	<input name="hall_id" type="text" placeholder="Hall ID" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="row_num" type="text" placeholder="Row Num" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="num" type="text" placeholder="Num" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="type" type="text" placeholder="Place Type" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="Add Place"/>
</form>

<form method="POST" action="addps">
	<div class = "clearer">&nbsp;</div>
	<input name="place" type="text" placeholder="Place ID" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="show" type="text" placeholder="Show ID" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="price" type="text" placeholder="Price" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="free" type="text" placeholder="Free?" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="Add Place for Sell"/>
</form>

<form method="POST" action="addha">
	<div class = "clearer">&nbsp;</div>
	<input name="theater" type="text" placeholder="Theater ID" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input name="num" type="text" placeholder="Hall Num" required> <br>
	<div class = "clearer">&nbsp;</div>
	<input class="mybutton2" type="submit" value="Add Hall"/>
</form>


<div class = "clearer">&nbsp;</div>
<div class = "myart">Delete Some</div>
<div class = "clearer">&nbsp;</div>
<form action = "del" method = "POST">
	<select name = "type" required>
		<option>Place</option>
		<option>Booking</option>
		<option>Hall</option>
		<option>Theater</option>
		<option>Show</option>
		<option>Place for Sell</option>
		<option>Worker</option>
		<option>Worker in Theater</option>
		<option>Worker in Show</option>
		<option>Scenario</option>
	</select>
	<div class = "clearer">&nbsp;</div>
	<input type = "text" name = "id" placeholder = "ID">
	<div class = "clearer">&nbsp;</div>
	<input type = "submit" value = "Delete!11!11!">
</form>



<%@ include file="/WEB-INF/jsp/footer.jsp" %>