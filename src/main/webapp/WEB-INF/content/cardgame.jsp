<!DOCTYPE html>
<html lang="en" style="font-family: Verdana, serif">
<head>
    <meta charset="UTF-8">
    <title>Select a option | Cardgame</title>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body style="text-align: center">
    <h1>Huidige card: <kbd>${currentCard}</kbd></h1>
    <p>Totaal kaarten over: <kbd>${totalCards}</kbd></p>
    <p>Huidige score: <kbd>${score}</kbd></p>
<%--    <p>(Next card: <kbd>${nextCard}</kbd>)</p>--%>
    <s:form action="gameturn" method="POST">
        <button type="submit" value="omhoog" name="higher">higher</button>
        <button type="submit" value="omlaag" name="lower">lower</button>
    </s:form>
    <br>
</body>
</html>