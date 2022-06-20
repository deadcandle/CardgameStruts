<!DOCTYPE html>
<html lang="en" style="font-family: Verdana, serif">
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
<body style="background-color: black; color: white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>Current card: <kbd>${currentCard}</kbd></h1>
                <p>Total cards left: <kbd>${totalCards}</kbd></p>
                <p>Current score: <kbd>${score}</kbd></p>
                <s:form action="gameturn" method="POST">
                    <button type="submit" value="omhoog" name="higher">higher</button>
                    <button type="submit" value="omlaag" name="lower">lower</button>
                </s:form>
                <br>
            </div>
            <div class="col-md-6">
                <kbd>${rij}</kbd>
            </div>
        </div>
    </div>
</body>
</html>