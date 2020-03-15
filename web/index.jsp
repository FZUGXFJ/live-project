<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>口罩预约系统</title>
    <link href="CSS/indexStyle.css" rel="stylesheet" type="text/css" charset="UTF-8">

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function yy(){
            window.location.href="indexServlet?action=预约";
        }
        function cx(){
            window.location.href="indexServlet?action=查询";
        }
        function dl(){
            window.location.href="indexServlet?action=管理员登录";
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
    <div id="wrap" style="background-image:url('${basePath}/image/index.jpg');">
    </br></br></br>
    </br></br></br>
       <div id="main1">
        <button type="button" class="btn btn-primary btn-lg" onclick="yy()">预约</button>
        <button type="button" class="btn btn-primary btn-lg" onclick="cx()">查询</button></br></br></br>
        <button type="button" class="btn btn-primary btn-lg" onclick="dl()">管理员登录</button>
       </div>
    </div>
</body>
</html>