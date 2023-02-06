$(function () {

    loadYear();

    function loadYear() {
        let year = 2020
        refresh(year);
        getList(year);
        updateList(year);
        refresh(year);
        resetDesc(year);
    }

    $('#2021').click(function () {
        let year = $('#2021').text().substring(0,4);
        window.location.href = '/people/' + year + '.html'
    })

    $('#2020').click(function () {
        let year = $('#2020').text().substring(0,4);
        window.location.href = '/people/' + year + '.html'
    })

    $('#2019').click(function () {
        let year = $('#2019').text().substring(0,4);
        window.location.href = '/people/' + year + '.html'
    })

    $('#2018').click(function () {
        let year = $('#2018').text().substring(0,4);
        window.location.href = '/people/' + year + '.html'
    })

    $('#2017').click(function () {
        let year = $('#2017').text().substring(0,4);
        window.location.href = '/people/' + year + '.html'
    })

    $('#downBar').click(function () {
        window.location.href = '/people/China.html'
    })

    $('#downLine').click(function () {
        window.location.href = '/people/China.html'
    })
})

function updateButton() {
    $('#number').removeAttr("disabled")
}

function refresh(year) {
    /*
        柱状图
    */
    $.ajax({
        //请求路径
        url: '/people/chinaPeople',
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
        data: {
            year: year
        },
        //回调函数
        success: function (data) {
            let peopleChart = echarts.init(document.getElementById('peopleBar'));
            let option = {
                title: {
                    text: '人口普查'
                },
                tooltip: {},
                legend: {
                    data: ['人口数量']
                },
                xAxis: {
                    name: '省份',
                    data: data.province
                },
                yAxis: {
                    name: '/万',
                },
                series: [{
                    name: '人口数量',
                    type: 'bar',
                    data: data.number
                }]
            };
            peopleChart.setOption(option);
            window.onresize = function () {
                peopleChart.resize();
            }
        }
    })

    /*
        地图
     */
    $.ajax({
        //请求路径
        url: '/people/chinaPeople',
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
        data: {
            year: year
        },
        //回调函数
        success: function (data) {
            function queryNumber(province) {
                let provinceList = data.province
                let numberList = data.number
                let index = provinceList.indexOf(province);
                return numberList[index];
            }

            var myChart = echarts.init(document.getElementById('peopleMap'));
            var option = {
                title: {
                    text: '人口数量',
                    x: 'center'
                },
                tooltip: {//提示框组件。
                    trigger: 'item'//数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。
                },
                legend: {
                    orient: 'horizontal',//图例的排列方向
                    x: 'left',//图例的位置
                    data: ['人口数量']
                },

                visualMap: {//颜色的设置  dataRange
                    x: 'left',
                    y: '120',
                    splitList: [
                        {start: 12000},
                        {start: 9000, end: 12000},
                        {start: 3000, end: 9000},
                        {start: 2000, end: 3000},
                        {start: 100, end: 2000, label: '10 到 200（自定义label）'},
                        {start: 5, end: 5, label: '5（自定义特殊颜色）', color: 'black'},
                        {end: 10}
                    ],
                    //            min: 0,
                    //            max: 2500,
                    //            calculable : true,//颜色呈条状
                    text: ['高', '低'],// 文本，默认为数值文本
                    color: ['#E0022B', '#E09107', '#A3E00B']
                },
                toolbox: {//工具栏
                    show: true,
                    orient: 'vertical',//工具栏 icon 的布局朝向
                    x: 'right',
                    y: 'center',
                    feature: {//各工具配置项。
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},//数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新。
                        restore: {show: true},//配置项还原。
                        saveAsImage: {show: true}//保存为图片。
                    }
                },
                roamController: {//控制地图的上下左右放大缩小 图上没有显示
                    show: true,
                    x: 'right',
                    mapTypeControl: {
                        'china': true
                    }
                },
                series: [
                    {
                        name: '人口数量',
                        type: 'map',
                        mapType: 'china',
                        roam: true,//是否开启鼠标缩放和平移漫游
                        itemStyle: {//地图区域的多边形 图形样式
                            normal: {//是图形在默认状态下的样式
                                label: {
                                    show: true,//是否显示标签
                                    textStyle: {
                                        color: "rgb(249, 249, 249)"
                                    }
                                }
                            },
                            emphasis: {//是图形在高亮状态下的样式,比如在鼠标悬浮或者图例联动高亮时
                                label: {show: true}
                            }
                        },
                        top: "15%",//组件距离容器的距离
                        data: [
                            {name: '北京', value: queryNumber("北京")},
                            {name: '天津', value: queryNumber("天津")},
                            {name: '上海', value: queryNumber("上海")},
                            {name: '重庆', value: queryNumber("重庆")},
                            {name: '河北', value: queryNumber("河北")},
                            {name: '河南', value: queryNumber("河南")},
                            {name: '云南', value: queryNumber("云南")},
                            {name: '辽宁', value: queryNumber("辽宁")},
                            {name: '黑龙江', value: queryNumber("黑龙江")},
                            {name: '湖南', value: queryNumber("湖南")},
                            {name: '安徽', value: queryNumber("安徽")},
                            {name: '山东', value: queryNumber("山东")},
                            {name: '新疆', value: queryNumber("新疆")},
                            {name: '江苏', value: queryNumber("江苏")},
                            {name: '浙江', value: queryNumber("浙江")},
                            {name: '江西', value: queryNumber("江西")},
                            {name: '湖北', value: queryNumber("湖北")},
                            {name: '广西', value: queryNumber("广西")},
                            {name: '甘肃', value: queryNumber("甘肃")},
                            {name: '山西', value: queryNumber("山西")},
                            {name: '内蒙古', value: queryNumber("内蒙古")},
                            {name: '陕西', value: queryNumber("陕西")},
                            {name: '吉林', value: queryNumber("吉林")},
                            {name: '福建', value: queryNumber("福建")},
                            {name: '贵州', value: queryNumber("贵州")},
                            {name: '广东', value: queryNumber("广东")},
                            {name: '青海', value: queryNumber("青海")},
                            {name: '西藏', value: queryNumber("西藏")},
                            {name: '四川', value: queryNumber("四川")},
                            {name: '宁夏', value: queryNumber("宁夏")},
                            {name: '海南', value: queryNumber("海南")},
                            {name: '台湾', value: queryNumber("台湾")},
                            {name: '香港', value: queryNumber("香港")},
                            {name: '澳门', value: queryNumber("澳门")}
                        ]
                    }
                ]
            };
            myChart.setOption(option);
            myChart.on('mouseover', function (params) {
                var dataIndex = params.dataIndex;
            });
            window.onresize = function () {
                myChart.resize();
            }
        }
    })

    /*
        折线图
     */
    $.ajax({
        //请求路径
        url: '/people/chinaPeople',
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
        data: {
            year: year
        },
        //回调函数
        success: function (data) {
            let peopleChart = echarts.init(document.getElementById('peopleLine'));
            let option = {
                title: {
                    text: '人口普查'
                },
                tooltip: {},
                legend: {
                    data: ['人口数量']
                },
                xAxis: {
                    name: '省份',
                    data: data.province
                },
                yAxis: {
                    name: '/万',
                },
                series: [{
                    name: '人口数量',
                    type: 'line',
                    data: data.number
                }]
            };
            peopleChart.setOption(option);
            window.onresize = function () {
                peopleChart.resize();
            }
        }
    })

    /*
        饼图
     */
    $.ajax({
        //请求路径
        url: '/people/chinaPeople',
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
        data: {
            year: year
        },
        //回调函数
        success: function (data) {
            function queryNumber(province) {
                let provinceList = data.province
                let numberList = data.number
                let index = provinceList.indexOf(province);
                return numberList[index];
            }

            var myChart = echarts.init(document.getElementById('peoplePie'));
            option = {
                color: [
                    "#37a2da",
                    "#32c5e9",
                    "#9fe6b8",
                    "#ffdb5c",
                    "#ff9f7f",
                    "#fb7293",
                    "#e7bcf3",
                    "#8378ea",
                ],
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b} : {c} ({d}%)",
                },
                toolbox: {
                    show: true,
                },
                legend: {
                    type: "scroll",
                    orient: "vertical",
                    left: "0",
                    align: "right",
                    top: "260",
                    textStyle: {
                        color: "#8C8C8C",
                    },
                    height: 60,
                },
                series: [
                    {
                        name: "人口数量",
                        type: "pie",
                        radius: [0, 80],
                        center: ['50%', '46%'],
                        data: [
                            {name: '北京', value: queryNumber("北京")},
                            {name: '天津', value: queryNumber("天津")},
                            {name: '上海', value: queryNumber("上海")},
                            {name: '重庆', value: queryNumber("重庆")},
                            {name: '河北', value: queryNumber("河北")},
                            {name: '河南', value: queryNumber("河南")},
                            {name: '云南', value: queryNumber("云南")},
                            {name: '辽宁', value: queryNumber("辽宁")},
                            {name: '黑龙江', value: queryNumber("黑龙江")},
                            {name: '湖南', value: queryNumber("湖南")},
                            {name: '安徽', value: queryNumber("安徽")},
                            {name: '山东', value: queryNumber("山东")},
                            {name: '新疆', value: queryNumber("新疆")},
                            {name: '江苏', value: queryNumber("江苏")},
                            {name: '浙江', value: queryNumber("浙江")},
                            {name: '江西', value: queryNumber("江西")},
                            {name: '湖北', value: queryNumber("湖北")},
                            {name: '广西', value: queryNumber("广西")},
                            {name: '甘肃', value: queryNumber("甘肃")},
                            {name: '山西', value: queryNumber("山西")},
                            {name: '内蒙古', value: queryNumber("内蒙古")},
                            {name: '陕西', value: queryNumber("陕西")},
                            {name: '吉林', value: queryNumber("吉林")},
                            {name: '福建', value: queryNumber("福建")},
                            {name: '贵州', value: queryNumber("贵州")},
                            {name: '广东', value: queryNumber("广东")},
                            {name: '青海', value: queryNumber("青海")},
                            {name: '西藏', value: queryNumber("西藏")},
                            {name: '四川', value: queryNumber("四川")},
                            {name: '宁夏', value: queryNumber("宁夏")},
                            {name: '海南', value: queryNumber("海南")},
                            {name: '台湾', value: queryNumber("台湾")},
                            {name: '香港', value: queryNumber("香港")},
                            {name: '澳门', value: queryNumber("澳门")}
                        ],
                    },
                ],
            };
            myChart.setOption(option);
            window.onresize = function () {
                myChart.resize();
            }
        }
    })
}

