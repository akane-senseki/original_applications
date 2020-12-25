<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <div class="header_container">
                <div class="header_item">
                    <p>akanes-apprications</p>
                </div>
                <div class="header_item">
                    <ul>
                        <li><a href="#">HOME</a></li>
                        <li><a href="#">Demo Battle</a></li>
                        <li><a href="#">Pc Dice</a></li>
                        <li><a href="#">Character Sheets</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <div class="main">
            <div id="main">
                <div class="wrapper">${param.content}</div>
            </div>
            <footer> (c)2020- by 9966 </footer>
        </div>
</body>
</html>