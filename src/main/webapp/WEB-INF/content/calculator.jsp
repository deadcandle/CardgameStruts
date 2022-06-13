<!DOCTYPE html>
<html lang="en" style="background-color:#1b1b1b;">
<head>
    <meta charset="UTF-8">
    <title>Calculator | Struts2Calculator</title>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
</head>
<body>
<div style="width: min-content; margin: auto; padding:15px; background-color: white">
    <h2 style="font-family: Arial">Calculator.json</h2>
    <i>Opties: <kbd style="background-color: rgb(25,25,25); color: white; padding: 0px 5px">0-9, + - * / ^</kbd></i>
    <s:form action="calculator" method="post">
        <s:textfield required="true" name="number1" label="getal 1"></s:textfield>
        <s:textfield required="true" name="operator" label="operator"></s:textfield>
        <s:textfield required="true" name="number2" label="getal 2"></s:textfield>
        <s:submit style="border: none;" value="verstuur persoonlijke gegevens naar china"></s:submit>
    </s:form>
    <hr>
    Resultaat: <kbd>${result}</kbd>
</div>
</body>
</html>