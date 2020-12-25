<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h1>akanes-apprications</h1>
        <c:if test="${flush != null }">
            <h2><c:out value="${flush}"/></h2>
        </c:if>
        <div class="main_container">
            <div class="main_item">
                <a href="#"><img src="./images/top_battle.png"></img></a>
            </div>
            <div class="main_item">
                <a href="#"><img src="./images/top_dice.png"></img></a>
            </div>
            <div class="main_item">
                <a href="#"><img src="./images/top_sheet.png"></img></a>
            </div>
        </div>
        <button type="button" onclick="show_login()">ログイン</button>
        <button type="button" onclick="show_signup()">新規登録</button>

<%-- サインアップフォーム --%>

        <form method="POST" name="signup_form" action="<c:url value="/login" />">
            <div id="show_signup">
                <label for="input_name">表示名</label><br />
                    <input type="text"id="input_name" name="name" />
                <br />
                <br />
                <label for="input_mail">メールアドレス</label><br />
                    <input type="text"id="input_mail" name="mail" />
                <br />
                <br />
                <label for="password">パスワード</label><br />
                    <input type="password"id="input_password" name="password" /> <br /> <br />
                <label for="password">パスワードの再入力</label><br />
                    <input type="password" id="re_password" name="re_password" /> <br /> <br />
                <button type="submit" onclick="return check()">登録</button>
                <br/>
                <a href="#">利用規約</a>
                <a href="#">プライバシーポリシー</a>
            </div>
        </form>

<%-- ここからログインフォーム --%>

        <form method="POST" name="signin_form" action="<c:url value="/user/login" />">
            <div id="show_signin">
                <label for="input_mail">メールアドレス</label><br />
                <input type="text"id="input_mail" name="mail" />
                <br />
                <br />
                <label for="password">パスワード</label><br />
                <input type="password"id="input_password" name="password" /> <br /> <br />
                <button type="submit" onclick="return check()">登録</button>
                <br/>
                <a href="#">利用規約</a>
                <a href="#">プライバシーポリシー</a>
            </div>
        </form>
    </c:param>
</c:import>