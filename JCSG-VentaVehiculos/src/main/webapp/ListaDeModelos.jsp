<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>José Carlos Sánchez García</title>
<style>
 @import url('https://fonts.googleapis.com/css2?family=Audiowide&family=Quantico&display=swap');
 

 
body{
background: rgb(251,179,33);
background: linear-gradient(162deg, rgba(251,179,33,0.8352591036414566) 10%, rgba(255,12,12,0.8352591036414566) 89%);
background-size: cover;
background-repeat: no-repeat;
}

h1{
text-align:center;
font-size: 4em;
margin-top: 30px;
margin-bottom:30px;
font-family: 'Audiowide',sans-serif;
}

a{
color: red;
text-decoration: none;
}

a:hover{
color: rgb(244, 179, 0);
}

table {
  border: 1px solid #ccc;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
  width: 100%;
  table-layout: fixed;
  box-shadow: 5px 5px 5px #888888;
  border-radius: 15px;
}

table caption {
  font-size: 1.5em;
  margin: .5em 0 .75em;
}

table tr {
  background-color: #f8f8f8;
  border: 1px solid #ddd;
  padding: .35em;
  font-family: 'Audiowide',sans-serif;
}

table th,
table td {
  padding: .625em;
  text-align: center;
}

table th {
  font-size: 1.25em;
  letter-spacing: .1em;
  text-transform: uppercase;
}

.custom-button {
        background-color: white;
        color: black;
        border: none;
        border-radius: 10px;
        box-shadow: 0 0 5px white;
        padding: 10px 20px;
        transition: transform 0.3s ease-in-out;
        margin-top: 2%;
        margin-bottom:2%;
        margin-left: 40%;
        font-family: 'Audiowide', sans-serif;
        font-size: 1.5em;
    }

    .custom-button:hover {
        transform: scale(1.2);
    }

@media screen and (max-width: 600px) {
  table {
    border: 0;
  }

  table caption {
    font-size: 1.3em;
  }
  
  table thead {
    border: none;
    clip: rect(0 0 0 0);
    height: 1px;
    margin: -1px;
    overflow: hidden;
    padding: 0;
    position: absolute;
    width: 1px;
  }
  
  table tr {
    border-bottom: 3px solid #ddd;
    display: block;
    margin-bottom: .625em;
  }
  
  table td {
    border-bottom: 1px solid #ddd;
    display: block;
    font-size: .8em;
    text-align: right;
  }
  
  table td::before {
    float: left;
    font-weight: bold;
    text-transform: uppercase;
  }
  
  table td:last-child {
    border-bottom: 0;
  }
}
</style>
</head>



<body>

<h1>Vehiculos Disponibles</h1>

<input type="button" class="custom-button" value="Insertar Resgistro" onclick="window.location.href='insertarModelo.jsp'"/>

<table>

<tr>
<th>Id</th>
<th>Marca</th>
<th>Modelo</th>
<th>Motor</th>
<th>Potencia</th>
<th>Fecha de Registro</th>
<th>Actualizar</th>
<th>Eliminar</th>
</tr>

<c:forEach var="tempMod" items="${listaModelos}">

<c:url var="linkTemp" value="controladorModelos">
<c:param name="instruccion" value="cargar"></c:param>
<c:param name="IdModelo" value="${tempMod.id}"></c:param>
</c:url>

<c:url var="linkTempEliminar" value="controladorModelos">
<c:param name="instruccion" value="eliminar"></c:param>
<c:param name="IdModeloEliminar" value="${tempMod.id}"></c:param>
</c:url>

<tr>
<td>${tempMod.id}</td>
<td>${tempMod.marca}</td>
<td>${tempMod.modelo}</td>
<td>${tempMod.motor}</td>
<td>${tempMod.potencia}</td>
<td>${tempMod.fecha}</td>
<td><a href="${linkTemp})">Modificar</a></td>
<td><a href="${linkTempEliminar})">Borrar</a></td>
</tr>

</c:forEach>

</table>


</body>
</html>