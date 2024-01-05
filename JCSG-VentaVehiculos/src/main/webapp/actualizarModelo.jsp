<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
    function formatearFecha() {
      var inputFecha = document.getElementById('fechaRegistro');
      var fechaOriginal = inputFecha.value;
      
      // Parsea la fecha en formato "dia-mes-año" (por ejemplo, "23-12-2023")
      var partes = fechaOriginal.split('-');
      var fechaFormateada = partes[2] + '-' + partes[1] + '-' + partes[0];
      
      // Establece la fecha formateada de vuelta en el input
      inputFecha.value = fechaFormateada;
    }
  </script>
</head>
<body>
<h1>Actualizar Registro</h1>
<form name="formulario" action="controladorModelos" method="get" id="formulario">
<input type="hidden" name="instruccion" value="ActualizarBBDD">

<input type="hidden" name="id" value="${codigoId.id}">

    <label for="marca">Marca:</label>
    <input type="text" id="marca" name="marca" value="${codigoId.marca}" required>

    <label for="modelo">Modelo:</label>
    <input type="text" id="modelo" name="modelo" value="${codigoId.modelo}" required>

    <label for="motor">Motor:</label>
    <input type="text" id="motor" name="motor" value="${codigoId.motor}" required>

    <label for="potencia">Potencia:</label>
    <input type="number" id="potencia" name="potencia" value="${codigoId.potencia}" required>

    <label for="fechaRegistro">Fecha de Registro:</label>
    <input type="date" id="fechaRegistro" name="fechaRegistro"value="${codigoId.fecha}" required>

    <button type="submit" name="envio">Enviar</button>
    <button type="reset" name="borrar">Restablecer</button>

  </form>
</body>
</html>