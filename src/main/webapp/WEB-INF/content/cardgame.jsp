<!DOCTYPE html>
<html lang="en" style="font-family: Verdana, serif;">
<head>
    <meta charset="UTF-8">
    <title>Select a option | Cardgame</title>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="text-align: center; width: 20%; min-width: 150px; margin: 20px auto">
    <img width="150px" src="https://deckofcardsapi.com/static/img/${currentCard.suit}.png">
    <h1>${currentCard.name}</h1>
    <p>resterende kaarten: <kbd>${totalCards}</kbd></p>
    <p>totale punten: <kbd>${score}</kbd></p>
    <s:form action="gameturn" method="POST">
        <button style="padding: 5px; margin: 5px;" type="submit" value="omhoog" name="higher">higher</button>
        <button style="padding: 5px; margin: 5px;" type="submit" value="omlaag" name="lower">lower</button>
    </s:form>
    <button style="padding: 5px; margin: 5px;" onclick="alert('De volgende kaart is ${nextCard.name}')">ik heb hulp nodig</button>
    <br>
</body>
</html>