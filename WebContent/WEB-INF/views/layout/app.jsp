<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    </head>
    <body>
    <div id="wrapper">
        <header>

        </header>
        <div id="main">
            ${param.content}
        </div>
        <footer>
            (c)2020- by 9966
        </footer>
    </div>
    </body>
</html>