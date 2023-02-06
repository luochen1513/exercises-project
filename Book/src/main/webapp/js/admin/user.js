$(function () {

    queryUser();

    function queryUser() {
        //查询用户
        let queryUserUrl = '/user/queryUser'
        $.post(queryUserUrl, function (data) {
            if (data.success) {
                let user = data.data
                let sex = user.sex
                $('#userId').val(user.userId)
                $('#username').val(user.username)
                $('#email').val(user.email)
                $('#phone').val(user.phone)
                if (sex === null) {
                    let optionHtml = '<option id="option" data-value="' + user.userId + '">未选择</option>'
                        + '<option id="option" data-value="' + user.userId + '">男</option>'
                        + '<option id="option" data-value="' + user.userId + '">女</option>'
                    $('#sex').html(optionHtml)
                } else if (sex === "男") {
                    let optionHtml = '<option id="option" data-value="' + user.userId + '">' + user.sex + '</option>'
                        + '<option id="option" data-value="' + user.userId + '">女</option>'
                    $('#sex').html(optionHtml)
                } else {
                    let optionHtml = '<option id="option" data-value="' + user.userId + '">' + user.sex + '</option>'
                        + '<option id="option" data-value="' + user.userId + '">男</option>'
                    $('#sex').html(optionHtml)
                }
            }
        })
    }

    //修改用户
    let editPasswordUrl = '/user/editPassword'

    $('#submit').click(function () {
        let oldPassword = $('#oldPassword').val()
        let newPassword = $('#newPassword').val()
        let rePassword = $('#rePassword').val()
        $.ajax({
            url: editPasswordUrl,
            type: 'post',
            async: false,
            cache: false,
            datatype: 'json',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify({
                oldPassword: oldPassword,
                newPassword: newPassword,
                rePassword: rePassword,
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

    $('.bianji').click(function () {
        window.location.href = '/user/userInfo1'
    })
    $('.quxiao').click(function () {
        window.location.href = '/user/userInfo'
    })
    $('.back').click(function () {
        window.location.href = '/book/bookHouse'
    })

    let flag = 0;
    $('.submit').click(function () {
        if (flag === 0) {
            let userId = $('#userId').val()
            let username = $('#username').val()
            let email = $('#email').val()
            let phone = $('#phone').val()
            $.ajax({
                url: '/user/updateUser',
                type: 'post',
                async: false,
                cache: false,
                datatype: 'json',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify({
                    userId: userId,
                    username: username,
                    email: email,
                    phone: phone
                }),
                success: function (data) {
                    if (data.success) {
                        window.location.href = '/user/userInfo'
                    } else {
                        lightyear.notify(data.errMsg, 'danger', 500,
                            'mdi mdi-emoticon-dead', 'top', 'center')
                    }
                }
            })
        }
    })

    $('#sex').change(function (e) {
        let sex = $('#sex').find('option').not(
            function () {
                return !this.selected
            }
        ).text()
        flag = 1
        $('.submit').click(function () {
            if (flag === 1) {
                let userId = $('#userId').val()
                let username = $('#username').val()
                let email = $('#email').val()
                let phone = $('#phone').val()
                $.ajax({
                    url: '/user/updateUser',
                    type: 'post',
                    async: false,
                    cache: false,
                    datatype: 'json',
                    contentType: 'application/json;charset=utf-8',
                    data: JSON.stringify({
                        userId: userId,
                        username: username,
                        sex: sex,
                        email: email,
                        phone: phone
                    }),
                    success: function (data) {
                        if (data.success) {
                            window.location.href = '/user/userInfo'
                        } else {
                            lightyear.notify(data.errMsg, 'danger', 500,
                                'mdi mdi-emoticon-dead', 'top', 'center')
                        }
                    }
                })
            }
        })
    })
})