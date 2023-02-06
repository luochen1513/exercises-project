$(function () {
    $('#logout').click(function () {
        //清空session
        $.ajax({
            url: 'logout',
            type: "post",
            async: false,
            cache: false,
            datatype: 'json',
            success: function (data) {
                if (data.success) {
                    window.location.href = '/login'
                }
            },
            error: function (data, error) {
                alert(error)
            }
        })
    })
})