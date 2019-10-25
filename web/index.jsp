<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>首页</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            font-family: "monospace";
        }

        .header {
            height: 72px;
            background: #458fce;
        }

        .header .logo {
            color: #fff;
            line-height: 100px;
            font-size: 20px;
            margin-left: 30px;
            display: inline-block;
            text-align: center;

        }

        a {
            margin-left: 30px;
            margin-top: 30px;
            width: 200px;
            height: 80px;
            color: #fff;
            text-align: center;
            background: #458fce;
        }

        .header .login {
            float: right;
            color: #fff;
            line-height: 72px;
            margin-right: 2px;
            display: inline-block;
        }

        .banner {
            height: 380px;
            overflow: hidden;
            background: #ddd;
        }
    </style>
</head>
<body lang="zh-CN" class="reader-black-font">

<div class="header">
    <div class="logo">Web推荐测试</div>
</div>

<br/>
<br/>
<hr width="100%" color="grey" size="2" style="margin-top: 20px">
<div style="font-size:20px;font-weight:bold;">&nbsp;&nbsp;</div>
<div style="margin-top:10px;margin-left: 60px">
    <form action="action" method="post">
    <b>推荐用户账号：<b>
        <input id="userid" name="userid" type="text" style="width:120px;margin-right: 10px" ;="" value="3">&nbsp;
        推荐名片数量:<input name="number" type="text" style="width:120px;margin-left: 10px" ;="" value="10">&nbsp;
        <input type="submit"
               style="cursor:pointer;width:50px;height:25px;border:1px solid #6DB000;border-radius:5px;background-color:#6DB000;color:#FFFFFF;"
               value="确定">
    </b>
    </b>
    </form>
</div>

<hr width="100%" color="grey" size="2" style="margin-top: 30px">
</body>
</html>