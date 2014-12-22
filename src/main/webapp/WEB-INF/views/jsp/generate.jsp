<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	
		<nav>
			<ul>
				<li><a>Back</a></li>
				<li><a>Home</a></li>
				<li><a>Regenerate</a></li>
			</ul>
		</nav>
	
		<h3>Result for <fmt:formatNumber value="${selectedValue}" /> gp of Treasure Type ${selectedLetter}</h3>
		
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
					<td><fmt:formatNumber value="${totalPrice}" /> gp</td>
				</tr>
			</tfoot>
		</table>
	</body>
</html>