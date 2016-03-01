<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<c:import url="main-config.jsp" />		
		<link rel="stylesheet" href="<c:url value="/resources/css/about.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/header.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/footer.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/typeColors.css" />" >
		
		<title>Treasure Generator</title>
	</head>
	<body>
		
		<c:import url="header.jsp" />
			<section class="container about">
				<h3 class="about-title" >About the site:</h3>
				<p class="about-content">
					This is a tool build for the <a class="link" href="http://paizo.com/pathfinderRPG" >Pathfinder RPG</a> system player. 
					It emulates the same algorithm for treasure generation presented in the appendix of the book 
					<a class="link" href="http://paizo.com/products/btpy8tmc?Pathfinder-Roleplaying-Game-Ultimate-Equipment">Ultimate Equipment</a>
				</p>
				<p class="about-content">
					This project was created both for me as a player and as a software developer, to study technologies. It is an open 
					source project and it's code can be found on the 
					<a class="link" href="https://github.com/decoverri/treasure-generator" >github repository</a>
				</p>
				<p class="about-content">
					There's also a list of features that I would like to add in the future. If you have ideas too, or something you want to say 
					just get in contact with me.
				</p>
			</section>

			<section class="container about">
				<h3 class="about-title" >About the generator:</h3>
				<p class="about-content">
					Since this is a random generator, often the result total will differ from the value chosen.
				<p>
				<p class="about-content">
					The results are not set in stone, though. There are actually several results that imply some decision on the DM's part.
					For example: Dragonplate armor doesn't specify the type of the dragon; Composite bows always have a 
					strength bonus of +0; Masterwork weapon costs does not consider masterwork double-weapons costs.
				<p>
			</section>
		<c:import url="footer.jsp" />

	</body>
</html>