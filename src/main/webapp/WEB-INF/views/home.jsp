<div class="container">
	<br/>

	<form action="generate">
		<div class="form-group">
			<label for="type">Choose the treasure type:</label>
			<select id="type">
				<option></option>
				<c:forEach items="${types}" var="type">
					<option>Type ${type.letter} - ${type.name}</option>
				</c:forEach>
			</select>
		</div><br/>
		
		<div class="form-group">
			<label for="value">Choose the treasure value:</label>
			<select id="value" >
				<option></option>
			</select>
		</div><br/>

		<button class="btn btn-primary" type="submit">Generate</button>

	</form>
</div>

<br/><br/>

<div class="container">
	<h4>Description of the treasure types:</h4><br/>
	<ul>
		<c:forEach items="${types}" var="type">
			<li><b>Type ${type.letter} - ${type.name} :</b> ${type.description}</li><br/>
		</c:forEach>
	</ul>
</div>
