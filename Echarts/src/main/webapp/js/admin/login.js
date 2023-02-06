/**
 * 登录验证
 */
$(function () {
    //登陆验证的url
    let loginUrl = '/checkLogin';
    //登录失败次数
    let loginCount = 0;
    $('#submit').click(function () {
        //获取用户名
        let username = $('#username').val();
        //获取密码
        let password = $('#password').val();
        //获取验证码
        let captchaCode = $('#j_captcha').val();
        //是否验证
        let needVerify = false;
        //登录失败次数上限
        if (loginCount >= 1) {
            //输入验证码为空
            if (!captchaCode) {
                lightyear.notify('请输入验证码', 'danger', 1000,
                    'mdi mdi-emoticon-dead', 'top', 'center');
            }else {
                needVerify = true;
            }
        }
        //将用户输入的数据给后台做校验
        $.ajax({
            //请求路径
            url: loginUrl,
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
                needVerify: needVerify,
                verifyCodeActual: captchaCode
            }),
            //回调函数
            success: function (data) {
                console.log(data)
                if (data.success) {
                    //登录成功
                    lightyear.notify('登录成功~  欢迎' + data.username, 'success', 500,
                        'mdi mdi-emoticon-happy', 'top', 'center','/echarts1');
                } else {
                    //登录失败
                    if (data.errMsg!=="用户不存在"){
                        lightyear.notify(data.errMsg, 'danger', 1000,
                            'mdi mdi-emoticon-dead', 'top', 'center');
                        loginCount++;
                        //一次登录失败,再次登录填写验证码
                        if (loginCount >= 1) {
                            $('#verifyPart').show();
                        }
                        //刷新验证码
                        $('#captcha').click();
                    }else {
                        lightyear.notify(data.errMsg, 'danger', 1000,
                            'mdi mdi-emoticon-dead', 'top', 'center',"/regist");
                    }
                }
            }
        })
    })
})

/**
 * 验证码刷新
 * @param img
 * floor:取整数
 */
function changeVerifyCode(img) {
    img.src = "/kaptcha?" + Math.floor(Math.random() * 100);
}
