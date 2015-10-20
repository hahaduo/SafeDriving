<%--  Created by IntelliJ IDEA.  User: lihongjun  Date: 15/9/28  Time: 下午3:01  To change this template use File | Settings | File Templates.--%><%@ page contentType="text/html; charset=UTF-8" language="java" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@include file="../../../common/Head.jsp" %><!DOCTYPE html><html><head>    <meta charset="utf-8">    <meta http-equiv="X-UA-Compatible" content="IE=edge">    <meta name="viewport" content="width=device-width, initial-scale=1">    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->    <meta name="description" content="">    <meta name="author" content="">    <link rel="icon" href="http://v3.bootcss.com/favicon.ico">    <title>登录</title>    <!-- Bootstrap core CSS -->    <link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">    <link rel="stylesheet" href="${serverPath}/static/css/bootstrapValidator.min.css"/>    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>    <script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>    <script type="text/javascript" src="${serverPath}/static/js/bootstrapValidator.min.js"></script></head><body><div class="container">    <div class="row">        <section>            <div class="col-lg-8 col-lg-offset-2">                <form id="inputForm" class="form-horizontal" method="post" action="login">                    <div class="page-header">                        <h2>请填写登录信息</h2>                    </div>                    <div class="form-group">                        <label class="col-lg-4 control-label"></label>                        <div class="col-lg-4">                            <span class="text-danger">${msg}</span>                        </div>                    </div>                    <%--<small class="help-block" data-bv-validator="notEmpty" data-bv-for="email" data-bv-result="INVALID" style="">请输入电子邮箱地址</small>--%>                    <div class="form-group">                        <label for="inputEmail" class="col-lg-4 control-label">电子邮箱地址</label>                        <div class="col-lg-4">                            <input id="inputEmail" type="text" class="form-control" name="email" placeholder="电子邮箱地址"                                   value="${email}"/>                        </div>                    </div>                    <div class="form-group">                        <label class="col-lg-4 control-label">密码</label>                        <div class="col-lg-4">                            <input type="password" class="form-control" name="password" placeholder="密码"/>                        </div>                    </div>                    <div class="form-group">                        <label class="col-lg-4 control-label"></label>                        <div class="col-lg-4">                            <div class="checkbox">                                <label>                                    <input type="checkbox" name="languages[]" value="english"/> 记住密码                                </label>                            </div>                        </div>                    </div>                    <div class="form-group">                        <label class="col-lg-4 control-label"></label>                        <div class="col-lg-6">                            <button type="submit" class="btn btn-primary" name="signup" value="Sign up">登入</button>                            <button type="button" class="btn btn-primary" id="resetBtn">重置</button>                        </div>                    </div>                </form>            </div>        </section>    </div></div><!-- /container --><!-- IE10 viewport hack for Surface/desktop Windows 8 bug --><script src="http://v3.bootcss.com/assets/js/ie10-viewport-bug-workaround.js"></script><script type="text/javascript">    $(document).ready(function () {        function randomNumber(min, max) {            return Math.floor(Math.random() * (max - min + 1) + min);        };        $('#inputForm').bootstrapValidator({//        live: 'disabled',            message: 'This value is not valid',            feedbackIcons: {                valid: 'glyphicon glyphicon-ok',                invalid: 'glyphicon glyphicon-remove',                validating: 'glyphicon glyphicon-refresh'            },            fields: {                email: {                    validators: {                        notEmpty: {                            message: '请输入电子邮箱地址'                        },                        emailAddress: {                            message: '请输入有效的电子邮箱地址'                        }                    }                },                password: {                    validators: {                        notEmpty: {                            message: '请输入密码'                        }                    }                }            }        });        $('#resetBtn').click(function () {            $('#inputForm').data('bootstrapValidator').resetForm(true);        });    });</script></body></html>