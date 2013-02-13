<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-responsive.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Treasure Generator</title>
</head>

<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Treasure Generator</h1>
			<p>Pathfinder RPG treasure generator</p>
			<a href="http://www.paizo.com">www.paizo.com</a>
		</div>
	</div>

	<div class="container">
		<div class="hero-unit">
			<form action="generateTreasure" method="post" class="form-horizontal">

				<c:forEach items="${treasureTypesInfo}" var="info">
					<p>Type ${info.name} <small>- ainda não tem descrição</small></p>

						<c:forEach items="${info.values}" var="value">
							<label class="checkbox inline"> <input type="checkbox"/>${value}</label>
					</c:forEach>
				
				<hr>
				</c:forEach><br/>

				<button class="btn btn-primary" type="button">Generate</button>
			</form>
		</div>
	</div>

</body>
</html>
