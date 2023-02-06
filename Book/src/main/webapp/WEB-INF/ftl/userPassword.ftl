<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>修改密码 - 图书管理系统</title>
    <link rel="icon" href="/favicon.ico" type="image/ico">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="stylesheet">
    <!--标签插件-->
    <link rel="stylesheet" href="/js/jquery-tags-input/jquery.tagsinput.min.css">
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
                                    <div class="form-group col-md-12">
                                        <label for="oldPassword">旧密码</label>
                                        <input type="password" class="form-control" id="oldPassword" name="oldPassword" value="" />
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="newPassword">新密码</label>
                                        <input type="password" class="form-control" id="newPassword" name="newPassword" value="" />
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="rePassword">确认密码</label>
                                        <input type="password" class="form-control" id="rePassword" name="rePassword" value="" />
                                    </div>
                                    <div class="form-group col-md-12">
                                        <button id="submit" class="btn btn-primary" >确 定</button>
                                        <button type="button" class="btn btn-primary" onclick="javascript:history.back(-1);return false;">返 回</button>
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
<script src="/js/jquery-tags-input/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="/js/main.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="/js/lightyear.js"></script>
<script type="text/javascript" src="/js/admin/user.js"></script>
</body>
</html>