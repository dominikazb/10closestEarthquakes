package com.dominikazb.earthquakes.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dominikazb.earthquakes.engine.Coordinates;
import com.dominikazb.earthquakes.engine.PrintListOf10ClosestEarthquakes;

@WebServlet("/list")
public class PrintEarthquakesListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintListOf10ClosestEarthquakes printList = new PrintListOf10ClosestEarthquakes();
        HttpSession session = request.getSession(false); 
        TreeMap<Coordinates, String> coordinatesNamesMap = (TreeMap<Coordinates, String>) session.getAttribute("coordinatesNamesMap");
        String latitude = session.getAttribute("latitudeOfSearchedCityString").toString();
        String longitude = session.getAttribute("longitudeOfSearchedCityString").toString();
        TreeMap<Double, String> first10resultsFromTheList = (TreeMap<Double, String>) printList.print10closestEarthquakes(coordinatesNamesMap, 
        		latitude, longitude);     
        request.setAttribute("first10resultsFromTheList", first10resultsFromTheList);
		request.getRequestDispatcher("/earthquakesList.jsp").forward(request, response);
	}
}
