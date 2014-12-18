<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<fmt:setLocale value="en_US" scope="session"/>

	<link href='http://fonts.googleapis.com/css?family=MedievalSharp|Alegreya:400,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="resources/css/reset.css" >
	<link rel="stylesheet" href="resources/css/style.css" >
	<title>Treasure Generator</title>
</head>

<body>

<header>
	<h1>Treasure Generator <small> Pathfinder RPG</small></h1>
	<p>by Deco Verri</p>
	<nav>
		<ul data-id="tabs">
			<li><a href="#main-generator">Generator</a></li>
			<li><a href="#descriptions">Descriptions</a></li>
		</ul>
	</nav>
</header>

<section id="main-generator" class="tab-content show">
	<form action="generate" method="post">
		<label for="type">Choose the treasure type:</label>
		<select id="type" name="letter" onchange="getTypeValues()">
			<c:forEach items="${types}" var="type">
				<option value="${type.letter}" ${type.letter == selectedLetter ? "selected" : "" } >Type ${type.letter} - ${type.name}</option>
			</c:forEach>
		</select>
		
		<label for="value">Choose the treasure value:</label>
		<select id="value" name="value">
			<c:forEach items="${empty selectedValues ? types[0].values : selectedValues}" var="typeValue">
				<option value="${typeValue.value}" ${typeValue.value == selectedValue ? "selected" : "" }><fmt:formatNumber value="${typeValue.value}" /> gp</option>
			</c:forEach>
		</select><img id="loader" src="resources/img/loading-icon.gif" />
		
		<button id="generateBtn" type="submit">Generate</button>
	</form>

	<c:import url="/WEB-INF/views/import/treasureTable.jsp" />
</section>

<section id="descriptions" class="tab-content">
	<h1>Description of the treasure types:</h1>
	<ol>
		<li><b>Type A - Coins :</b> Treasure of this type consists entirely of coins. Coins can be found in nearly any encounter</li>
		<li><b>Type B - Coins and Gems :</b> This type consists of coins but also includes gemstones, some of which can be quite valuable. It is typically found in a small cache or as part of a larger treasure roll.</li>
		<li><b>Type C - Art Objects :</b> Often overlooked, these items are valuable for their beauty and craftsmanship and are made with precious metals, gems, and other fine materials. Art objects are typically displayed in residences or placed in small vaults for safekeeping.</li>
		<li><b>Type D - Coins and Small Objects :</b> This category consists of coins and small magic items, such as potions, rings, scrolls, and wands. Such treasure is typically found in the lairs of beasts or as a small hoard in a monster den.</li>
		<li><b>Type E - Armor and Weapons :</b> Consisting solely of weapons and armor, treasure of this type can be found in armories, stored in a den, or even in use by a monster.</li>
		<li><b>Type F - Combatant Gear :</b> This treasure type is made up of items that would typically be carried by a monster that relies on melee or ranged combat. It includes armor, coins, potions, weapons, and wondrous items.</li>
		<li><b>Type G - Spellcaster Gear :</b> This treasure type is carried by creatures with spellcasting abilities, and includes coins, potions, scrolls, staves, wands, and wondrous items.</li>
		<li><b>Type H - Lair Treasure :</b> This treasure type can contain items of nearly any variety, but it focuses primarily on treasure of lesser individual value. It frequently includes a large number of magic items, coins, and other valuables.</li>
		<li><b>Type I - Treasure Hoard :</b> Truly the greatest of the treasure types, this can contain virtually any type of item. It usually serves as the reward for many challenging encounters, saved up and placed in one location.</li>
	</ol>
</section>


<script src="resources/js/index.js"></script>

</body>
</html>