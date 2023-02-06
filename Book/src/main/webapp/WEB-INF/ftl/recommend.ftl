<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>推荐 - 图书管理系统</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/css/style.min.css" rel="stylesheet">
    <link href="/css/pagination.css" rel="stylesheet">
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
                            <div class="card-toolbar clearfix">
                                <div class="pull-right search-bar">
                                    <div class="input-group">
<#--                                        <div class="input-group-btn">-->
<#--                                            <input type="hidden" name="search_field" id="search-field" value="name">-->
<#--                                            <button class="btn btn-default dropdown-toggle" id="search-btn"-->
<#--                                                    data-toggle="dropdown" type="button" aria-haspopup="true"-->
<#--                                                    aria-expanded="false">-->
<#--                                                书名 <span class="caret"></span>-->
<#--                                            </button>-->
<#--                                            <ul class="dropdown-menu">-->
<#--                                                <li><a tabindex="-1" href="javascript:void(0)" data-field="name">书名</a>-->
<#--                                                </li>-->
<#--                                                <li><a tabindex="-1" href="javascript:void(0)"-->
<#--                                                       data-field="publish">出版社</a></li>-->
<#--                                            </ul>-->
<#--                                        </div>-->
<#--                                        <input id="search-input" type="text" class="form-control" value=""-->
<#--                                               name="keyword"-->
<#--                                               placeholder="请输入关键字">-->
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">

                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>序号</th>
                                            <th>书名</th>
                                            <th>评分</th>
                                            <th>价格</th>
                                            <th>出版社</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody class="book-wrap">
                                        </tbody>
                                    </table>
                                </div>
                                <ul id="jq-page" class="m-style">
                                </ul>
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
<script type="text/javascript" src="/js/main.min.js"></script>
<#--消息通知-->
<script type="text/javascript" src="/js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="/js/lightyear.js"></script>
<script type="text/javascript" src="/js/jquery.pagination.js"></script>
<script type="text/javascript" src="/js/admin/common.js"></script>
<script type="text/javascript" src="/js/admin/recommend.js"></script>
<script type="text/javascript" src="/js/admin/logout.js"></script>
</body>
</html>