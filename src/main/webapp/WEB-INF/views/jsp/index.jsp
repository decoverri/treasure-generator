<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="generator" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width">

		<title>Treasure Generator</title>
	
		<link href='http://fonts.googleapis.com/css?family=MedievalSharp|Alegreya:400,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="resources/css/reset.css" >
		<link rel="stylesheet" href="resources/css/style.css" >
		
		<fmt:setLocale value="en_US" scope="session"/>
	</head>
	<body>
		
		<form action="generate">

			<input type="radio" name="letter" id="showMain" checked />
			<section>
				<header class="container">
					<h1>Treasure Generator</h1>
					<h2>for Pathfinder RPG</h2>
				</header>
				
				<ol class="container types">
					<c:forEach items="${types}" var="type" >
						<li><label for="show${type.letter}">Type ${type.letter}</label></li>
					</c:forEach>
				</ol>
			</section>
	
			<c:forEach items="${types}" var="type" >
				<generator:typepage type="${type}" />
			</c:forEach>

		</form>

		<footer class=container>
			<small>by @decoverri</small>
		</footer>

	</body>
</html>