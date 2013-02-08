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
				<a href="http://www.paizo.com" >www.paizo.com</a>
			</div>
		</div>
		
		<div class="container">

			<h3>By Treasure Type</h3>
			<form action="generateTreasure" method="post">
				<select name="treasureName">
					<option value="A" >Type A - Coins</option>
					<option value="B" >Type B - Coins and Gems</option>
					<option value="C" >Type C - Art Objects</option>
					<option value="D" >Type D - Potions, Scrolls and Wands</option>
					<option value="E" >Type E - Armors and Weapons</option>
					<option value="F" >Type F - Combatant Gear</option>
					<option value="G" >Type G - Spellcaster Gear</option>
					<option value="H" >Type H - Lair</option>
					<option value="I" >Type I - Hoard</option>
				</select>
			</form>

		</div>
		
	</body>
</html>
