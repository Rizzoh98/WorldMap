package it.objectmethod.worldmap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.objectmethod.worldmap.DBconnection.ConnectionDB;
import it.objectmethod.worldmap.domain.City;

public class CityDao {

	public ArrayList<City> getAllCity(String nation) {
		ArrayList<City> citys = new ArrayList<City>();
		
		Connection connession = null;
		PreparedStatement stmt = null;
		ResultSet result = null;

		City city = null;

		try {

			connession = ConnectionDB.getConnection();
			String sql = "SELECT DISTINCT Name, Population FROM city WHERE CountryCode= ?";
			stmt = connession.prepareStatement(sql);
			stmt.setString( 1 , nation);
			result = stmt.executeQuery();

			while (result.next()) {

				city = new City();
				city.setName(result.getString("Name"));
				city.setPopulation(result.getString("Population"));
				citys.add(city);

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

		return citys;
	}
	
	public void deleteCity(String city)
	{
		
		Connection connession = null;
		PreparedStatement stmt = null;
		
		try {

			connession = ConnectionDB.getConnection();
			String sql = "DELETE FROM city WHERE Name = ?";
			stmt = connession.prepareStatement(sql);
			stmt.setString( 1 , city);
			 
			stmt.executeUpdate();

			stmt.close();
			connession.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		finally {

		      try {

		        if (stmt != null)
		          stmt.close();

		        if (connession != null)
		        	connession.close();

		      } catch (Exception xe) {
		        xe.printStackTrace();
		      }

		    }

	}
	
	public void updateCity(String city1, String city2)
	{
		
		Connection connession = null;
		PreparedStatement stmt = null;
		
		try {
			connession = ConnectionDB.getConnection();
			String sql = "UPDATE city SET Name=? WHERE Name = ?";
			stmt = connession.prepareStatement(sql);
			stmt.setString( 1 , city2);
			stmt.setString( 2 , city1);
			 
			stmt.executeUpdate();

			stmt.close();
			connession.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		finally {

		      try {

		        if (stmt != null)
		          stmt.close();

		        if (connession != null)
		        	connession.close();

		      } catch (Exception xe) {
		        xe.printStackTrace();
		      }

		    }

	}
	
	public void addCity(String cityadd,String countrycode)
	{
		Connection connession = null;
		PreparedStatement stmt = null;
		
		try {
			connession = ConnectionDB.getConnection();
			//String sql = "INSERT INTO city(Name,CountryCode) VALUES (Name = ?,CountryCode= ? )";
			String sql = "INSERT INTO city " + "(Name,CountryCode) values (?,?)";
			stmt = connession.prepareStatement(sql);
			stmt.setString( 1 , cityadd);
			stmt.setString( 2 , countrycode);
			 
			stmt.executeUpdate();

			stmt.close();
			connession.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		finally {

		      try {

		        if (stmt != null)
		          stmt.close();

		        if (connession != null)
		        	connession.close();

		      } catch (Exception xe) {
		        xe.printStackTrace();
		      }

		    }

	}
	
	public ArrayList<City> orderCity(String nation,String order)
	{
		
			
			
			ArrayList<City> citys = new ArrayList<City>();

			City city = null;
			
			
			Connection connession = null;
			PreparedStatement stmt = null;
			ResultSet result = null;

			try {

				connession = ConnectionDB.getConnection();
				String sql = null;
				
				
				if(order == null || order.equals("0")) 
				{
					sql = "SELECT DISTINCT Name, Population FROM city WHERE CountryCode= ? ORDER BY Name DESC";
				}
				else
				{
					sql = "SELECT DISTINCT Name, Population FROM city WHERE CountryCode= ? ORDER BY Name ASC";
				}
				
				stmt = connession.prepareStatement(sql);
				stmt.setString( 1 , nation);
				result = stmt.executeQuery();

				while (result.next()) {

					city = new City();
					city.setName(result.getString("Name"));
					city.setPopulation(result.getString("Population"));
					citys.add(city);

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

			return citys;

	}
	
	public ArrayList<City> orderPopulation(String nation,String order)
	{
		
			
			
			ArrayList<City> citys = new ArrayList<City>();

			City city = null;
			
			
			Connection connession = null;
			PreparedStatement stmt = null;
			ResultSet result = null;

			try {

				connession = ConnectionDB.getConnection();
				String sql = null;
				
				
				if(order == null || order.equals("0")) 
				{
					sql = "SELECT DISTINCT Name, Population FROM city WHERE CountryCode= ? ORDER BY Population DESC";
				}
				else
				{
					sql = "SELECT DISTINCT Name, Population FROM city WHERE CountryCode= ? ORDER BY Population ASC";
				}
				
				stmt = connession.prepareStatement(sql);
				stmt.setString( 1 , nation);
				result = stmt.executeQuery();

				while (result.next()) {

					city = new City();
					city.setName(result.getString("Name"));
					city.setPopulation(result.getString("Population"));
					citys.add(city);

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

			return citys;

	}

}
