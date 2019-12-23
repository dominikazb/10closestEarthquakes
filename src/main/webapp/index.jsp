
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<style>
.jumbotron {
	background-color: white;
}

.topCaption1 {
	text-align: center;
}

.topCaption2 {
	width: 600px;
	display: inline-block;
}

.formDiv1 {
	text-align: center;
}

.formDiv2 {
	width: 400px;
	display: inline-block;
}

input[type='text'] {
	font-size: 20px;
	height: 50px;
}

#submit-button {
	font-size: 20px;
	height: 50px;
}

.resultsTable1 {
	text-align: center;
}

.resultsTable2 {
	width: 700px;
	display: inline-block;
}
</style>





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




<div class="container">

	<div class="jumbotron">

		<div class="formDiv1">
			<div class="formDiv2">

				<form action="/read" method="post">



					<fieldset class="form-group">
						<input type="text" name="latitude" value="Autofill here"
							id="latitude" class="form-control" placeholder="Latitude"
							required="required"
							onkeypress="return (event.charCode !=8 && event.charCode ==0 || ( event.charCode == 46 || (event.charCode >= 48 && event.charCode <= 57)))" />
					</fieldset>

					<fieldset class="form-group">
						<input type="text" name="longitude" value="Autofill here"
							id="longitude" class="form-control" placeholder="Longitude"
							required="required"
							onkeypress="return (event.charCode !=8 && event.charCode ==0 || ( event.charCode == 46 || (event.charCode >= 48 && event.charCode <= 57)))" />
					</fieldset>

					<fieldset class="form-group">


						<label for="exampleFormControlSelect1">Select a city</label> <select
							class="form-control" id="countrySelect">
							<option>None</option>
							<option value="NewYorkCity">New York City</option>
							<option value="Seattle">Seattle</option>
							<option value="Washington D.C.">3</option>
							<option>4</option>
							<option>5</option>
						</select>


					</fieldset>

					<br />

					<button type="submit" class="btn btn-info my-4 btn-block"
						id="submit-button">Submit</button>

				</form>

			</div>

		</div>

	</div>

</div>


<div class="container">
	<div class="jumbotron">

		<div class="resultsTable1">
			<div class="resultsTable2">

				<h2 class="display-4">Results:</h2>




				<table class="table table-striped">
					<thead>
						<tr>
							<th>Distance</th>
							<th>Location</th>

						</tr>
					</thead>

					<tbody>
						<c:forEach var="entry" items="${outputMap}">
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
