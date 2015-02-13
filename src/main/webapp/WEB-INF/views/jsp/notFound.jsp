<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<c:import url="main-config.jsp" />
		<link rel="stylesheet" href="resources/css/error.css" >
		<link rel="stylesheet" href="resources/css/header.css" >
		<link rel="stylesheet" href="resources/css/footer.css" >

		<title>Treasure Generator - Page not Found</title>
	</head>
	<body>

		<c:import url="header.jsp" />

		<section>
			<p class="container error" >Sorry, but it seems that there are no treasures here.</p>
		</section>
		
		<c:import url="footer.jsp" />
	
	</body>
</html>
