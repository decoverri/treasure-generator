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
	
		<input type="radio" name="type" id="showB" value="B" />
		<input type="radio" name="type" id="showC" value="C" />
		<input type="radio" name="type" id="showD" value="D" />
		<input type="radio" name="type" id="showE" value="E" />
		<input type="radio" name="type" id="showF" value="F" />
		<input type="radio" name="type" id="showG" value="G" />
		<input type="radio" name="type" id="showH" value="H" />
		<input type="radio" name="type" id="showI" value="I" />
		
		<input type="radio" name="type" id="showMain" value="main" checked />
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

		<input type="radio" name="type" id="showA" value="A" />
		<section id="type-a" class="type">
			<header class="container">
				<label for="showMain" class="voltar">Back</label>
				<h1>Type A</h1>
				<h2>coins</h2>
			</header>
			
			<ol class="container values">
				<li><a>1 gp</a></li>
				<li><a>5 gp</a></li>
				<li><a>10 gp</a></li>
				<li><a>25 gp</a></li>
				<li><a>50 gp</a></li>
				<li><a>100 gp</a></li>
				<li><a>200 gp</a></li>
				<li><a>500 gp</a></li>
				<li><a>1,000 gp</a></li>
				<li><a>5,000 gp</a></li>
				<li><a>10,000 gp</a></li>
				<li><a>50,000 gp</a></li>
			</ol>
		</section>
		
		<footer class=container>
			<small>@Copyright 2014</small>
		</footer>

	</body>
</html>