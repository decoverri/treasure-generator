<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${not empty treasures}">
	<h2>Result</h2>
	<table>
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
				<td>Total price generated</td>
				<td><fmt:formatNumber type="number" value="${totalPrice}" /> gp</td>
			</tr>
		</tfoot>
	</table>
</c:if>
