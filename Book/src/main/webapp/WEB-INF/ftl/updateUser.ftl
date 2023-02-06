<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>修改用户 - 图书管理系统</title>
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
        <#include "sideRoot.ftl"/>
        <!--End 左侧导航-->

        <!--头部信息-->
        <#include "topRoot.ftl"/>
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
                                        <label for="username">用户名</label>
                                        <input type="text" class="form-control" id="username" name="username" value=""
                                               placeholder="请输入用户名"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="password">密码</label>
                                        <button style="text-align: left" type="button" class="form-control" id="password" name="password" value=""
                                                title="重置" >重置</button>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12" for="sex">性别</label>
                                        <div class="col-md-12">
                                            <select class="form-control" id="sex" name="sex" size="1" >
                                                <option value="0">请选择</option>
                                                <option value="男">男</option>
                                                <option value="女">女</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12" style="margin-top: 18px;">
                                        <label for="email">邮箱</label>
                                        <input type="text" class="form-control"  id="email" name="email" value="" placeholder="请输入邮箱"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="phone">手机号</label>
                                        <input type="text" class="form-control"  id="phone" name="phone" value="" placeholder="请输入手机号"/>
                                    </div>
                                    <div class="submit-bianji">
                                        <div class="form-group col-md-12">
                                            <button id="submit" class="btn btn-primary">确 定</button>
                                            <button type="button" class="btn btn-primary"
                                                    onclick="javascript:history.back(-1);return false;">返 回
                                            </button>
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
<script type="text/javascript" src="/js/jquery.pagination.js"></script>
<script type="text/javascript" src="/js/admin/common.js"></script>
<script type="text/javascript" src="/js/admin/user-list.js"></script>
</body>
</html>