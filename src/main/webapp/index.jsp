
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<style>

.jumbotron{
background-color:white;
}


</style>





<div class="container">
	<div class="jumbotron">

		<h1 class="display-4">List of 10 closest earthquakes (US)</h1>
		<p class="lead">
			Type in the <b>longitude</b> and the <b>latitude</b> of a chosen city
			and get the list of <b>10 closest earthquakes</b>.
		</p>
		<hr class="my-4">
		<p>
			<a class="btn btn-primary btn-lg" href="/explanation" role="button">Learn
				more &raquo;</a>
		</p>
	</div>
</div>






<div class="container">

		<div class="jumbotron">

			<form action="/read" method="post">

				<fieldset class="form-group">			
					<label>Longitude</label>
					<input type="text" name="longitude" class="form-control" required="required"/>

				</fieldset>
				
				<fieldset class="form-group">			
					<label>Latitude</label>
					<input type="text" name="latitude" class="form-control" required="required"/>
	
				</fieldset>
				
				<br/>

				<button type="submit" class="btn btn-success btn-lg">Submit</button>
				<a class="btn btn-danger btn-lg" href="/list-todos" role="button">Cancel</a>
				
			</form>
		</div>
		
		</div>
		
		
<div class="container">
	<div class="jumbotron">

		<h2 class="display-4">Results:</h2>


		<table>
			<c:forEach var="entry" items="${outputMap}">
				<tr>
					<td><c:out value="${entry.key}" /></td>
					<td><c:out value="${entry.value}" /></td>
				</tr>
			</c:forEach>
		</table>






		<table class="table table-striped">

	
	
	
	
				
				<tbody>

					<tr>
						<td><p class="lead">1. Exemplary result lalalalalalalal</p></td>																																										
					</tr>
					<tr>
						<td><p class="lead">2. Exemplary result lalalalalalalal</p></td>	
					</tr>	
					<tr>
						<td><p class="lead">3. Exemplary result lalalalalalalal</p></td>	
					</tr>						
					<tr>
						<td><p class="lead">4. Exemplary result lalalalalalalal</p></td>	
					</tr>			
					<tr>
						<td><p class="lead">5. Exemplary result lalalalalalalal</p></td>	
					</tr>
					
					<tr>
						<td><p class="lead">6. Exemplary result lalalalalalalal</p></td>	
					</tr>						
					
					<tr>
						<td><p class="lead">7. Exemplary result lalalalalalalal</p></td>	
					</tr>						
					<tr>
						<td><p class="lead">8. Exemplary result lalalalalalalal</p></td>	
					</tr>						
					
					<tr>
						<td><p class="lead">9. Exemplary result lalalalalalalal</p></td>	
					</tr>						
					<tr>
						<td><p class="lead">10. Exemplary result lalalalalalalal</p></td>	
					</tr>							

				</tbody>

			</table>

	</div>
</div>






<%@ include file="common/footer.jspf"%>
