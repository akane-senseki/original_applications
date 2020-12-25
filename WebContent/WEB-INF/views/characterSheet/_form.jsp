<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label for="name">名前</label>
<br />
<input type="text" name="name" id="name" value="${pc_entity.name}" />
<br />
<br />
<label for="name_ruby">ふりがな</label>
<br />
<input type="text" name="name_ruby" id="name_ruby"
    value="${pc_entity.name_ruby}" />
<br />
<br />
<p>能力値</p>
<table>
    <tbody>
        <tr>
            <th><label for="str">STR</label></th>
            <th><label for="con">CON</label></th>
            <th><label for="dex">DEX</label></th>
            <th><label for="siz">SIZ</label></th>
            <th>HP</th>
            <th>DB</th>
        </tr>
        <tr>
            <td><input type="number" name="str" id="str" class="input_min"
                onkeyup="show()" value="${pc_entity.str}" /></td>
            <td><input type="number" name="con" id="con" class="input_min"
                onkeyup="show()" value="${pc_entity.con}" /></td>
            <td><input type="number" name="dex" id="dex" class="input_min"
                value="${pc_entity.dex}" /></td>
            <td><input type="number" name="siz" id="siz" class="input_min"
                onkeyup="show()" value="${pc_entity.siz}" /></td>
            <td id="hp">--</td>
            <td id="db">--</td>
        </tr>
    </tbody>
</table>
<script>
    function show() {
        var str_data = document.getElementById("str").value;
        var con_data = document.getElementById("con").value;
        var siz_data = document.getElementById("siz").value;
        var dex_data = document.getElementById("dex").value;
        document.getElementById("hp").innerHTML = Math.round((parseInt(con_data) + parseInt(siz_data)) / 2);
        document.getElementById("dex_2").innerHTML = parseInt(dex_data) * 2;
        document.getElementById("avoidance").innerHTML = parseInt(dex_data) * 2
                + parseInt(document.getElementById("avoidance_add").value);

        var db_text;
        var db_num = parseInt(str_data) + parseInt(siz_data);

        if (db_num > 2 && db_num < 13) {
            db_text = "-1d4";
        } else if (db_num < 25) {
            db_text = "0";
        } else if (db_num < 33) {
            db_text = "+1d4";
        } else if (db_num < 41) {
            db_text = "+1d6";
        } else if (db_num < 57) {
            db_text = "+2d6";
        } else {
            db_text = "未設定";
        }
        document.getElementById("db").innerHTML = db_text;
    }
</script>
<br />
<br />
<p>技能値</p>
<table>
    <tbody>
        <tr>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <th>初期値</th>
            <th>振分け</th>
            <th>合計</th>
        </tr>
        <tr>
            <th>回避</th>
            <td id="dex_2"></td>
            <td><input type="number" name="avoidance_add" id="avoidance_add"
                class="input_min" onkeyup="show()"
                value="${pc_entity.avoidance_add}" /></td>
            <td id="avoidance"></td>
        </tr>
        <tr>
            <th>キック</th>
            <td>25</td>
            <td><input type="number" name="kick_add" id="kick_add"
                class="input_min" onkeyup="show_kick()" value="${pc_entity.kick}" /></td>
            <td id="kick"></td>
        </tr>
        <tr>
            <th>こぶし</th>
            <td>50</td>
            <td><input type="number" name="fist_add" id="fist_add"
                class="input_min" onkeyup="show_fist()" value="${pc_entity.fist}" /></td>
            <td id="fist"></td>
        </tr>
        <tr>
            <th>頭突き</th>
            <td>10</td>
            <td><input type="number" name="headbutt_add" id="headbutt_add"
                class="input_min" onkeyup="show_headbutt()"
                value="${pc_entity.headbutt}" /></td>
            <td id="headbutt"></td>
        </tr>
    </tbody>
</table>
<script>
    function show_kick() {
        var kick_data = document.getElementById("kick_add").value;
        document.getElementById("kick").innerHTML = parseInt(kick_data) + 25;
    }
    function show_fist() {
        var fist_data = document.getElementById("fist_add").value;
        document.getElementById("fist").innerHTML = parseInt(fist_data) + 25;
    }
    function show_headbutt() {
        var headbutt_data = document.getElementById("headbutt_add").value;
        document.getElementById("headbutt").innerHTML = parseInt(headbutt_data) + 25;
    }
</script>
<br />
<br />
<input type="hidden" name="_token" value="${_token}"/>
<button type="submit" onclick="return check()">作成</button>
<br/>
<br/>