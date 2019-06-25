package it.objectmethod.worldmap.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldmap.servlet.ContinentiServlet;
import it.objectmethod.worldmap.DBconnection.ConnectionDB;
import it.objectmethod.worldmap.domain.Continent;

public class ContinentDao {
	public ArrayList<Continent> getAllContinent() {
		ArrayList<Continent> continents = new ArrayList<Continent>();
		
		Continent continent = null;
		
		Connection connession = null;
		Statement stmt = null;
		ResultSet result = null;

		try {
			
			connession = ConnectionDB.getConnection();
			String sql = "SELECT DISTINCT Continent FROM country";
			stmt = connession.createStatement();
			result = stmt.executeQuery(sql);
			
			while(result.next()){
				
				continent = new Continent();
				continent.setName(result.getString("Continent"));
				continents.add(continent);
				
			}
			result.close();
			stmt.close();
			connession.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		finally {

		      try {

		        if (result != null)
		        	result.close();

		        if (stmt != null)
		          stmt.close();

		        if (connession != null)
		        	connession.close();

		      } catch (Exception xe) {
		        xe.printStackTrace();
		      }

		    }

		return continents;
	}

}
