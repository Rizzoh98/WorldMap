package it.objectmethod.worldmap.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.worldmap.dao.NationDao;
import it.objectmethod.worldmap.domain.Nation;

public class NationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Nation> nazioni = new ArrayList<Nation>();
		String continent = request.getParameter("continent");
		
		HttpSession session = request.getSession();
		
		request.setAttribute("continent",continent);

		NationDao nationDao = new NationDao();
		try {	
			nazioni = nationDao.getAllNation(continent);
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("risultato", nazioni);
		request.getRequestDispatcher("/Nazioni.jsp").forward(request, response);

	}

}
