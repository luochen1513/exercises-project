$(function () {
    //定义渲染列表条件
    let request_condition = {}
    //是否初始化分页插件
    let flag = true
    /**
     * 图书页面,筛选下拉框
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
            let type = $('#search-field').val()
            let keyword = $('#search-input').val();
            if (type === 'name') {
                request_condition.name = keyword
                request_condition.publish = null
                getList(request_condition)
            } else {
                request_condition.publish = keyword
                request_condition.name = null
                getList(request_condition)
            }
        }
    })

    /**
     * 初始化图书列表
     */
    getList(request_condition)

    /**
     * 获取图书列表
     */
    function getList(data) {
        $.ajax({
            url: '/userBook/recommendBook',
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
                    // 初始化分页插件
                    if (flag) {
                        getPageInfo(data.data)
                        flag = false
                    }
                    handleList(data.data)
                    if (data.data.length === 0) {
                        lightyear.notify('没有符合条件的图书~', 'danger', 500,
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
        for (let j = 0; j < data.length; j++) {
            html += '<tr style="margin-left: 5px">'
                + '<td>' + (i++) + '</td>'
                + '<td data-toggle="tooltip" title=' + data[j].name + '>' + data[j].name + '</td>'
                + '<td data-toggle="tooltip" title=' + data[j].score + '>' + data[j].score + '</td>'
                + '<td data-toggle="tooltip" title=' + data[j].price + '>' + data[j].price + '</td>'
                + '<td data-toggle="tooltip" title=' + data[j].publish + '>' + data[j].publish + '</td>'
                + '<td>'
                + '<div class="btn-group">'
                + '<a class="btn btn-xs btn-default" href="/book/selectBook?bookid=' + data[j].bookid + '" title="详情" data-toggle="tooltip"><i class="mdi mdi-eye"></i></a>'
                + '</div>'
                + '</td>'
                + '</tr>'
        }
        //替换
        $('.book-wrap').html(html)
    }

    /**
     * 获取分页信息
     * coping:是否显示首尾页
     */
    function getPageInfo(data) {
        //初始化分页插件
        $('#jq-page').pagination({
            pageCount: 1,
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
     * 增删改查图书信息
     */
        //查询图书
    let selectBook = '/book/bookSelect'
    //添加用户的图书
    let insertUserBook = '/userBook/userBookInsert'

    let bookid = getQueryParam('bookid')
    // let is_edit = getQueryParam("edit")
    /**
     * 如果可以从url获取bookid,用户不是在查看,就是在编辑,或者是删除
     */
    if (bookid) {
        //需要从后端获取bookid对应信息,并渲染前端页面
        $.post(selectBook, {bookid: bookid}, function (data) {
            if (data.success) {
                let book = data.data
                $('#book-name').val(book.name)
                $('#book-score').val(book.score)
                $('#book-price').val(book.price)
                $('#book-publish').val(book.publish)
            }else {
                lightyear.notify( data.errMsg, 'danger', 500,
                    'mdi mdi-emoticon-dead', 'top', 'center')
            }
        })
    }

    $('.book-wrap').on('click', 'a', function (e) {
        let target = $(e.currentTarget);
        if (target.hasClass('delete-btn')) {
            let bookid = e.currentTarget.dataset.id
            $.ajax({
                url: insertUserBook,
                type: 'post',
                async: false,
                cache: false,
                datatype: 'json',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify({
                    bookid: bookid
                }),
                success: function (data) {
                    if (data.success) {
                        lightyear.notify('添加成功~', 'success', 500,
                            'mdi mdi-emoticon-happy', 'top', 'center')
                        flag = true
                        request_condition.current = 1
                        getList(request_condition)
                    } else {
                        lightyear.notify('添加失败~' + data.errMsg, 'danger', 500,
                            'mdi mdi-emoticon-dead', 'top', 'center')
                    }
                }
            })
        }
    })
});
