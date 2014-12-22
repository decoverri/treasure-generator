<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="type" type="com.decoverri.treasureGenerator.model.TreasureType" %>

<input type="radio" name="type" id="show${type.letter}" value="${type.letter}" />
<section class="type">
	<header class="container">
		<label for="showMain" class="voltar">Back</label>
		<h1>Type ${type.letter}</h1>
		<h2>${type.name}</h2>
	</header>
	
	<ol class="container values">
		<c:forEach items="${type.values}" var="value" >
			<li><a>${value.value} gp</a></li>
		</c:forEach>
	</ol>
</section>
