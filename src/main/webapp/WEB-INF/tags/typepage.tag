<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="type" type="com.decoverri.treasureGenerator.model.TreasureType" %>

<input type="radio" name="letter" id="show${type.letter}" value="${type.letter}" class="radio-hack" />
<section class="view type">
	<header class="container header">
		<label for="showMain" class="header-back">Back</label>
		<h1 class="header-title">Type ${type.letter}</h1>
		<h2 class="header-subtitle">${type.name}</h2>
	</header>
	
	<ol class="container valueList">
		<c:forEach items="${type.values}" var="value" >
			<li class="wrap-valueList-item" ><button type="submit" name="value" value="${value.value}" class="valueList-item" ><fmt:formatNumber value="${value.value}" /> gp</button></li>
		</c:forEach>
	</ol>
</section>
