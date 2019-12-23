package com.dominikazb.earthquakes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dominikazb.earthquakes.engine.ReadJsonFile;


@WebServlet("/explanation")
public class ExplanationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/explanation.jsp");
		ReadJsonFile file = new ReadJsonFile();
		file.convertJsonToJavaObjects();
		file.read10closestCities();
	}

}
