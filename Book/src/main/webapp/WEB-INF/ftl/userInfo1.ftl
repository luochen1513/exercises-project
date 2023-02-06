<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>修改个人信息 - 图书管理系统</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="s
    tylesheet">
    <!--标签插件-->
    <#--    <link rel="stylesheet" href="/js/jquery-tags-input/jquery.tagsinput.min.css">-->
    <link href="/css/style.min.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <#include "side.ftl"/>
        <!--End 左侧导航-->

        <!--头部信息-->
        <#include "top.ftl"/>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">

                                <div class="row">
                                    <div class="form-group col-md-12" style="display: none">
                                        <label for="userId">用户id</label>
                                        <input type="text" class="form-control" id="userId" name="userId" value=""
                                               placeholder="请输入用户id"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="username">用户名</label>
                                        <input type="text" class="form-control" id="username" name="username" value=""
                                               placeholder="请输入用户名"/>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12" for="sex">性别</label>
                                        <div class="col-md-12">
                                            <select class="form-control" id="sex" name="sex" size="1">
                                                <option value="0">请选择</option>
                                                <option value="男">男</option>
                                                <option value="女">女</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12" style="margin-top: 18px;">
                                        <label for="email">邮箱</label>
                                        <input type="text" class="form-control" id="email" name="email" value="" placeholder="请输入邮箱"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="phone">手机号</label>
                                        <input type="text" class="form-control" id="phone" name="phone" value="" placeholder="请输入手机号"/>
                                    </div>
                                    <div class="submit-bianji">
                                        <div class="form-group col-md-12">
                                            <button class="btn btn-primary submit">确 定</button>
                                            <button type="button" class="btn btn-primary quxiao">取 消</button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/perfect-scrollbar.min.js"></script>
<!--标签插件-->
<#--<script src="/js/jquery-tags-input/jquery.tagsinput.min.js"></script>-->
<#--消息通知-->
<script type="text/javascript" src="/js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="/js/lightyear.js"></script>
<script type="text/javascript" src="/js/main.min.js"></script>
<script type="text/javascript" src="/js/admin/common.js"></script>
<script type="text/javascript" src="/js/admin/user.js"></script>
<script type="text/javascript" src="/js/admin/logout.js"></script>
</body>
</html>