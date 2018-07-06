<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 主页</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/res/news/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="/res/news/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <!-- Morris -->
    <link href="/res/news/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="/res/news/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="/res/news/css/animate.min.css" rel="stylesheet">
    <link href="/res/news/css/style.min.css?v=4.0.0" rel="stylesheet">
    <base target="_blank">

    <script src="/res/news/js/jquery.min.js?v=2.1.4"></script>
    <script src="/res/news/js/bootstrap.min.js?v=3.3.5"></script>
    <script src="/res/news/js/plugins/flot/jquery.flot.js"></script>
    <script src="/res/news/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="/res/news/js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="/res/news/js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="/res/news/js/plugins/flot/jquery.flot.pie.js"></script>
    <script src="/res/news/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="/res/news/js/demo/peity-demo.min.js"></script>
    <script src="/res/news/js/content.min.js?v=1.0.0"></script>
    <script src="/res/news/js/plugins/jquery-ui/jquery-ui.min.js"></script>
    <script src="/res/news/js/plugins/gritter/jquery.gritter.min.js"></script>
    <script src="/res/news/js/plugins/easypiechart/jquery.easypiechart.js"></script>
    <script src="/res/news/js/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="/res/news/js/demo/sparkline-demo.min.js"></script>
    <script>
        $(document).ready(function () {
//            释放后用于添加个人信箱部分
//            WinMove();
//            setTimeout(function () {
//                $.gritter.add({
//                    title: "您有2条未读信息", text: '请前往<a href="mailbox.html" class="text-warning">收件箱</a>查看今日任务', time: 10000
//                })
//            }, 2000);
//            $(".chart").easyPieChart({barColor: "#f8ac59", scaleLength: 5, lineWidth: 4, size: 80});
//            $(".chart2").easyPieChart({barColor: "#1c84c6", scaleLength: 5, lineWidth: 4, size: 80});
//            var data1 = [[0, 4], [1, 8], [2, 5], [3, 10], [4, 4], [5, 16], [6, 5], [7, 11], [8, 6], [9, 11], [10, 30], [11, 10], [12, 13], [13, 4], [14, 3], [15, 3], [16, 6]];
//            var data2 = [[0, 1], [1, 0], [2, 2], [3, 0], [4, 1], [5, 3], [6, 1], [7, 5], [8, 2], [9, 3], [10, 2], [11, 1], [12, 0], [13, 2], [14, 8], [15, 0], [16, 0]];
//            $("#flot-dashboard-chart").length && $.plot($("#flot-dashboard-chart"), [data1, data2], {
//                series: {
//                    lines: {
//                        show: false,
//                        fill: true
//                    },
//                    splines: {show: true, tension: 0.4, lineWidth: 1, fill: 0.4},
//                    points: {radius: 0, show: true},
//                    shadowSize: 2
//                },
//                grid: {hoverable: true, clickable: true, tickColor: "#d5d5d5", borderWidth: 1, color: "#d5d5d5"},
//                colors: ["#1ab394", "#464f88"],
//                xaxis: {},
//                yaxis: {ticks: 4},
//                tooltip: false
//            })
        });
    </script>
    <!-- 注入腾讯分析服务 http://ta.qq.com/analysis/function -->
    <#--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>-->

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>所有表单元素
                        <small>填写 公众号ID，点击 保存 按钮， 系统将自动生成 URL 和 Token 。将它们填写到公众平台 开发者中心 中，公众账号即可升级成为开发者账号</small>
                    </h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="form_basic.html#">选项1</a>
                            </li>
                            <li><a href="form_basic.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form method="get" class="form-horizontal" action="/wxcms/getUrl" id="tokenurl_form">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">公众号ID</label>
                            <div class="col-sm-6">
                                <input type="hidden" name="id" value="${(account.id)!''}"/>
                                <input type="text" placeholder="公众号ID简介" class="form-control" id="account_id" name="account" value="${(account.account)!''}">
                            </div>
                            <span class="input-group-btn">
                                <#if (account.id)??> //判断对象中的id不为空
                                    <button disabled="disabled" id="createBtn" type="button" class="btn btn-primary">自动生成</button>
                                <#else >
                                    <button id="createBtn" type="button" class="btn btn-primary">自动生成</button>
                                </#if>
                            </span>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">URL</label>
                            <div class="col-sm-6">
                                <input type="text" placeholder="URL简介" class="form-control" id="url_id" name="url" value="${(account.url)!''}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">TOKEN</label>
                            <div class="col-sm-6">
                                <input type="text" placeholder="TOKEN简介" class="form-control" id="token_id" name="token" value="${(account.token)!''}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">APPID</label>
                            <div class="col-sm-6">
                                <input type="text" placeholder="APPID简介" class="form-control" id="appid_id" name="appid" value="${(account.appid)!''}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">APPSecret</label>
                            <div class="col-sm-6">
                                <input type="text" placeholder="APPSecret简介" class="form-control" id="appsecret_id" name="appsecret" ${(account.appsecret)!''}>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">回复图文消息条数</label>
                            <div class="col-sm-6">
                                <select class="form-control m-b" name="msgcount" id="msgcount_id" value="${(account.msgcount)!''}">
                                    <#if (account.msgcount)??>
                                        <#if (account.msgcount) == 1>
                                            <option value="1" selected >1</option>
                                        <#else >
                                            <option value="1">1</option>
                                        </#if>
                                        <#if (account.msgcount) == 2>
                                            <option value="2" selected >2</option>
                                        <#else >
                                            <option value="2">2</option>
                                        </#if>
                                        <#if (account.msgcount) == 3>
                                            <option value="3" selected >3</option>
                                        <#else >
                                            <option value="3">3</option>
                                        </#if>
                                        <#if (account.msgcount) == 4>
                                            <option value="4" selected >4</option>
                                        <#else >
                                            <option value="4">4</option>
                                        </#if>
                                        <#if (account.msgcount) == 5>
                                            <option value="5" selected >5</option>
                                        <#else >
                                            <option value="5">5</option>
                                        </#if>
                                    <#else >
                                        <option value="1" selected >1</option>
                                    </#if>
                                </select>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="button" id="tokenurl_form_sub">保存</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</body>

