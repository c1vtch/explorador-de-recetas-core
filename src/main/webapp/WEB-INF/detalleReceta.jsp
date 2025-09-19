<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Recetas</title>
</head>
<body>
    <h1>
        <c:if test="${!recetaEncontrada}">
            La receta no se encuentra en nuestra lista
        </c:if>
            
        ${nombreReceta}
    </h1>
    <ul>
        <c:forEach var="ingrediente" items="${ingredientes}">
            <c:choose>
                <c:when test="${recetaEncontrada}">
                    <li class="ingrediente">${ingrediente}</li>
                </c:when>
            </c:choose>
        </c:forEach>
    </ul>
</body>
</html>