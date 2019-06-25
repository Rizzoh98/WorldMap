package it.objectmethod.worldmap.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldmap.domain.Continent;
import it.objectmethod.worldmap.dao.ContinentDao;


public class ContinentiServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Continent> continenti = new ArrayList<Continent>();
		
		ContinentDao continentDao = new ContinentDao();
		try {
			continenti = continentDao.getAllContinent();
		}catch(Exception e){
			
			e.printStackTrace();
		}
		//
		request.setAttribute("risultato", continenti);
		request.getRequestDispatcher("/Continenti.jsp").forward(request, response);

	}

}
