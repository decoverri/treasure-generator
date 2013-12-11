<div class="container">
	<form action="generate">
		<select>
			<c:forEach items="${types}" var="type">
				<option><b>Type ${type.letter}</b> - ${type.name}</option>
			</c:forEach>
		</select>
	</form>
</div>
