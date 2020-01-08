package com.dominikazb.earthquakes.servlets;

import java.io.IOException;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.dominikazb.earthquakes.engine.Coordinates;
import com.dominikazb.earthquakes.engine.ReadJsonFile;

public class ContextListenerImpl implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		ReadJsonFile readJson = new ReadJsonFile();
		try {
			TreeMap<Coordinates,String> coordinatesNamesMap = readJson.readJSonAndConvertToJavaObjects();
			sc.setAttribute("coordinatesNamesMap", coordinatesNamesMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
	
}
