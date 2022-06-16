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
    <s:set var="salary" scope="session" value="${2000*2}"/>
    <h1>Kaart: <kbd>${currentCard}</kbd></h1>
    <s:form action="cardgameChooseHigher" method="post">
        <s:submit name="higher" value="hoger"></s:submit>
    </s:form>
    <s:form action="cardgameChooseLower" method="post">
        <s:submit name="lower" value="lager"></s:submit>
    </s:form>
    <c:if test="true">rng is true</c:if>
</body>
</html>