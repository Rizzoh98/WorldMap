<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style type="text/css">
body {
	background-image:
		url('https://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


	<div align="center">



		<h1>LISTA CITTA'</h1>

		<br>

		<form action="Mod">
			<input type="text" name="addcity" value=""> 
			<input type="submit" value="AGGIUNGI"> 
			<input type="hidden" value="addcity" name="route"> 
			<input type="hidden" value="${Citta.name}" name="city"> 
			<input type="hidden" value="${param.nation}" name="countrycode">
		</form>

		<br> <br> <br>

		<table align="center">

			<tr>
			
				<td>
					<form action="Mod">
						<input type="submit" value="A-Z / Z-A"> 
						<input type="hidden" value="ordername" name="route"> 
						<input type="hidden" value="${Citta.name}" name="city"> 
						<input type="hidden" value="${param.nation}" name="countrycode">
						<input type="hidden" value="${order}" name="order">
					</form>
				</td>

				<td>
					<form action="Mod">
						<input type="submit" value="Max/Min"> 
						<input type="hidden" value="orderpopulation" name="route"> 
						<input type="hidden" value="${Citta.name}" name="city"> 
						<input type="hidden" value="${Citta.population}" name="population"> 
						<input type="hidden" value="${param.nation}" name="countrycode">
						<input type="hidden" value="${order}" name="order">
					</form>
				</td>
			
			</tr>


			<c:forEach items="${risultato}" var="Citta">
				<tr>
					<td>
						<p>${Citta.name}</p>
					</td>

					<td>
						<p>${Citta.population}</p>
					</td>

					<td>
						<form action="Mod">
							<input type="submit" value="ELIMINA"> 
							<input type="hidden" value="deletecity" name="route"> 
							<input type="hidden" value="${Citta.name}" name="city"> 
							<input type="hidden" value="${param.nation}" name="countrycode">
						</form>
					</td>

					<td>
						<form action="Mod">
							<input type="text" name="renamecity" value=""> 
							<input type="submit" value="MODIFICA"> 
							<input type="hidden" value="updatecity" name="route"> 
							<input type="hidden" value="${Citta.name}" name="city"> 
							<input type="hidden" value="${param.nation}" name="countrycode">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>