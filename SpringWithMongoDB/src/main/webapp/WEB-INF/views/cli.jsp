<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	background-color: #CCEEFF;
}

#container #content {
	padding-top: 20px;
}

#container #footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 50px;
	background-color: #CCEEFF;
}
</style>

<body>
	<div id="container">
		<div id="header">
			<h1>WEB CLI(Query) using Spring MVC and MongoDB</h1>
		</div>

		<div id="content">
			<form action="/springwithmongodb/save" method="post">
				
				<p>
					<input type="submit" value="Submit" />
			</form>

		</div>

		<div id="footer">
			<input type="button" value="CRUD PAGE GO"
				onclick="window.location='/springwithmongodb'" />
		</div>
	</div>

</body>
</html>
