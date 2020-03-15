<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ page import="fzu.gxfj.pojo.Appointment" %>
<%@ page import="fzu.gxfj.service.Generator" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>查询</title>

    <link href="CSS/selectStyle.css" rel="stylesheet" type="text/css" charset="UTF-8">
</head>
<body>
    <div id="wrap">
        <div id="main">
            <br/><br/><br/>
            <form id="selectid" action="SelectServlet" method="post">
                <fieldset>
                <legend>查询摇号信息</legend>
                编码:<input type="text" name="number"><br/><br/><br/>
                <input type="submit" value="查询">
                </fieldset>
            </form>
            <p>结果:</p>
            <table border="1px">
                <tr><th>姓名</th><th>身份证号</th><th>电话号</th><th>购买数量</th><th>是否中奖</th><th>购买凭证</th></tr>
                <%
                    Appointment appointment;
                    if (request.getAttribute("appointment") != null) {
                        appointment = (Appointment) request.getAttribute("appointment");
                %>
                <tr>
                    <td><%=appointment.getUserName()%></td>
                    <td><%=appointment.getUserId()%></td>
                    <td><%=appointment.getUserPhone()%></td>
                    <td><%=appointment.getAppointmentNum()%></td>
                    <td><%=appointment.isWin()?"中签":"未中"%></td>
                    <td><%=appointment.isWin()?new Generator().generatePurchaseVoucher(appointment):"未中，无购买凭证"%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </div>
</body>
</html>