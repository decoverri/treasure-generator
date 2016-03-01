<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="generator" %>

<!DOCTYPE html>
<html>
	<head>
		<c:import url="main-config.jsp" />
		<link rel="stylesheet" href="<c:url value="/resources/css/index.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/header.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/footer.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/typeColors.css" />" >
		
		<fmt:setLocale value="en_US" scope="session"/>

		<title>Treasure Generator</title>
	</head>
	<body>
		
		<form action="generate">

			<input type="radio" name="letter" id="showMain" class="radio-hack" checked />
			<section class="view" >
				<c:import url="header.jsp" />
				
				<ol class="container typeList">
					<c:forEach items="${types}" var="type" >
						<li class="wrap-typeList-item" ><label title="${type.name}" class="typeList-item type${type.letter}" for="show${type.letter}">Type ${type.letter}</label></li>
					</c:forEach>
				</ol>
			</section>
	
			<c:forEach items="${types}" var="type" >
				<generator:typepage type="${type}" />
			</c:forEach>

		</form>

		<c:import url="footer.jsp" />

	</body>
</html>