function getList(year) {
    $.ajax({
        //请求路径
        url: '/people/peopleList',
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
        data: {
            year: year
        },
        //回调函数
        success: function (data) {
            let peopleList = data.peopleList;
            let optionHtml = '<option id="option" data-value="">全部</option>'
            peopleList.map(function (item, index) {
                optionHtml += '<option id="option" data-value="' + item.id + '">' + item.province + '</option>'
            })
            $('#data').html(optionHtml)
        }
    })
    $('#data').change(function (e) {
        let id = $('#data').find('option').not(
            function () {
                return !this.selected
            }
        ).data("value")
        $.ajax({
            //请求路径
            url: '/people/chinaPeople',
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
            data: {
                year: year
            },
            //回调函数
            success: function (data) {
                let idList = data.id;
                let numberList = data.number;
                let index = idList.indexOf(id.toString());
                $('#number').val(numberList[index])
            }
        })
    })
}

function updateList(year) {
    $('#submit').click(function () {
        console.log(year)
        let province = $('#data').val();
        let number = $('#number').val();
        $.ajax({
            //请求路径
            url: '/people/updatePeople',
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
                province: province,
                number: number,
                year: year
            }),
            //回调函数
            success: function () {
                refresh(year);
                $('#number').attr("disabled", true)
            }
        })
    })
}

