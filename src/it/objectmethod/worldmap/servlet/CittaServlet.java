package it.objectmethod.worldmap.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.worldmap.dao.CityDao;
import it.objectmethod.worldmap.domain.City;

public class CittaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String route = request.getParameter("route");
		String city = null;
		String city2 = null;
		String countrycode = null;
		ArrayList<City> citta = null;
		CityDao cityDao = null;
		String order = null;
		String population = null;

		HttpSession session = request.getSession();

		citta = new ArrayList<City>();
		countrycode = request.getParameter("nation");
		session = request.getSession();
		session.setAttribute("nation", countrycode);
		cityDao = new CityDao();

		try {
			citta = cityDao.getAllCity(countrycode);
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("risultato", citta);
		request.getRequestDispatcher("/Citta.jsp").forward(request, response);

		


	}

}
