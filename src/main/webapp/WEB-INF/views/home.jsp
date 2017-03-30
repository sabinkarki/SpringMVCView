<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head ng-app="store">
<!-- <script type="text/javascript" src="resources/js/app.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
<script type="text/javascript" src="resources/js/angular.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/> -->
<title>Home</title>
</head>
<body>
<h1>Please select the view</h1>
	<h1>Spring MVC - View (JSON, XML, PDF, Excel)</h1>
	<div style="margin: 10px; width: 700px; text-align: center">
		<a href="json.json">JSON</a> <a
			href="get.xml" >XML</a> <a
			href="get.pdf" >PDF</a> <a
			href="get.xlsx">Excel</a>
	</div>
	 <a href="#/angular">AngularPage</a>
	
	<div ng-view></div>
</body>
</html>
