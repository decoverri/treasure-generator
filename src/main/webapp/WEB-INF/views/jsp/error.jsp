<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<c:import url="main-config.jsp" />
		<link rel="stylesheet" href="<c:url value="/resources/css/error.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/header.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/footer.css" />" >

		<title>Treasure Generator - Error</title>
	</head>
	<body>

		<c:import url="header.jsp" />

		<section>
			<p class="container error" >Sorry, but something just went terribly wrong.</p>
		</section>
		
		<c:import url="footer.jsp" />
	
	</body>
</html>
