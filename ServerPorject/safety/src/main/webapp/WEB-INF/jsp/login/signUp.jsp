<%--  Created by IntelliJ IDEA.  User: lihongjun  Date: 15/9/28  Time: 下午3:01  To change this template use File | Settings | File Templates.--%><%@ page contentType="text/html; charset=UTF-8" language="java" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@include file="../../../common/Head.jsp" %><!DOCTYPE html><html><head>  <meta charset="utf-8">  <meta http-equiv="X-UA-Compatible" content="IE=edge">  <meta name="viewport" content="width=device-width, initial-scale=1">  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->  <meta name="description" content="">  <meta name="author" content="">  <link rel="icon" href="http://v3.bootcss.com/favicon.ico">  <title>注册</title>  <!-- Bootstrap core CSS -->  <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">  <!-- Custom styles for this template -->  <link href="http://v3.bootcss.com/examples/signin/signin.css" rel="stylesheet">  <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->  <!--[if lt IE 9]><script src="http://v3.bootcss.com/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->  <script src="http://v3.bootcss.com/assets/js/ie-emulation-modes-warning.js"></script>  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->  <!--[if lt IE 9]>  <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>  <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>  <![endif]--></head><body><div class="container">  <form class="form-signin" method="post" action="saveUser">    <h2 class="form-signin-heading">Please sign in</h2>    <label for="inputEmail" class="sr-only">请输入电子邮箱地址</label>    <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>    <label for="inputPassword" class="sr-only">6-18位密码，区分大小写，不能用空格</label>    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>    <div class="checkbox">      <label>        <input type="checkbox" value="remember-me"> Remember me      </label>    </div>    <button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>  </form></div> <!-- /container --><!-- IE10 viewport hack for Surface/desktop Windows 8 bug --><script src="http://v3.bootcss.com/assets/js/ie10-viewport-bug-workaround.js"></script></body></html>