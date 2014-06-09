<form action="massGenerate#result" method="post">

	<header>
		<span>Total selected: <output id="selectedTotal">${empty massSelectedTotal ? 0 : massSelectedTotal}</output> gp</span>
		<button type="button" onclick="clearSelection()" >clear selection</button>
		<button type="submit">Generate</button>
	</header>

	<c:forEach items="${treasureTypes}" var="treasureType" varStatus="s1">
		<h3>Type ${treasureType.letter}</h3>
		<input type="hidden" name="treasureTypes[${s1.index}].letter" value="${treasureType.letter}" />

		<c:forEach items="${treasureType.values}" var="value" varStatus="s2">
			<label>
				<input type="checkbox" name="treasureTypes[${s1.index}].values[${s2.index}].value"
						value="${value.value}" onchange="calculateSum()"
						${treasureTypes[s1.index].letter == massSelectedTypes[s1.index].letter and
						treasureTypes[s1.index].values[s2.index].value == massSelectedTypes[s1.index].values[s2.index].value ? "checked" : "" } />
				<fmt:formatNumber type="number" value="${value.value}" /> gp
			</label>
		</c:forEach>
	
	</c:forEach><br/>

</form>

<c:import url="/WEB-INF/views/import/treasureTable.jsp" />
