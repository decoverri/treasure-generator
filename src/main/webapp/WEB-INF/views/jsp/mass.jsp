<div class="container"><br/>
	<form action="massGenerate" method="post" class="form-horizontal" >
		
		<div class="well">
			<strong>Total selected: <span id="selectedTotal">0</span> gp</strong>
			<button class="btn btn-primary pull-right well-btn" type="submit">Generate</button>
		</div>

		<div class="row">
			<c:forEach items="${treasureTypes}" var="treasureType" varStatus="s1">
				<div class="col-md-1-to-2">
					<h3>Type ${treasureType.letter}</h3>
					<input type="hidden" name="treasureTypes[${s1.index}].letter" value="${treasureType.letter}" />

					<c:forEach items="${treasureType.values}" var="value" varStatus="s2">
						<label class="checkbox">
							<input type="checkbox" name="treasureTypes[${s1.index}].values[${s2.index}].value"
									value="${value.value}" onchange="calculateSum()"/>
							<fmt:formatNumber type="number" value="${value.value}" /> gp
						</label>
					</c:forEach>
				</div>
			
			</c:forEach><br/>
		</div>

	</form>

	<c:import url="/WEB-INF/views/import/treasureTable.jsp" />
</div>

<br/><br/><br/><br/>
