<!DOCTYPE html>
<html lang="en" style="font-family: Verdana, serif">
<head>
    <meta charset="UTF-8">
    <title>Game over | Cardgame</title>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body style="color: white; background-color: black;" >
<h1>game Over</h1>
<p>Your score was <kbd>${score/n}</kbd></p>
<a href="cardgame" style="color: orange;">Return to Home</a><br><br><br>
</body>
</html>