<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="type" type="com.decoverri.treasureGenerator.model.TreasureType" %>

<input type="radio" name="letter" id="show${type.letter}" value="${type.letter}" />
<section class="type">
	<header class="container">
		<label for="showMain" class="voltar">Back</label>
		<h1>Type ${type.letter}</h1>
		<h2>${type.name}</h2>
	</header>
	
	<ol class="container values">
		<c:forEach items="${type.values}" var="value" >
			<li><button type="submit" name="value" value="${value.value}" ><fmt:formatNumber value="${value.value}" /> gp</button></li>
		</c:forEach>
	</ol>
</section>
