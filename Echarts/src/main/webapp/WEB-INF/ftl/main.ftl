<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>首页 - Echarts后台管理</title>
    <link rel="icon" href="/favicon.ico" type="image/ico">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/css/style.min.css" rel="stylesheet">
    <link href="/css/admin.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <#-- freemarker语法-->
        <#include "side.ftl"/>
        <!--End 左侧导航-->

        <!--头部信息-->
        <#include "top.ftl"/>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="echarts-padding">
                <iframe class="echarts" src="https://echarts.apache.org/handbook/zh/get-started/"></iframe>

            </div>

        </main>
        <!--End 页面主要内容-->

    </div>
</div>

<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/js/main.min.js"></script>

</body>
</html>