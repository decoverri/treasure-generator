<div class="container">
	<form action="massGenerate" method="post" class="form-horizontal" >
		<button class="btn btn-primary pull-right" type="submit">Generate</button>
		<br/><br/>

		<div class="row">
			<c:forEach items="${treasureTypes}" var="treasureType" varStatus="s1">
				<div class="span1AndABit">
					<h4>Type ${treasureType.letter}</h4>
					<input type="hidden" name="treasureTypes[${s1.index}].letter" value="${treasureType.letter}" />

					<c:forEach items="${treasureType.values}" var="value" varStatus="s2">
						<label class="checkbox">
							<input type="checkbox" name="treasureTypes[${s1.index}].values[${s2.index}].value" value="${value.value}"/>
							<fmt:formatNumber type="number" value="${value.value}" /> gp
						</label>
					</c:forEach>
				</div>
			
			</c:forEach><br/>
		</div>

	</form>
</div>

<c:import url="../import/treasureTable.jsp" />

<br/><br/><br/><br/>
