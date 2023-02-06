<header class="lyear-layout-header">

    <nav class="navbar navbar-default">
        <div class="topbar">

            <div class="topbar-left">
                <div class="lyear-aside-toggler">
                    <span class="lyear-toggler-bar"></span>
                    <span class="lyear-toggler-bar"></span>
                    <span class="lyear-toggler-bar"></span>
                </div>
                <span class="navbar-page-title">
                    <#-- 后台首页变化-->
                    <#if Session["pageName"]??>
                        ${Session["pageName"]}
                    </#if>
                </span>
            </div>

            <ul class="topbar-right">
                <li class="dropdown dropdown-profile">
                    <a href="javascript:void(0)" data-toggle="dropdown">
                        <img class="img-avatar img-avatar-48 m-r-10" src="/images/2.png" alt="笔下光年"/>
                        <span>
                            <#-- userInfo是否存在-->
                            <#if Session["userInfo"]??>
                                ${Session["userInfo"].username}
                            </#if>
                        <span class="caret"></span></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li><a href="/user/userInfo"><i class="mdi mdi-account"></i> 个人信息</a></li>
                        <li><a href="/user/userPassword"><i class="mdi mdi-lock-outline"></i> 修改密码</a>
                        </li>
                        <li><a id="logout" href="/logout"><i class="mdi mdi-logout-variant"></i> 退出登录</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/admin/logout.js"></script>