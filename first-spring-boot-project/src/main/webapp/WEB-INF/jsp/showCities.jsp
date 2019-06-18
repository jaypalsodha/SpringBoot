<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h2 align="center">City vs Population</h2>
	<table  class="table table-striped table-bordered table-hover">
		<thead class="thead-dark">
			<tr align="center">
			   <th class="text-center">Id</th>
				<th class="text-center">Name</th>
				<th class="text-center">Population</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cities}" var="city">
			<tr>
	     		<td class="text-center">${city.id}</td>
                    <td>${city.name}</td>
                    <td align="right">${city.population}</td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
<%@ include file="common/footer.jspf" %>	