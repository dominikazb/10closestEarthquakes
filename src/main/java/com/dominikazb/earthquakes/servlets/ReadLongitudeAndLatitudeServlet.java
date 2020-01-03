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

import com.dominikazb.earthquakes.engine.ReadJsonFile;
import com.dominikazb.earthquakes.engine.Coordinates;
import com.dominikazb.earthquakes.engine.PrintListOf10ClosestEarthquakes;


@WebServlet("/read")
public class ReadLongitudeAndLatitudeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected ReadJsonFile readJson = new ReadJsonFile();
	protected PrintListOf10ClosestEarthquakes printList = new PrintListOf10ClosestEarthquakes();

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String latitudeOfSearchedCityString = (String)request.getParameter("latitudeOfSearchedCity");
		String longitudeOfSearchedCityString = (String)request.getParameter("longitudeOfSearchedCity");
        HttpSession session = request.getSession(false); 
        Map<String, Coordinates> coordinatesNamesMap = (Map<String, Coordinates>) session.getAttribute("coordinatesNamesMap");
        TreeMap<Double, String> first10resultsFromTheList = (TreeMap<Double, String>) printList.print10closestEarthquakes(coordinatesNamesMap, latitudeOfSearchedCityString, longitudeOfSearchedCityString);
		session.setAttribute("first10resultsFromTheList", first10resultsFromTheList);
        response.sendRedirect("list");
	}
}
