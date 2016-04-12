<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
td /* Toutes les cellules des tableaux... */
{
    border: 1px solid black; /* auront une bordure de 1px */
}
</style>
<body>
<c:if test="${(not empty votrenom)}">
<div> ${votrenom} is connected </div>
</c:if><br/> <br/>

${RechercheDataErreur}

<a href="LogoutController">quitter la session/seConnecter</a>
<table>
   <tr>
       <td>Appareil</td>
       <td>Temperature</td>
       <td>taux Humidite</td>
       <td>Pression</td>
   </tr>
   <c:forEach var="clim" items="${maliste}">
   <tr>
  		<td>${clim.nomSalle}</td>
       <td>${clim.temperature}</td>
       <td>${clim.tauxHumidite}</td>
       <td>${clim.pression}</td>
   </tr>
   </c:forEach>
</table>



<ul>
<c:forEach var="clim" items="${maliste}" >
<li>${clim}</li>
</c:forEach>
</ul>
</body>
</html>