<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
<label for="name">名前</label><br />
<input type="text" name="name" value="${employee.name}"/>
<br/>
<br/>
<label for="name_ruby">名前</label><br />
<input type="text" name="name_ruby" value="${employee.name_ruby}"/><br/><br/>
    </body>
</html>