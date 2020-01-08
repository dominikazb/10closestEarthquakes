
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>



<div class="container">
	<div class="jumbotron">

		<h1 class="display-4">Explanation</h1>

		<hr class="my-4">


		<p class="lead">
			<a
				href="https://www.usgs.gov/natural-hazards/earthquake-hazards/about?qt-science_support_page_related_con=0#qt-science_support_page_related_con">USGS
				Earthquake Hazards Program</a> is an organization that analyzes
			earthquake threats around the world.
		</p>

		<p class="lead">
			<a
				href="https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson">Here</a>
			is the list of earthquakes that happened in the last 30 days.
		</p>

		<p class="lead">
			Explanation for the structure of this file can be found <a
				href="https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php">here</a>.
		</p>

		<p class="lead">By typing in longitude and latitude of a chosen
			city, my program calculates 10 earthquakes that happened in the
			closest proximity.</p>







	</div>
</div>



<div class="container">
	<div class="jumbotron">
		<h2>Longitude and Latitude</h2>

		<hr class="my-4">
		<h4>Longitude</h4>
		<p class="lead">The angular distance of a place east or west of
			the Greenwich meridian, or west of the standard meridian of a
			celestial object, usually expressed in degrees and minutes.</p>


		<h4>Latitude</h4>
		<p class="lead">The angular distance of a place north or south of
			the earth's equator, or of the equator of a celestial object, usually
			expressed in degrees and minutes.</p>
		<hr>
		

		<h4>Read latitude and longitude of a particular city: <a href="https://www.latlong.net/">https://www.latlong.net/</a></h4>
		
		<hr>
		<p>
			<a href="https://www.britannica.com/science/latitude">Read more about latitude and longitude
				&raquo;</a>
		</p>
	</div>
</div>



<div class="container">
	<div class="jumbotron">
		<p class="lead">
			<a href="https://github.com/dominikazb/10closestEarthquakes">Github
				repository for this project</a>
		</p>
	</div>
</div>






<%@ include file="common/footer.jspf"%>
