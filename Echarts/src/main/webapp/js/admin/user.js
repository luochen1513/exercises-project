$(function () {
    //查询用户
    let queryUserUrl='/user/queryUser'
    //修改用户
    let editPasswordUrl='/user/editPassword'

    $.post(queryUserUrl, function (data) {
        if (data.success) {
            let user = data.data
            $('#username').val(user.username)
            $('#password').val(user.password)
        }
    })

    $('#submit').click(function () {
        /**
         * 获取名称,地址,状态
         * 关闭contentType后,需要将processData一同关闭
         * processData:表示会不会序列化data里面的数据
         */
        // let password = {}
        // password.oldPassword=$('oldPassword').val()
        // password.newPassword=$('newPassword').val()
        // password.rePassword=$('rePassword').val()
        let oldPassword=$('#oldPassword').val()
        let newPassword=$('#newPassword').val()
        let rePassword=$('#rePassword').val()
        console.log(oldPassword)
        //表单数据对象
        // let formData = new FormData();
        //表单数据提交可以理解为键值对,key(input的name属性),value(input框的值)
        // formData.append("passwordStr", JSON.stringify(password))

        $.ajax({
            url: editPasswordUrl,
            type: 'post',
            async: false,
            cache: false,
            datatype: 'json',
            //默认:application/x-www-form-urlencoded(字符串)
            // contentType: false,
            contentType:'application/json;charset=utf-8',
            // processData: false,
            // data: formData,
            data:JSON.stringify({
                oldPassword:oldPassword,
                newPassword:newPassword,
                rePassword:rePassword,
            }),
            success: function (data) {
                if (data.success) {
                    lightyear.notify('修改成功~', 'success', 500,
                        'mdi mdi-emoticon-happy', 'top', 'center', '/login')
                } else {
                    lightyear.notify(data.errMsg, 'danger', 500,
                        'mdi mdi-emoticon-dead', 'top', 'center')
                }
            }
        })
    })
})