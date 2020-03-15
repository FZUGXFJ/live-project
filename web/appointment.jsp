<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="CSS/selectStyle.css"/>
    <title>Title</title>
</head>
<body>
<div id="wrap">
    <div id="BackImg"></div>
<form id="addstu" name="editstu" method="post" action="">
    <input type="hidden" name="id" id="id" value="<?php echo $stu['id'];?>"/>
    <table id="tableInfo">
        <tr>
            <td class="info" align="right">姓名:</td>
            <td><input id="name" name="name" type="text"/></td>

        </tr>
        <tr>
            <td class="info" align="right">身份证号:</td>
            <td>
                <input id="no" name="name" type="text"/>
            </td>
        </tr>
        <tr>
            <td class="info" align="right">手机号:</td>
            <td><input type="text" name="age" id="tel"/></td>
        </tr>
        <tr>
            <td class="info" align="right">预约口罩数量:</td>
            <td><input id="num" name="classid" type="text" list="numList"/></td>
            <datalist id="numList">
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </datalist>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input class="btn" type="submit" value="开始预约"/>&nbsp;&nbsp;
                <input class="btn" type="reset" value="重置"/>&nbsp;&nbsp;
                <input class="btn" type="submit" value="结束预约"/>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td class="info"><span>2020-03-15 10:00</span> 至 <span>2020-03-15 16:00</span></td>
        </tr>
        <tr>
            <td class="info" align="right">口罩总数:</td>
            <td><input type="text" name="age" id="sum"/></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;&nbsp;<input class="btn" type="submit" value="设置"/>
            </td>
        </tr>
    </table>

</form>
</div>


</body>
</html>