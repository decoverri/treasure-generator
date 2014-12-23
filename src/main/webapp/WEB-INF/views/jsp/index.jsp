<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="generator" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width">
	
		<link href='http://fonts.googleapis.com/css?family=MedievalSharp|Alegreya:400,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="resources/css/reset.css" >
		<link rel="stylesheet" href="resources/css/base.css" >
		<link rel="stylesheet" href="resources/css/index.css" >
		<link rel="stylesheet" href="resources/css/footer.css" >
		
		<fmt:setLocale value="en_US" scope="session"/>

		<title>Treasure Generator</title>
	</head>
	<body>
		
		<form action="generate">

			<input type="radio" name="letter" id="showMain" class="radio-hack" checked />
			<section class="view" >
				<header class="container header">
					<h1 class="header-title">Treasure Generator</h1>
					<h3 class="header-subtitle">for Pathfinder RPG</h3>
				</header>
				
				<ol class="container typeList">
					<c:forEach items="${types}" var="type" >
						<li class="wrap-typeList-item"><label class="typeList-item" for="show${type.letter}">Type ${type.letter}</label></li>
					</c:forEach>
				</ol>
			</section>
	
			<c:forEach items="${types}" var="type" >
				<generator:typepage type="${type}" />
			</c:forEach>

		</form>

		<footer class="container footer">
			<small>by @decoverri</small>
		</footer>

	</body>
</html>