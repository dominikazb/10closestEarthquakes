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
	
	private static double longitude;
	private static double latitude;

	public static double getLongitude() {
		return longitude;
	}

	public static double getLatitude() {
		return latitude;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String longitudeString = request.getParameter("longitude");
		String latitudeString = request.getParameter("latitude");		
		longitude = Double.parseDouble(longitudeString);
		latitude = Double.parseDouble(latitudeString);			
		ReadJsonFile.getReadJson().convertJsonToJavaObjects();
		response.sendRedirect("list");
	}
	
	




}
