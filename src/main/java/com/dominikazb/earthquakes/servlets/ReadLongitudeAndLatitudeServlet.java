package com.dominikazb.earthquakes.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dominikazb.earthquakes.engine.Coordinates;
import com.dominikazb.earthquakes.engine.Countries;
import com.dominikazb.earthquakes.engine.ReadJsonFile;


@WebServlet("/read")
public class ReadLongitudeAndLatitudeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String latitudeString = request.getParameter("latitude");	
		String longitudeString = request.getParameter("longitude");
		double latitude = Double.parseDouble(latitudeString);
		double longitude = Double.parseDouble(longitudeString);
		ReadJsonFile.getReadJson().convertJsonToJavaObjects(latitude, longitude);
		
		Map<String, Coordinates> listOfCountries = Countries.getCountries();
		
		for(Map.Entry<String, Coordinates> entry : listOfCountries.entrySet()) {
			System.out.println(entry.getKey() + " || " + entry.getValue());
		}
		
		
		response.sendRedirect("list");
	}
	
	




}
