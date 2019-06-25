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

public class ModificationCityServlet extends HttpServlet {

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
		
		
		
		switch(route) {
		
		
		case "deletecity" :
			
			city = request.getParameter("city");
			countrycode=null;
			cityDao = new CityDao();
			session = request.getSession();
			countrycode=(String)session.getAttribute("nation");
			
			try {
				cityDao.deleteCity(city);
				citta = cityDao.getAllCity(countrycode);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("countrycode", countrycode);
			request.setAttribute("risultato", citta);
			request.getRequestDispatcher("/Citta.jsp?countrycode="+countrycode).forward(request, response);
			
		break;
		
		case "updatecity" :
			
			city2 = request.getParameter("renamecity");
			city = request.getParameter("city");
			cityDao = new CityDao();
			session = request.getSession();
			countrycode =(String)session.getAttribute("nation");
			
			try {
				cityDao.updateCity(city,city2);
				citta = cityDao.getAllCity(countrycode);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("risultato", citta);
			request.getRequestDispatcher("/Citta.jsp").forward(request, response);
			
		break;
		
		case "addcity" :
			
			city = request.getParameter("addcity");
			cityDao = new CityDao();
			session = request.getSession();
			countrycode=(String)session.getAttribute("nation");
			
			try {
				cityDao.addCity(city, countrycode);
				citta = cityDao.getAllCity(countrycode);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("risultato", citta);
			request.getRequestDispatcher("/Citta.jsp").forward(request, response);
			
		break;
		
		case "ordername" :
			
			city = request.getParameter("city");
			cityDao = new CityDao();
			order = request.getParameter("order");
			
			
			session = request.getSession();
			countrycode=(String)session.getAttribute("nation");
			
			try {
				citta = cityDao.orderCity(countrycode, order);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(order == null || order.equals("0")) 
			{
				order="1";
			}
			else
			{
				order="0";
			}
			
			request.setAttribute("order", order);
			request.setAttribute("countrycode", countrycode);
			request.setAttribute("risultato", citta);
			request.getRequestDispatcher("/Citta.jsp?countrycode="+countrycode).forward(request, response);
		
		break;
		
		case "orderpopulation" :
			
			cityDao = new CityDao();
			session = request.getSession();
			countrycode = (String)session.getAttribute("nation");
			order = request.getParameter("order");
			
			try {
				citta = cityDao.orderPopulation(countrycode, order);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(order == null || order.equals("0")) 
			{
				order = "1";
			}
			else
			{
				order = "0";
			}
			
			request.setAttribute("order", order);
			request.setAttribute("countrycode", countrycode);
			request.setAttribute("risultato", citta);
			request.getRequestDispatcher("/Citta.jsp?countrycode="+countrycode).forward(request, response);
		
		break;
		
		}
		
		
	}
		
}
