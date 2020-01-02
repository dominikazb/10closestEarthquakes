
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>



<div class="container">
	<div class="jumbotron">
		<div class="topCaption1">
			<div class="topCaption2">
				<p class="lead">Type in the latitude and the longitude of a
					chosen city.</p>
			</div>
		</div>
		<hr class="my-4">
	</div>
</div>


<jsp:include page="latLongForm.jsp" />


<div class="container">
	<div class="jumbotron">
		<div class="resultsTable1">
			<div class="resultsTable2">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Distance</th>
							<th>Location</th>

						</tr>
					</thead>

					<tbody>
						<c:forEach items="${outputMap}" var="entry">
							<tr>
								<td><fmt:formatNumber type="number" maxFractionDigits="1"
										value="${entry.key}" /> KM</td>
								<td><c:out value="${entry.value}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>



<%@ include file="common/footer.jspf"%>
