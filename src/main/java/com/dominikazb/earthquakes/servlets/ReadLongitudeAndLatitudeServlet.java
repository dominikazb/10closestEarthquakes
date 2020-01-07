package com.dominikazb.earthquakes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dominikazb.earthquakes.engine.ReadJsonFile;


@WebServlet("/read")
public class ReadLongitudeAndLatitudeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected ReadJsonFile readJson = new ReadJsonFile();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); 
		String latitudeOfSearchedCityString = request.getParameter("latitudeOfSearchedCity");
		String longitudeOfSearchedCityString = request.getParameter("longitudeOfSearchedCity");
		session.setAttribute("latitudeOfSearchedCityString", latitudeOfSearchedCityString);
		session.setAttribute("longitudeOfSearchedCityString", longitudeOfSearchedCityString);
        response.sendRedirect("list");
	}
}
