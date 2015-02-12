<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="type" type="com.decoverri.treasureGenerator.model.TreasureType" %>

<input type="radio" name="letter" id="show${type.letter}" value="${type.letter}" class="radio-hack" />
<section class="view type">
	<header class="container header type-header header-type${type.letter}">
		<label for="showMain" class="header-back">Back</label>
		<h2 class="type-header-title">${type.name}</h2>
		<h3 class="type-header-subtitle">Type ${type.letter}</h3>
	</header>
	
	<ol class="container valueList">
		<c:forEach items="${type.values}" var="value" >
			<li class="wrap-valueList-item" ><button type="submit" name="value" value="${value.value}" class="valueList-item" ><fmt:formatNumber value="${value.value}" /> gp</button></li>
		</c:forEach>
	</ol>
</section>
