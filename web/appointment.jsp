<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ page import="fzu.gxfj.pojo.AppointmentInfo" %>
<%@ page import="fzu.gxfj.pojo.Appointment" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="CSS/selectStyle.css"/>
    <title>用户预约</title>
    <script>
        function end() {
            window.location.href="servlet";
        }
        function getTime() {
            var myDate = new Date();
            var dateString = "";
            var year = myDate.getFullYear();
            var month = myDate.getMonth() + 1;
            if(month < 10)
                month = "0" + month;
            var date = myDate.getDate();
            var hour = myDate.getHours();
            var minutes = myDate.getMinutes();
            var seconds = myDate.getSeconds();
            dateString = dateString + year + "-" + month + "-" + date + " " + hour + ":" + minutes + ":" + seconds;
            document.getElementById("time").value=dateString;
        }
    </script>
    <%
        String path = request.getContextPath();
        String basePath=null;
        basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        int port=request.getServerPort();

        if(port==80){
            basePath=request.getScheme()+"://"+request.getServerName()+path;

        }else{
            basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

        }
        request.setAttribute("basePath", basePath);
        AppointmentInfo info = new AppointmentInfo();
        request.setAttribute("beginTime",info.getBeginTime());
        request.setAttribute("endTime",info.getEndTime());
    %>
</head>
<body>
<div id="wrap" style="background-image:url('${basePath}/image/select.jpg');background-repeat: no-repeat;">
    <div id="BackImg"></div>
<%--<form id="addstu" name="editstu" method="post" action="AppointmentServlet">--%>
    <input type="hidden" name="id" id="id" value="<?php echo $stu['id'];?>"/>
    <table id="tableInfo">
        <tr>
            <td class="info" align="right">姓名:</td>
            <td><input id="name" name="name" type="text" required="required"/></td>

        </tr>
        <tr>
            <td class="info" align="right">身份证号:</td>
            <td>
                <input id="no" name="id" type="number" required="required"/>
            </td>
        </tr>
        <tr>
            <td class="info" align="right">手机号:</td>
            <td><input type="number" name="phone" id="tel" required="required"/></td>
        </tr>
        <tr>
            <td class="info" align="right">预约口罩数量:</td>
            <td><input id="num" name="num" type="number" min="1" max="3" required="required"/></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input class="btn" type="submit" value="预约" onclick="getTime()"/>&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input id="time" name="dateTime" type="hidden" value=""/>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td class="info"><span><%=info.getBeginTime()%></span> 至 <span><%=info.getBeginTime()%></span></td>
        </tr>
        
    </table>
</form>
    <form method="post" action="StartAppointServlet">
        <table>
            <tr>
                <td class="info" align="right">口罩总数:</td>
                <td><input type="number" name="maskNum" id="sum" min="1" max="100"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input class="btn" type="submit" value="开始预约"></td>
            </tr>
        </table>
    </form>
    <br/>
    <form method="post" action="EndAppointServlet">
        <input class="btn" type="submit" value="结束预约">
    </form>
    <form action="" method="POST">
    </form>
</div>


</body>
</html>