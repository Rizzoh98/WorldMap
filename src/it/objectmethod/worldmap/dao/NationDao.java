package it.objectmethod.worldmap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.objectmethod.worldmap.DBconnection.ConnectionDB;
import it.objectmethod.worldmap.domain.Nation;

public class NationDao {

	public ArrayList<Nation> getAllNation(String continent) {
		ArrayList<Nation> nations = new ArrayList<Nation>();

		Nation nation = null;
		
		Connection connession = null;
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {

			connession = ConnectionDB.getConnection();
			String sql = "SELECT DISTINCT Name,Code FROM country WHERE Continent = ?";
			stmt = connession.prepareStatement(sql);
			stmt.setString(1, continent);
			result = stmt.executeQuery();

			while (result.next()) {

				nation = new Nation();
				nation.setName(result.getString("Name"));
				nation.setCountrycode(result.getString("Code"));
				nations.add(nation);

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

		return nations;
	}

}
