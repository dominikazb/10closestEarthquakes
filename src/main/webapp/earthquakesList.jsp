
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>



<div class="container">
	<div class="jumbotron">
		<div class="topCaption1">
			<div class="topCaption2">
				<h4>Type in the latitude and the longitude of a chosen city.</h4>
			</div>
		</div>
		<hr class="my-4">
	</div>
</div>




<div class="container">
	<div class="jumbotron">
		<div class="row vertical-align">
			<div class="col-xs-6">
				<jsp:include page="latLongForm.jsp" />
			</div>
			<div class="col-xs-6">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Distance</th>
							<th>Location</th>

						</tr>
					</thead>

					<tbody>
						<c:forEach items="${first10resultsFromTheList}" var="entry">
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
