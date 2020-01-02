package com.dominikazb.earthquakes.servlets;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dominikazb.earthquakes.engine.ReadJsonFile;

@WebServlet("/list")
public class PrintEarthquakesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TreeMap<Double, String> outputMap = ReadJsonFile.getReadJson().read10closestCities();
		request.setAttribute("outputMap", outputMap);
		request.getRequestDispatcher("/earthquakesList.jsp").forward(request, response);
	}
}
