<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width">

		<link href='http://fonts.googleapis.com/css?family=MedievalSharp|Alegreya:400,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="resources/css/reset.css" >
		<link rel="stylesheet" href="resources/css/base.css" >
		<link rel="stylesheet" href="resources/css/header.css" >
		<link rel="stylesheet" href="resources/css/footer.css" >
		<link rel="stylesheet" href="resources/css/error.css" >

		<title>Treasure Generator - Page not Found</title>
	</head>
	<body>

		<c:import url="header.jsp" />

		<section>
			<p class="container error" >Sorry, but it appears that there are no treasures here.</p>
		</section>
		
		<c:import url="footer.jsp" />
	
	</body>
</html>
