<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spring With MongoDB</title>
</head>

<style>

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#container {
	min-height: 100%;
	position: relative;
}

#container #header {
	height: 50px;
	background-color: silver;
}

#container #content {
	padding-top: 20px;
	
}

#container #footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 50px;
	background-color: silver;
}
</style>

<body>
<div id="container">
	<div id="header">
		<h1>CRUD using Spring MVC and MongoDB</h1>
	</div>
	
	<div id="content">
		<form action="/springwithmongodb/save" method="post">
				<input type="hidden" name="_id">
				<label>USERID : </label>
				<input type="text" id="userid" name="userid"/><p>
				<label>NAME : </label>
				<input type="text" id="name" name="name"/><p>
				<label>AGE : </label>
				<select id="age" name="age">
					<option value="30">30</option>
					<option value="31">31</option>
					<option value="32">32</option>
					<option value="33">33</option>
					<option value="34">34</option>
				</select><P>
				<label>CITY : </label>
				<select id="city" name="city">
					<option value="SEOUL">SEOUL</option>
					<option value="ANSAN">ANSAN</option>
					<option value="GANGNEUNG">GANGNEUNG</option>
					<option value="CHEONAN">CHEONAN</option>
					<option value="INCHEON">INCHEON</option>
					<option value="BUSAN">BUSAN</option>
				</select><P>
				<label>TEAM : </label>
				<select id="team" name="team">
					<option value="Personnel Team">Personnel Team</option>
					<option value="Accounting Team">Accounting Team</option>
					<option value="Advertising Team">Advertising Team</option>
					<option value="Management Planning Team">Management Planning Team</option>
				</select><P>
				<label>PHONE : </label>
				<input type="text" id="phone" name="phone"/><p>
				<input type="submit" value="Submit"/>
		</form>
	
		
		
		<table border="1">
			<thead>
				<tr>
					<th>_ID</th>
					<th>USERID</th>
					<th>NAME</th>
					<th>AGE</th>
					<th>CITY</th>
					<th>TEAM</th>
					<th>PHONE</th>
				</tr>
			</thead>
				
					<c:forEach var="employee" items="${employeeList}">
						<tr>
							<td>${employee._id}</td>
							<td>${employee.userid}</td>
							<td>${employee.name}</td>
							<td>${employee.age}</td>
							<td>${employee.city}</td>
							<td>${employee.team}</td>
							<td>${employee.phone}</td>
							<td><input type="button" value="delete" onclick="window.location='/springwithmongodb/delete?userid=${employee.userid}'"/></td>	
						</tr>
					</c:forEach>
				
				
			<tbody>
			</tbody>
		</table>
	</div>
	
	<div id="footer">
		<input type="button" value="WEB QUERY PAGE GO" onclick="window.location='/springwithmongodb/cli'"/>
	</div>
</div>
</body>
</html>
