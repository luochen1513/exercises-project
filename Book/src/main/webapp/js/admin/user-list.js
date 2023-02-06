$(function () {
    //定义渲染列表条件
    let request_condition = {}
    //是否初始化分页插件
    let flag = true
    /**
     * 用户页面,筛选下拉框
     */
    $('.search-bar .dropdown-menu a').click(function () {
        var field = $(this).data('field') || '';
        $('#search-field').val(field);
        $('#search-btn').html($(this).text() + ' <span class="caret"></span>');
    });

    //监听某个按键按下事件,回车键的码13
    $('#search-input').keydown(function (e) {
        //初始化分页插件
        flag = true
        request_condition.current = 1
        if (e.keyCode === 13) {
            request_condition.username = $('#search-input').val();
            getList(request_condition)
        }
    })

    /**
     * 初始化用户列表
     */
    getList(request_condition)

    /**
     * 获取用户列表
     */
    function getList(data) {
        $.ajax({
            url: '/user/getList',
            type: 'post',
            async: false,
            cache: false,
            datatype: 'json',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(data),
            success: function (data) {
                if (data.success) {
                    /**
                     * 获取列表数据,进行动态渲染
                     */
                    //初始化分页插件
                    if (flag) {
                        getPageInfo(data.data)
                        flag = false
                    }
                    handleList(data.data.records)
                    if (data.data.records.length === 0) {
                        lightyear.notify('没有符合条件的用户~', 'danger', 500,
                            'mdi mdi-emoticon-sad', 'top', 'center')
                    }
                } else {
                    //TODO:提醒
                    lightyear.notify('查询失败~', 'danger', 500,
                        'mdi mdi-emoticon-dead', 'top', 'center')
                }
            }
        })
    }

    /**
     * 渲染列表数据
     * @param data
     */
    function handleList(data) {
        let html = ''
        let i = 1
        //遍历渲染
        data.map(function (item, index) {
            function sexNull() {
                if (item.sex === null) {
                    return '<td data-toggle="tooltip" title=' + item.sex + '></td>'
                } else {
                    return '<td data-toggle="tooltip" title=' + item.sex + '>' + item.sex + '</td>'
                }
            }

            function emailNull() {
                if (item.email === null) {
                    return '<td data-toggle="tooltip" title=' + item.email + '></td>'
                } else {
                    return '<td data-toggle="tooltip" title=' + item.email + '>' + item.email + '</td>'
                }
            }

            function phoneNull() {
                if (item.phone === null) {
                    return '<td data-toggle="tooltip" title=' + item.phone + '></td>'
                } else {
                    return '<td data-toggle="tooltip" title=' + item.phone + '>' + item.phone + '</td>'
                }
            }

            html += '<tr style="margin-left: 5px">'
                + '<td>' + (i++) + '</td>'
                + '<td data-toggle="tooltip" title=' + item.username + '>' + item.username + '</td>'
                + sexNull()
                + emailNull()
                + phoneNull()
                + '<td>'
                + '<div class="btn-group">'
                + '<a class="btn btn-xs btn-default" href="/user/selectUser?userId=' + item.userId + '" title="详情" data-toggle="tooltip"><i class="mdi mdi-eye"></i></a>'
                + '<a class="btn btn-xs btn-default" href="/user/userUpdate?edit=true&userId=' + item.userId + '" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>'
                + '<a class="btn btn-xs btn-default delete-btn" href="#!" title="删除" data-id="' + item.userId + '" data-toggle="tooltip"><i class="mdi mdi-delete"></i></a>'
                + '</div>'
                + '</td>'
                + '</tr>'
        })
        //替换
        $('.user-wrap').html(html)
    }

    /**
     * 获取分页信息
     * coping:是否显示首尾页
     */
    function getPageInfo(data) {
        //初始化分页插件
        $('#jq-page').pagination({
            pageCount: data.pages,
            coping: true,
            //触发分页的按钮
            callback: function (e) {
                //获取用户当前点击的页数,作为参数传给getList
                request_condition.current = e.getCurrent()
                getList(request_condition)
            }
        })
    }

    /**
     * 增删改查用户信息
     */
        //添加用户
    let insertUser = '/user/userInsert'
    //查询用户
    let selectUser = '/user/userSelect'
    //修改用户
    let updateUser = '/user/updateUser'
    //删除用户
    let deleteUser = '/user/userDelete'

    let userId = getQueryParam('userId')
    let is_edit = getQueryParam("edit")
    /**
     * 如果可以从url获取bookid,用户不是在查看,就是在编辑,或者是删除
     */
    if (userId) {
        //需要从后端获取bookid对应信息,并渲染前端页面
        $.post(selectUser, {userId: userId}, function (data) {
            if (data.success) {
                let user = data.data
                let sex = user.sex
                $('#username').val(user.username)
                // $('#password').val(user.password)
                if (user.email === null) {
                    $('#email').val(' ')
                } else {
                    $('#email').val(user.email)
                }
                if (user.phone === null) {
                    $('#phone').val(' ')
                } else {
                    $('#phone').val(user.phone)
                }
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
    $('#password').click(function () {
        $.ajax({
            url: '/user/resetPassword',
            type: 'post',
            async: false,
            cache: false,
            datatype: 'json',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify({
                userId: userId
            }),
            success: function (data) {
                if (data.success) {
                    console.log(data.reset)
                    if (data.reset) {
                        lightyear.notify('重置成功~', 'success', 500,
                            'mdi mdi-emoticon-happy', 'top', 'center', '/login')
                    } else {
                        lightyear.notify('重置成功~', 'success', 500,
                            'mdi mdi-emoticon-happy', 'top', 'center', '/user/userList')
                    }
                } else {
                    lightyear.notify('重置失败~' + data.errMsg, 'danger', 500,
                        'mdi mdi-emoticon-dead', 'top', 'center')
                }
            }
        })
    })
    $('.user-wrap').on('click', 'a', function (e) {
        let target = $(e.currentTarget);
        if (target.hasClass('delete-btn')) {
            let userId = e.currentTarget.dataset.id
            $.ajax({
                url: deleteUser,
                type: 'post',
                async: false,
                cache: false,
                datatype: 'json',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify({
                    userId: userId
                }),
                success: function (data) {
                    if (data.success) {
                        lightyear.notify('删除成功~', 'success', 500,
                            'mdi mdi-emoticon-happy', 'top', 'center')
                        flag = true
                        request_condition.current = 1
                        getList(request_condition)
                    } else {
                        lightyear.notify('删除失败~' + data.errMsg, 'danger', 500,
                            'mdi mdi-emoticon-dead', 'top', 'center')
                    }
                }
            })
        }
    })

    let flagSex = 0;
    $('#submit').click(function () {
        if (flagSex === 0) {
            if (is_edit) {
                let username = $('#username').val()
                let email = $('#email').val()
                let phone = $('#phone').val()
                $.ajax({
                    url: updateUser,
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
                            window.location.href = '/user/userList'
                        } else {
                            lightyear.notify('修改失败~' + data.errMsg, 'danger', 500,
                                'mdi mdi-emoticon-dead', 'top', 'center')
                        }
                    }
                })
            }
        }
    })
    $('#sex').change(function (e) {
        let sex = $('#sex').find('option').not(
            function () {
                return !this.selected
            }
        ).text()
        flagSex = 1
        $('#submit').click(function () {
            if (flagSex === 1) {
                if (is_edit) {
                    let username = $('#username').val()
                    let email = $('#email').val()
                    let phone = $('#phone').val()
                    $.ajax({
                        url: updateUser,
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
                                window.location.href = '/user/userList'
                            } else {
                                lightyear.notify('修改失败~' + data.errMsg, 'danger', 500,
                                    'mdi mdi-emoticon-dead', 'top', 'center')
                            }
                        }
                    })
                }
            }
        })
    })

    $('#submit-insert').click(function () {
        let username = $('#username').val()
        let password = $('#password').val()
        let sex = $('#sex').val()
        let email = $('#email').val()
        let phone = $('#phone').val()
        $.ajax({
            url: insertUser,
            type: 'post',
            async: false,
            cache: false,
            datatype: 'json',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify({
                username: username,
                password: password,
                sex: sex,
                email: email,
                phone: phone
            }),
            success: function (data) {
                if (data.success) {
                    lightyear.notify('添加成功~', 'success', 500,
                        'mdi mdi-emoticon-happy', 'top', 'center','/user/userList')
                }else {
                    lightyear.notify('添加失败~' + data.errMsg, 'danger', 500,
                        'mdi mdi-emoticon-dead', 'top', 'center')
                }
            }
        })
    })
});
