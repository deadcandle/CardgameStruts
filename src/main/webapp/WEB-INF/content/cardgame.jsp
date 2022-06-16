<!DOCTYPE html>
<html lang="en" style="background-color:white;">
<head>
    <meta charset="UTF-8">
    <title>Calculator | Struts2Calculator</title>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
    <h1>Huidige Kaart: <kbd>${currentCard}</kbd></h1>
    <h1>Volgende Kaart: <kbd>${nextCard}</kbd></h1>
    <h3>Score: <kbd>${score}</kbd></h3>
    <s:form action="cardgame" method="post">
        <s:textfield name="choice"></s:textfield>
        <s:submit value="formulier indienen"></s:submit>
    </s:form>
    <c:if test="true">rng is true</c:if>
</body>
</html>