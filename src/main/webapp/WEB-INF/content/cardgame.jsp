<!DOCTYPE html>
<html lang="en" style="background-color:white;">
<head>
    <meta charset="UTF-8">
    <title>Calculator | Struts2Calculator</title>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
</head>
<body>
    <h1>Kaart: <kbd>${beginKaart}</kbd></h1>
    <s:form action="calculator" method="post">
        <s:submit name="higher" value="hoger"></s:submit>
    </s:form>
    <s:form action="calculator" method="post">
        <s:submit name="lower" value="lager"></s:submit>
    </s:form>
</body>
</html>