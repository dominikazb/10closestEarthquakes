package com.dominikazb.earthquakes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dominikazb.earthquakes.engine.ReadJsonFile;


@WebServlet("/read")
public class ReadLongitudeAndLatitudeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String longitudeString = request.getParameter("longitude");
		String latitudeString = request.getParameter("latitude");		
		double longitude = Double.parseDouble(longitudeString);
		double latitude = Double.parseDouble(latitudeString);			
		ReadJsonFile.getReadJson().convertJsonToJavaObjects(longitude, latitude);
		ReadJsonFile.getReadJson().read10closestCities();
		
		response.sendRedirect("list");
	}
	
	




}
