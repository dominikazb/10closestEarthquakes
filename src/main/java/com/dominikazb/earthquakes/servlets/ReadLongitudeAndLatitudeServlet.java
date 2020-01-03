package com.dominikazb.earthquakes.servlets;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dominikazb.earthquakes.engine.ReadJsonFile;


@WebServlet("/read")
public class ReadLongitudeAndLatitudeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected ReadJsonFile readJson = new ReadJsonFile();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String latitudeOfSearchedCityString = (String)request.getParameter("latitudeOfSearchedCity");
		String longitudeOfSearchedCityString = (String)request.getParameter("longitudeOfSearchedCity");
		readJson.convertJsonToJavaObjects(latitudeOfSearchedCityString, longitudeOfSearchedCityString);
		response.sendRedirect("read");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		TreeMap<Double, String> outputMap = readJson.read10closestCities();
		request.setAttribute("outputMap", outputMap);
		request.getRequestDispatcher("/earthquakesList.jsp").forward(request, response);
	}
}
