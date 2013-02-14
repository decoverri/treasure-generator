<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Treasure Generator</title>
</head>

<body>

	<header class="page-header">
		<div class="container">
			<h1>Treasure Generator <small> Pathfinder RPG (<a href="http://www.paizo.com">www.paizo.com</a>)</small></h1>
		</div>
	</header>
	<br/>

	<div class="container">
		<form action="generateTreasure" method="post" class="form-horizontal">

			<button class="btn btn-primary pull-right" type="button">Generate</button>
			<br/>
			<hr>

			<div class="row">
				<c:forEach items="${treasureTypesInfo}" var="info">
					<div class="span1AndABit">
						<h4>Type ${info.name}</h4>
	
						<c:forEach items="${info.values}" var="value">
							<label class="checkbox">
								<input type="checkbox"/>
								<fmt:formatNumber type="number" value="${value}" /> gp
							</label>
						</c:forEach>
					</div>
				
				</c:forEach><br/>
			</div>

			<hr>
			<button class="btn btn-primary pull-right" type="button">Generate</button>

			<br/>
		</form>
	</div>

</body>
</html>
