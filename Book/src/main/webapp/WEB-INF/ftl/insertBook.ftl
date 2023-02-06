<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>添加图书 - 图书管理系统</title>
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
                                        <label for="book-name">书名</label>
                                        <input type="text" class="form-control" id="book-name" name="book-name" value=""
                                               placeholder="请输入书名"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="book-score">评分</label>
                                        <input type="text" class="form-control" id="book-score" name="book-score"
                                               value="" placeholder="请输入评分"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="book-price">价格</label>
                                        <input type="text" class="form-control" id="book-price" name="book-price"
                                               value="" placeholder="请输入价格"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="book-publish">出版社</label>
                                        <input type="text" class="form-control" id="book-publish" name="book-publish"
                                               value="" placeholder="请输入出版社"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="book-url">网址</label>
                                        <input type="text" class="form-control" id="book-url" name="book-url"
                                               value="" placeholder="请输入网址"/>
                                    </div>
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
<script type="text/javascript" src="/js/admin/book-list.js"></script>
</body>
</html>