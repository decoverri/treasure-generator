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

<c:if test="${not empty treasures}">
<hr>
<div class="container">
	<h3>Result</h3>
	<table class="table table-striped table-bordered" >
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${treasures}" var="treasure" >
				<tr>
					<td>${treasure.name}</td>
					<td><fmt:formatNumber type="number" value="${treasure.treasureValue}" /> gp</td>
				</tr>
			</c:forEach>
				<tr>
					<td><strong>Total price generated</strong></td>
					<td><strong><fmt:formatNumber type="number" value="${totalPrice}" /> gp</strong></td>
				</tr>
		</tbody>
	</table>
</div>
</c:if>
<br/><br/><br/><br/>