function resetDesc(year) {

    $('#descBar').click(function () {
        /*
            柱状图
        */
        $.ajax({
            //请求路径
            url: '/people/sortPeople',
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
            data: {
                year: year
            },
            //回调函数
            success: function (data) {
                let peopleChart = echarts.init(document.getElementById('peopleBar'));
                let option = {
                    title: {
                        text: '人口普查'
                    },
                    tooltip: {},
                    legend: {
                        data: ['人口数量']
                    },
                    xAxis: {
                        name: '省份',
                        // data: ['广东', '山东', '河南', '四川', '江苏', '河北', '湖南', '安徽', '湖北', '浙江', '广西', '云南',
                        //     '江西', '辽宁', '黑龙江', '陕西', '福建', '山西', '贵州', '重庆', '吉林', '甘肃', '内蒙古', '台湾',
                        //     '上海', '新疆', '北京', '天津', '海南', '宁夏', '青海', '西藏']
                        data: data.province
                    },
                    yAxis: {
                        name: '/万',
                    },
                    series: [{
                        name: '人口数量',
                        type: 'bar',
                        // data: data.number.sort(function (a, b) {
                        //     return b - a;
                        // })
                        data: data.number
                    }]
                };
                peopleChart.setOption(option);
                window.onresize = function () {
                    peopleChart.resize();
                }
            }
        })
    })

    $('#descLine').click(function () {
        /*
            折线图
         */
        $.ajax({
            //请求路径
            url: '/people/sortPeople',
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
            data: {
                year: year
            },
            //回调函数
            success: function (data) {
                let peopleChart = echarts.init(document.getElementById('peopleLine'));
                let option = {
                    title: {
                        text: '人口普查'
                    },
                    tooltip: {},
                    legend: {
                        data: ['人口数量']
                    },
                    xAxis: {
                        name: '省份',
                        data: data.province
                    },
                    yAxis: {
                        name: '/万',
                    },
                    series: [{
                        name: '人口数量',
                        type: 'line',
                        data: data.number
                    }]
                };
                peopleChart.setOption(option);
                window.onresize = function () {
                    peopleChart.resize();
                }
            }
        })
    })

    $('#resetBar').click(function () {
        /*
            柱状图
        */
        $.ajax({
            //请求路径
            url: '/people/chinaPeople',
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
            data: {
                year: year
            },
            //回调函数
            success: function (data) {
                let peopleChart = echarts.init(document.getElementById('peopleBar'));
                let option = {
                    title: {
                        text: '人口普查'
                    },
                    tooltip: {},
                    legend: {
                        data: ['人口数量']
                    },
                    xAxis: {
                        name: '省份',
                        data: data.province
                    },
                    yAxis: {
                        name: '/万',
                    },
                    series: [{
                        name: '人口数量',
                        type: 'bar',
                        data: data.number
                    }]
                };
                peopleChart.setOption(option);
                window.onresize = function () {
                    peopleChart.resize();
                }
            }
        })
    })

    $('#resetLine').click(function () {
        /*
            折线图
         */
        $.ajax({
            //请求路径
            url: '/people/chinaPeople',
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
            data: {
                year: year
            },
            //回调函数
            success: function (data) {
                let peopleChart = echarts.init(document.getElementById('peopleLine'));
                let option = {
                    title: {
                        text: '人口普查'
                    },
                    tooltip: {},
                    legend: {
                        data: ['人口数量']
                    },
                    xAxis: {
                        name: '省份',
                        data: data.province
                    },
                    yAxis: {
                        name: '/万',
                    },
                    series: [{
                        name: '人口数量',
                        type: 'line',
                        data: data.number
                    }]
                };
                peopleChart.setOption(option);
                window.onresize = function () {
                    peopleChart.resize();
                }
            }
        })
    })
}
