<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="CSS/selectStyle.css"/>
    <title>预约设置</title>
    <script>
        function exportlist(){
            window.location.href="servlet";
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
    %>
</head>
<body>
<div id="wrap" style="background-image:url('${basePath}/image/select.jpg');background-repeat: no-repeat;">
    <div id="BackImg"></div>
    <form id="addstu" name="editstu" method="post" action="">
        <input type="hidden" name="id" id="id" value="<?php echo $stu['id'];?>"/>
        <table id="tableInfo">
            <tr>
                <td class="info" align="right">开放时间:</td>
                <td><input id="Date1" name="beginDate" type="date"/></td>
                <td><input id="time1" name="beginTime" type="time"/></td>

            </tr>
            <tr>
                <td class="info" align="right">截止时间:</td>
                <td>
                    <input id="Date2" name="endDate" type="date"/>
                </td>
                <td><input id="time2" name="endTime" type="time"/></td>
            </tr>
            <tr>
                <td class="info" align="right">口罩总数:</td>
                <td><input type="text" name="maskNum" id="sum"/></td>
            </tr>
            <tr>
                <td class="info" align="right">最高可预约数量:</td>
                <td><input id="Maxnum" name="maxAppointment" type="text" list="numList" value="3"/></td>
                <datalist id="numList">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </datalist>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input class="btn" type="submit" value="设置"/>&nbsp;&nbsp;
                    <input class="btn" type="reset" value="重置"/>&nbsp;&nbsp;
                    <input class="btn" type="button" value="导出名单" onclick="exportlist()"/>
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>

    </form>
</div>

</body>
</html>