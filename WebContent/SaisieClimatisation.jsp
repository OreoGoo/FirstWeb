<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="Climatisationnombre.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<body>

<c:if test="${(not empty votrenom)}">
<div> ${votrenom} is connected </div>
</c:if><br/> <br/>


<a href="LogoutController">se connecter/quitter session</a>


<form action="ClimController" method="POST">  <!-- attetion le action ici est different du name="action" -->



<label>nom appareil</label> <input id="sourceNbID" type="text" value="${nom}" name="NomAppareil" /><br>
<span id="nbID" style="color:blue"></span>
<label>temperature</label> <input  type="text" value="${temp}" name="Temperature" /><span style ="color: red">${TempErreur} </span><br>
<label>taux humidité</label> <input type="text" value="${txh}" name="TauxHumidité" /><span style ="color: red">${humiditéErreur}</span><br>
<label>pression</label> <input type="text" value="${press}" name="Pression" /><span style ="color: red">${pressionErreur}</span><br>

<input type="submit" value="enregistrer" name="boutonAction" /><br>

${RechercheDataErreur}

</form>



</body>
</html>