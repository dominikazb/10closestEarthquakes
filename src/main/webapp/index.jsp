
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
		<div class="indexDiv">
			<div class="indexDiv2">
				<jsp:include page="latLongForm.jsp" />
			</div>
		</div>
	</div>

</div>


<%@ include file="common/footer.jspf"%>
