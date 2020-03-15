<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员登录</title>
    <link href="CSS/indexStyle.css" rel="stylesheet">
</head>
<body>
    <div id="wrap">
        <div id="login">
            <form id="loginform" action="adminServlet" method="POST">
                <fieldset>
                    <legend>管理员登录</legend></br></br>
                    账号:<input type="text"></br></br>
                    密码:<input type="password"></br></br>
                    <input type="submit" value="登录">
                </fieldset>
            </form>
        </div>
    </div>
</body>
</html>