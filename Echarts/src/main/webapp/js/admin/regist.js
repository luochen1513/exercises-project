/**
 * 注册验证
 */
$(function () {
    //注册验证的url
    let registUrl = '/checkRegist';
    $('#submit').click(function () {
        //获取用户名
        let username = $('#username').val();
        //获取密码
        let password = $('#password').val();
        //将用户输入的数据给后台做校验
        $.ajax({
            //请求路径
            url: registUrl,
            //http的方法
            type: 'post',
            //同步
            async: false,
            //缓存
            cache: false,
            //接收的数据类型
            datatype: 'json',
            //发送的数据类型
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify({
                username: username,
                password: password,
            }),
            //回调函数
            success: function (data) {
                if (data.success) {
                    //注册成功
                    lightyear.notify('注册成功~  欢迎' + data.username, 'success', 500,
                        'mdi mdi-emoticon-happy', 'top', 'center','/login');
                } else {
                    //注册失败
                    lightyear.notify(data.errMsg, 'danger', 1000,
                        'mdi mdi-emoticon-dead', 'top', 'center');
                }
            }
        })
    })
})