<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Racing+ 后台主题UI框架 - 主页</title>
    <meta name="keywords" content="Racing+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="Racing+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

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
    <script src="/res/news/js/plugins/sweetalert/sweetalert.min.js"></script>
    <link href="/res/news/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <script>
        $(document).ready(function () {

        };
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
                    <h5>菜单管理</h5>
                    <div class="ibox-tools">
                    </div>
                </div>
                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>比赛时间</th>
                            <th>比赛结果</th>
                            <th>是否有人下注</th>
                            <th>金币共计结算</th>
                            <th>赛车押注分布</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list list as item>
                        <tr class="gradeX">
                            <td>${item_index + 1}</td>
                            <td>${item.userName!}</td>
                            <td>${item.userNickname!}</td>
                            <td>${item.mobile!}</td>
                            <td>${item.email!}</td>
                            <td>${item.total!}</td>
                            <td class="text-navy">
                                <#if item.isDel == 0>
                                    <button class="btn btn-primary" onclick="frozenUser('${item.uuid}')">冻结</button>
                                    <button class="btn btn-primary" onclick="toUpdateUserAmount()">人工编辑</button>
                                <#else >
                                    <button class="btn btn-primary" disabled = disabled onclick="frozenUser('${item.uuid}')">冻结</button>
                                    <button class="btn btn-primary" onclick="toUpdateUserAmount()">人工编辑</button>
                                </#if>
                                <button class="btn btn-primary" onclick="toUserLogs('${item.uuid}')" data-toggle="modal" data-target="#myModal_${item.uuid}">比赛详情</button>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>

    </div>
</div>
</body>

<script type="text/javascript">
    function toUserLogs(userUuid) {
        window.location.href="/racingcms/ruser/listUserLogs?uuid="+userUuid;
    }
    function toUpdateUserAmount() {
        swal({
            title: "暂时不支持直接修改用户账户",
            text: "请联系管理员开发此功能！"
        });
    }
    function frozenUser(useruuid){
        swal({
            title: "暂时不支持冻结用户账户",
            text: "请联系管理员开发此功能！"
        });
    }
</script>

</html>