<div class="container">
	<br/><br/>

		<div class="col-lg-4">
			<form action="generate" method="post">
			<div class="form-group">
					<label for="type">Choose the treasure type:</label>
					<select id="type" class="form-control" name="letter" onchange="getTypeValues()">
						<c:forEach items="${types}" var="type">
							<option value="${type.letter}" ${type.letter == selectedLetter ? "selected" : "" } >Type ${type.letter} - ${type.name}</option>
						</c:forEach>
					</select>
			</div><br/>
			
			<div class="form-group">
					<label for="value">Choose the treasure value:</label>
					<select id="value" class="form-control" name="value">
						<c:forEach items="${empty selectedValues ? types[0].values : selectedValues}" var="typeValue">
							<option value="${typeValue.value}" ${typeValue.value == selectedValue ? "selected" : "" }><fmt:formatNumber value="${typeValue.value}" /> gp</option>
						</c:forEach>
					</select><img id="loader" src="resources/img/loading-icon.gif" />
			</div><br/>
			
		<button id="generateBtn" class="btn btn-primary" type="submit">Generate</button>
		</form>
	</div>

	<br/><br/>

	<c:import url="/WEB-INF/views/import/treasureTable.jsp" />

</div>

<br/><br/><br/><br/>
