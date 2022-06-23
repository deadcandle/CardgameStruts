<!DOCTYPE html>
<html lang="en" style="font-family: Verdana, serif;">
<head>
    <meta charset="UTF-8">
    <title>HIBERNATE.xml</title>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "b" %>

</head>
<body style="text-align: center; width: 20%; min-width: 150px; margin: 20px auto">
<h1>user: user1</h1>
<%--    <img width="150px" src="https://deckofcardsapi.com/static/img/${currentCard.suit}.png">--%>
    <h1>${currentCard.name}</h1>
    <p>remaining cards: <kbd>${totalCards}</kbd></p>
    <p>points: <kbd>${score}</kbd></p>
    <s:form action="gameturn" method="POST">
        <button style="padding: 5px; margin: 5px;" type="submit" value="omhoog" name="higher">higher</button>
        <button style="padding: 5px; margin: 5px;" type="submit" value="omlaag" name="lower">lower</button>
    </s:form>
    <button style="padding: 5px 40px;" onclick="alert('next card is:  ${nextCard.name}')">hint</button>
    <br>

<b:forEach items="${rij}" var="value">
<b:out value="${value}"></b:out>
</b:forEach>
<%--<kbd>${rij}</kbd>--%>
</body>
</html>