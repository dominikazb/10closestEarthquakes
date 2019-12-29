
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




<div class="container">

	<div class="jumbotron">

		<div class="formDiv1">
			<div class="formDiv2">

				<form action="/read" method="post">


					<label>Latitude</label> 
					<fieldset class="form-group">
						<input type="text" 
						name="latitude" 
						id="latitude" 
						class="form-control" 
						placeholder="Latitude"
						required="required"
						oninvalid="this.setCustomValidity('Type in latitude in a format 00.000')"
     					onchange="try{setCustomValidity('')}catch(e){}"
    					oninput="setCustomValidity(' ')"
						required="required" pattern="^[-]?(\d+|\d*\.\d+)$" />
					</fieldset>
					
					<label>Longitude</label> 
					<fieldset class="form-group">
						<input type="text" 
						name="longitude" 
						id="longitude" 
						class="form-control" 
						placeholder="Longitude"
						oninvalid="this.setCustomValidity('Type in longitude in a format 00.000')"
     					onchange="try{setCustomValidity('')}catch(e){}"
    					oninput="setCustomValidity(' ')"			
						required="required" 
						pattern="^[-]?(\d+|\d*\.\d+)$" />
					</fieldset>
					
					<fieldset class="form-group">
					<label>Select a city</label> <select
						class="form-control" id="countrySelect">
						<option>None</option>
						<option value="35.084385_-106.650421">Albuquerque</option>								
						<option value="33.748997_-84.387985">Atlanta</option>
						<option value="41.878113_-87.629799">Chicago</option>							
						<option value="32.776665_-96.796989">Dallas</option>
						<option value="39.739235_-104.990250">Denver</option>	
						<option value="31.761877_-106.485023">El Paso</option>															
						<option value="29.760427_-95.369804">Houston</option>														
						<option value="30.332184_-81.655647">Jacksonville</option>
						<option value="39.099728_-94.578568">Kansas City</option>	
						<option value="36.169941_-115.139832">Las Vegas</option>								
						<option value="34.052235_-118.243683">Los Angeles</option>														
						<option value="35.149532_-90.048981">Memphis</option>	
						<option value="43.038902_-87.906471">Milwaukee</option>			
						<option value="44.977753_-93.265015">Minneapolis</option>														
						<option value="29.951065_-90.071533">New Orleans</option>																					
						<option value="40.712776_-74.005974">New York City</option>
						<option value="28.538336_-81.379234">Orlando</option>						
						<option value="39.952583_-75.165222">Philadelphia</option>
						<option value="33.448376_-112.074036">Phoenix</option>								
						<option value="40.440624_-79.995888">Pittsburgh</option>
						<option value="45.512230_-122.658722">Portland</option>									
						<option value="38.581573_-121.494400">Sacramento</option>									
						<option value="29.424122_-98.493629">San Antonio</option>	
						<option value="32.715736_-117.161087">San Diego</option>										
						<option value="37.338207_-121.886330">San Jose</option>																									
						<option value="47.606209_-122.33206">Seattle</option>
						<option value="38.627003_-90.199402">St. Louis</option>	
						<option value="32.222607_-110.974709">Tucson</option>							
						<option value="38.907192_-77.036873">Washington D.C.</option>																							
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
