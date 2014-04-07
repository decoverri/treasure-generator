<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${not empty treasures}">
<div class="dont-float">
	<br/>
	<hr id="result" >
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
		</tbody>
		<tfoot>		
			<tr>
				<td><strong>Total price generated</strong></td>
				<td><strong><fmt:formatNumber type="number" value="${totalPrice}" /> gp</strong></td>
			</tr>
		</tfoot>
	</table>
</div>
</c:if>
