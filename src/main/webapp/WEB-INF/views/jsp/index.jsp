<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	</head>
	<body>
			
		<input type="radio" name="type" id="showMain" checked />
		<section id="main">
			<header class="container">
				<h1>Treasure Generator</h1>
				<h2>for Pathfinder RPG</h2>
			</header>
			
			<ol class="container types">
				<li id="coins"><label for="showA">Type A</label></li>
				<li id="gems"><label for="showB">Type B</label></li>
				<li id="art"><label for="showC">Type C</label></li>
				<li id="objects"><label for="showD">Type D</label></li>
				<li id="weapon"><label for="showE">Type E</label></li>
				<li id="combatant"><label for="showF">Type F</label></li>
				<li id="spellcaster"><label for="showG">Type G</label></li>
				<li id="lair"><label for="showH">Type H</label></li>
				<li id="hoard"><label for="showI">Type I</label></li>
			</ol>
		</section>

		<c:forEach items="${types}" var="type" >
			<generator:typepage type="${type}" />
		</c:forEach>

		<footer class=container>
			<small>by @decoverri</small>
		</footer>

	</body>
</html>