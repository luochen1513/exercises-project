$(function () {

    refresh();

    resetDesc();

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
})

function refresh() {
    /*
        柱状图
    */
    $.ajax({
        //请求路径
        url: '/people/queryChinaNumber',
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
        //回调函数
        success: function (data) {
            let peopleChart = echarts.init(document.getElementById('peopleBar'));
            let option = {
                title: {
                    text: '人口普查'
                },
                tooltip: {},
                legend: {
                    data: ['总人口数量']
                },
                xAxis: {
                    name: '年份',
                    data: [2017, 2018, 2019, 2020, 2021]
                },
                yAxis: {
                    name: '/万',
                },
                series: [{
                    name: '总人口数量',
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
        折线图
     */
    $.ajax({
        //请求路径
        url: '/people/queryChinaNumber',
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
        //回调函数
        success: function (data) {
            let peopleChart = echarts.init(document.getElementById('peopleLine'));
            let option = {
                title: {
                    text: '人口普查'
                },
                tooltip: {},
                legend: {
                    data: ['总人口数量']
                },
                xAxis: {
                    name: '年份',
                    data: [2017, 2018, 2019, 2020, 2021]
                },
                yAxis: {
                    name: '/万',
                },
                series: [{
                    name: '总人口数量',
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
        url: '/people/queryChinaNumber',
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
        //回调函数
        success: function (data) {
            function queryNumber(year) {
                var numberList = data.number;
                var yearList = data.year;
                var index = yearList.indexOf(year);
                return numberList[index]
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
                        name: "人口占比/年",
                        type: "pie",
                        radius: [0, 80],
                        center: ['50%', '46%'],
                        data: [
                            {name: '2021', value: queryNumber(2021)},
                            {name: '2020', value: queryNumber(2020)},
                            {name: '2019', value: queryNumber(2019)},
                            {name: '2018', value: queryNumber(2018)},
                            {name: '2017', value: queryNumber(2017)},
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

    /*
        矩树图
    */
    $.ajax({
        //请求路径
        url: '/people/queryChinaNumber',
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
        //回调函数
        success: function (data) {

            function avgNumber(year) {
                let sum = queryNumber(2021) + queryNumber(2020) + queryNumber(2019) +
                    queryNumber(2018) + queryNumber(2017)
                let avg = (queryNumber(year) / sum) * 100
                return avg
            }

            function queryNumber(year) {
                var numberList = data.number;
                var yearList = data.year;
                var index = yearList.indexOf(year);
                return numberList[index]
            }

            let peopleChart = echarts.init(document.getElementById('peopleMap'));
            let option = {
                title: {
                    text: "总人口数量",
                    left: "left",
                    top: "bottom",
                },
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b} : {c}%",
                },
                toolbox: {
                    orient: "vertical",
                    top: "center",
                    feature: {
                        dataView: {readOnly: false},
                        restore: {},
                        saveAsImage: {},
                    },
                },
                legend: {
                    orient: "vertical",
                    left: "left",
                    data: data.year
                },
                calculable: true,
                series: [
                    {
                        name: "漏斗",
                        type: "funnel",
                        width: "40%",
                        height: "45%",
                        left: "5%",
                        top: "50%",
                        data: [
                            {name: '2021', value: avgNumber(2021)},
                            {name: '2020', value: avgNumber(2020)},
                            {name: '2019', value: avgNumber(2019)},
                            {name: '2018', value: avgNumber(2018)},
                            {name: '2017', value: avgNumber(2017)},
                        ],
                    },
                    {
                        name: "金字塔",
                        type: "funnel",
                        width: "40%",
                        height: "45%",
                        left: "5%",
                        top: "5%",
                        sort: "ascending",
                        data: [
                            {name: '2021', value: avgNumber(2021)},
                            {name: '2020', value: avgNumber(2020)},
                            {name: '2019', value: avgNumber(2019)},
                            {name: '2018', value: avgNumber(2018)},
                            {name: '2017', value: avgNumber(2017)},
                        ],
                    },
                    {
                        name: "漏斗",
                        type: "funnel",
                        width: "40%",
                        height: "45%",
                        left: "55%",
                        top: "5%",
                        label: {
                            normal: {
                                position: "left",
                            },
                        },
                        data: [
                            {name: '2021', value: avgNumber(2021)},
                            {name: '2020', value: avgNumber(2020)},
                            {name: '2019', value: avgNumber(2019)},
                            {name: '2018', value: avgNumber(2018)},
                            {name: '2017', value: avgNumber(2017)},
                        ],
                    },
                    {
                        name: "金字塔",
                        type: "funnel",
                        width: "40%",
                        height: "45%",
                        left: "55%",
                        top: "50%",
                        sort: "ascending",
                        label: {
                            normal: {
                                position: "left",
                            },
                        },
                        data: [
                            {name: '2021', value: avgNumber(2021)},
                            {name: '2020', value: avgNumber(2020)},
                            {name: '2019', value: avgNumber(2019)},
                            {name: '2018', value: avgNumber(2018)},
                            {name: '2017', value: avgNumber(2017)},
                        ],
                    },
                ],
            };
            peopleChart.setOption(option);
            window.onresize = function () {
                peopleChart.resize();
            }
        }
    })
}

function resetDesc() {

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
