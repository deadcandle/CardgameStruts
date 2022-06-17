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
    <h1>Current card: <kbd>${currentCard}</kbd></h1>
    <h1>Next card: <kbd>${nextCard}</kbd></h1>
    <s:form action="cardgame" method="POST">
        <button type="submit" value="omhoog" name="higher">higher</button>
        <button type="submit" value="omlaag" name="lower">lower</button>
    </s:form>
    <c:if test="true">rng is true</c:if>
</body>
</html>