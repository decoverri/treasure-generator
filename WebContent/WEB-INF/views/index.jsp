<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
		<form action="generate" method="post" class="form-horizontal" >

			<button class="btn btn-primary pull-right" type="submit">Generate</button>
			<br/>
			<hr>

			<div class="row">
				<c:forEach items="${treasureTypesInfo}" var="generatorInfo" varStatus="s1">
					<div class="span1AndABit">
						<h4>Type ${generatorInfo.name}</h4>
						<input type="hidden" name="information.infos[${s1.index}].name" value="${generatorInfo.name}" />
	
						<c:forEach items="${generatorInfo.values}" var="value" varStatus="s2">
							<label class="checkbox">
								<input type="checkbox" name="information.infos[${s1.index}].values[${s2.index}]" value="${value}"/>
								<fmt:formatNumber type="number" value="${value}" /> gp
							</label>
						</c:forEach>
					</div>
				
				</c:forEach><br/>
			</div>

			<hr>
			<button class="btn btn-primary pull-right" type="submit">Generate</button>

			<br/>
		</form>
	</div>

</body>
</html>
