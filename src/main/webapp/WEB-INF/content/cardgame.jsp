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
    <img width="250px" src="https://deckofcardsapi.com/static/img/${currentCard.suit}.png">
    <h1>Current card: <kbd>${currentCard.name}</kbd></h1>
    <p>Total cards left: <kbd>${totalCards}</kbd></p>
    <p>Current score: <kbd>${score}</kbd></p>
    <p style="color: white;">Next card: ${nextCard.name}</p>
    <s:form action="gameturn" method="POST">
        <button style="padding: 5px; margin: 5px;" type="submit" value="omhoog" name="higher">higher</button>
        <button style="padding: 5px; margin: 5px;" type="submit" value="omlaag" name="lower">lower</button>
    </s:form>
    <br>
</body>
</html>