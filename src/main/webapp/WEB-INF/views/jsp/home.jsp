<div class="container">
	<br/>

	<form action="generate" method="post">
		<div class="form-group">
			<label for="type">Choose the treasure type:</label>
			<select id="type" name="letter" onchange="getTypeValues()">
				<c:forEach items="${types}" var="type">
					<option value="${type.letter}">Type ${type.letter} - ${type.name}</option>
				</c:forEach>
			</select>
		</div><br/>
		
		<div class="form-group">
			<label for="value">Choose the treasure value:</label>
			<select id="value" name="value">
				<c:forEach items="${types[0].values}" var="value">
					<option value="${value.value}" >${value.value} gp</option>
				</c:forEach>
			</select>
		</div><br/>

		<button class="btn btn-primary" type="submit">Generate</button>

	</form>
</div>

<c:import url="../import/treasureTable.jsp" />

<br/><hr><br/>

<div class="container">
	<h4>Description of the treasure types:</h4><br/>
	<ul>
		<c:forEach items="${types}" var="type">
			<li><b>Type ${type.letter} - ${type.name} :</b> ${type.description}</li><br/>
		</c:forEach>
	</ul>
</div>