<script type="text/javascript">
    $("#createBtn").click(function () {
        //提交当前的表单中的信息至/wxcms/getUrl/中去，跳转刷新本页面
        $.ajax({
            //几个参数需要注意一下
            type: "POST",
            //预期服务器返回的数据类型
            dataType: "json",
            url: "/wxcms/getUrl" ,
            data: $('#tokenurl_form').serialize(),
            success: function (result) {
                //打印服务端返回的数据(调试用)
                console.log(result);
                if (result.code == 0) {
                    if(result.msg == 'add success'){
                        alert("微信所需链接生成完毕");
                    }else {
                        alert("资料已更新");
                    }
                };
            },
            error : function() {
                alert("ajax异常，请联系网络管理员!！");
            }
        });
        this.iframe.refresh();
    });
    $("#tokenurl_form_sub").click(function () {
        //提交当前的表单中的信息至/wxcms/getUrl/中去，跳转刷新本页面
        $.ajax({
            //几个参数需要注意一下
            type: "POST",
            //预期服务器返回的数据类型
            dataType: "json",
            url: "/wxcms/getUrl" ,
            data: $('#tokenurl_form').serialize(),
            success: function (result) {
                //打印服务端返回的数据(调试用)
                console.log(result);
                if (result.code == 0) {
                    if(result.msg == 'add success'){
                        alert("微信所需链接生成完毕");
                    }else {
                        alert("资料已更新");
                    }
                };
            },
            error : function() {
                alert("ajax异常，请联系网络管理员!！");
            }
        });
        this.iframe.refresh();
    });
</script>

</html>