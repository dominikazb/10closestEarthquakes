package com.dominikazb.earthquakes.servlets;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dominikazb.earthquakes.engine.Coordinates;
import com.dominikazb.earthquakes.engine.ReadJsonFile;

public class LoadJSonDataServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected ReadJsonFile readJson = new ReadJsonFile();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();
		Map<String,Coordinates> coordinatesNamesMap = readJson.readJSonAndConvertToJavaObjects();
		//?????
		if(coordinatesNamesMap.isEmpty()) {
			ReadJsonFile readJson = new ReadJsonFile();
			Map<String,Coordinates> coordinatesNamesMap2 = readJson.readJSonAndConvertToJavaObjects();
			session.setAttribute("coordinatesNamesMap", coordinatesNamesMap2);		
		}
		session.setAttribute("coordinatesNamesMap", coordinatesNamesMap);
		request.getRequestDispatcher("/earthquakesList.jsp").forward(request, response);
	}
}
